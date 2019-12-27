package ddns.net.web;

import ddns.net.entities.Child;
import ddns.net.entities.User;
import ddns.net.service.ChildService;
import ddns.net.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RequestMapping("/profile")
@Controller
public class ProfileController {

    private UserService userService;

    private ChildService childService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request, Model model){
        Cookie[] cookies = request.getCookies();
        User user;
        for (Cookie cookie: cookies
             ) {
            if(cookie.getName().equals("id")){
                user = userService.findOneById(Integer.parseInt(cookie.getValue()));
                model.addAttribute("user",user);
                if(user.getChild_id() > 0){
                    Child child = childService.findOneById(user.getChild_id());
                    model.addAttribute("child",child);
                }
                return new ModelAndView("profile");
            }
        }
        return new ModelAndView("redirect:/create");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addChild(@ModelAttribute Child child, BindingResult bindingResult,HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        User user;
        for (Cookie cookie: cookies
        ) {
            if(cookie.getName().equals("id")){
                user = userService.findOneById(Integer.parseInt(cookie.getValue()));

                Child child_check = childService.findOneByName(child.getName());
                if(child_check.getPass().equals(child.getPass())){
                    user.setChild_id(child_check.getId());
                    userService.save(user);

                    return new ModelAndView("redirect:/profile");
                }
            }
        }
        return new ModelAndView("redirect:/index");
    }

    @ModelAttribute
    public void init(Model model){
        model.addAttribute("child",new Child());
    }

    @Autowired
    public void setChildService(ChildService childService) {
        this.childService = childService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
