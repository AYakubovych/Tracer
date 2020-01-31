package ddns.net.web;


import ddns.net.entities.User;
import ddns.net.service.UserService;
import ddns.net.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.executable.ValidateOnExecution;
import java.util.Locale;

@PropertySource("classpath:/properties/testUser.properties")
@RequestMapping("/login")
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Value("${mail}")
    private String email;

    @Value("${pass}")
    private String pass;

    private MessageSource messageSource;
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView open(HttpServletResponse response,Locale locale,Model model,
                             @RequestParam(value = "test",defaultValue = "false") boolean test){

        if(test){
            login(response,email,pass,locale,model);
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("login");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(HttpServletResponse response,
                              @RequestParam("email") String email,
                              @RequestParam("pass") String pass,
                              Locale locale, Model model){

        User user = userService.findOneByEmail(email);

        if(user == null || !user.getPass().equals(pass)){
            Message message = new Message();
            message.setType("error");

            message.setMessage(messageSource.getMessage(
                    "login.error",new Object[]{},locale));

            model.addAttribute("error_message", message);

            return new ModelAndView("login");
        }

        Cookie cookie = new Cookie("id",String.valueOf(user.getId()));
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);

        return new ModelAndView("redirect:/profile");
    }


    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
