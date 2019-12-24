package ddns.net.web;


import ddns.net.entities.User;
import ddns.net.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/profile")
@Controller
public class ProfileController {

    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();

        // User user = userService.findOneById();
        return null;
    }



}
