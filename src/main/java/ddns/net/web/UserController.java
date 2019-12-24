package ddns.net.web;

import ddns.net.entities.User;
import ddns.net.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RequestMapping("/users")
@Controller
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return new ModelAndView("users","users",users);

    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
