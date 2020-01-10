package ddns.net.web;


import ddns.net.entities.User;
import ddns.net.service.UserService;
import ddns.net.utility.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RequestMapping("/login")
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    private MessageSource messageSource;

    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView open(){
        return new ModelAndView("login");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(HttpServletResponse response, HttpServletRequest request, Locale locale, Model model){

        User user = userService.findOneByEmail(request.getParameter("email"));

        if(user == null || !user.getPass().equals(request.getParameter("pass"))){
            Message message = new Message();
            message.setType("error");

            message.setMessage(messageSource.getMessage(
                    "login.error",new Object[]{},locale));
            model.addAttribute("error_message", message);

            return new ModelAndView("login");
        }

        Cookie cookie = new Cookie("id",Integer.toString(user.getId()));
        cookie.setMaxAge(3600);
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
