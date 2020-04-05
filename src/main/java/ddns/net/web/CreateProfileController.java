package ddns.net.web;

import ddns.net.data.entities.User;
import ddns.net.data.entities.UserWithConfirmPass;
import ddns.net.data.service.UserService;
import ddns.net.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;


@RequestMapping("/create")
@Controller
public class CreateProfileController {

    private Logger logger = LoggerFactory.getLogger(CreateProfileController.class);

    private UserService userService;
    private MessageSource messageSource;
    private AuthenticationProvider authenticationProvider;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView create(){
        return new ModelAndView("create");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute @Valid UserWithConfirmPass user,
                             BindingResult bindingResult,
                             Model model, Locale locale,
                             HttpServletRequest request){

        Message message = new Message();
        message.setType("error");

        if(userService.findOneByEmail(user.getEmail()) != null ){
            logger.error("User with email: " + user.getEmail() + " already exist");
            return new ModelAndView("redirect:/login");
        }

        //validation
        if(user.getConfirm_pass().equals(user.getPass()) && !bindingResult.hasErrors()){

            User userDAO = new User(user.getName(), user.getLast_name(), user.getEmail(), user.getPass());

            userService.save(userDAO);
            logger.info("User created. User id: " + userDAO.getId());
            //auth here
            doAutoLogin(userDAO.getEmail(),userDAO.getPass(),request);
            logger.info("User authenticated. User e-mail: " + userDAO.getEmail());

            return new ModelAndView("redirect:/profile");

        }else if(!user.getConfirm_pass().equals(user.getPass())){
            //passwords not same
            message.setMessage(messageSource.getMessage("create.form.wrong.confirm.pass",new Object[]{},locale));
            logger.error("Passwords not equal for: " + user.getEmail());

        }else{
            //validation error
            String str = messageSource.getMessage(bindingResult.getAllErrors().get(0),locale);
            message.setMessage(messageSource.getMessage(str, new Object[]{}, locale));
            logger.error("Validation error: " + bindingResult.getAllErrors().get(0));
        }

        model.addAttribute("error_message", message);
        return new ModelAndView("create");
    }

    private void doAutoLogin(String username, String password, HttpServletRequest request) {

        try {
            // Must be called from request filtered by Spring Security, otherwise SecurityContextHolder is not updated
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            token.setDetails(new WebAuthenticationDetails(request));
            Authentication authentication = authenticationProvider.authenticate(token);
            logger.debug("Logging in with [{}]", authentication.getPrincipal());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            SecurityContextHolder.getContext().setAuthentication(null);
            logger.error("Failure in autoLogin", e);
        }

    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @Autowired
    public  void setAuthenticationProvider(AuthenticationProvider authenticationProvider){
        this.authenticationProvider = authenticationProvider;
    }

    @ModelAttribute
    public void init(Model model){
        model.addAttribute("user",new UserWithConfirmPass());
    }
}
