package ddns.net.web;

import ddns.net.entities.Child;
import ddns.net.entities.User;
import ddns.net.service.ChildService;
import ddns.net.service.UserService;
import ddns.net.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RequestMapping("/profile")
@Controller
public class ProfileController {

    private Logger logger = LoggerFactory.getLogger(ProfileController.class);

    private UserService userService;
    private ChildService childService;
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request,
                                Model model,
                                RedirectAttributes redirectAttributes){

        if(request.getRemoteUser() != null){
            User user = userService.findOneByEmail(request.getRemoteUser());
            model.addAttribute("user",user);

            return new ModelAndView("profile");
        }
        Message message = new Message();
        message.setMessage("Cookie expire");
        message.setType("error");

        redirectAttributes.addFlashAttribute("error_message", message);
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addChild(@ModelAttribute Child childModel,
                                 @CookieValue("id") int id,
                                 Locale locale,Model model){

        Message errorMessage = null;
        User user = null;
            if(id > 0){

                user = userService.findOneById(id);
                Child childData = childService.findOneByName(childModel.getName());

                if(childData != null){
                    if(childData.getPass().equals(childModel.getPass())){

                        user.setChild(childData);
                        userService.save(user);
                        return new ModelAndView("redirect:/profile");
                    }
                }
            }
        errorMessage = new Message();
        errorMessage.setMessage(messageSource.getMessage(
                "no.such.child",new Object[]{},locale));
        errorMessage.setType("error");

        model.addAttribute("user",user);
        model.addAttribute("message", errorMessage);
        return new ModelAndView("profile");
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

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
