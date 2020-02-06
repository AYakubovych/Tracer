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
    private String test_email;

    @Value("${pass}")
    private String test_pass;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView open(HttpServletResponse response,Locale locale,Model model,
                             @RequestParam(value = "test",defaultValue = "false") boolean test){
        if(test){
            
        }

        return new ModelAndView("login");
    }

}
