package ddns.net.web;

import ddns.net.entities.User;
import ddns.net.entities.UserWithConfirmPass;
import ddns.net.service.UserService;
import ddns.net.utility.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Locale;


@RequestMapping("/create")
@Controller
public class CreateProfileController {

    private UserService userService;

    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView create(){
        return new ModelAndView("create");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute @Valid UserWithConfirmPass user, BindingResult bindingResult,
                             Model model, Locale locale, HttpServletResponse response){
        Message message = new Message();
        message.setType("error");

        if(user.getConfirm_pass().equals(user.getPass()) && !bindingResult.hasErrors()){
            User user_to_send = new User(
                    user.getName(),user.getLast_name(),user.getEmail(),user.getPass());
            userService.save(user_to_send);

            Cookie cookie = new Cookie("id",Integer.toString(user_to_send.getId()));
            cookie.setMaxAge(3600);

            response.addCookie(cookie);

            return new ModelAndView("redirect:/profile");

        }else if(!user.getConfirm_pass().equals(user.getPass())){
            message.setMessage(messageSource.getMessage(
                    "create.form.wrong.confirm.pass",new Object[]{},locale));
        }else{
            String str = messageSource.getMessage(bindingResult.getAllErrors().get(0),locale);
            message.setMessage(messageSource.getMessage(
                    str, new Object[]{}, locale));
        }
        model.addAttribute("error_message", message);
        return new ModelAndView("create");
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @ModelAttribute
    public void init(Model model){
        model.addAttribute("user",new UserWithConfirmPass());
    }
}
