package ddns.net.web;

import ddns.net.data.entities.Target;
import ddns.net.data.entities.User;
import ddns.net.data.entities.UserWithConfirmPass;
import ddns.net.data.service.TargetService;
import ddns.net.data.service.UserService;
import ddns.net.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("/adding")
public class AddingController {

    private Logger logger = LoggerFactory.getLogger(AddingController.class);

    private UserService userService;
    private MessageSource messageSource;
    private TargetService targetService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(){
        return new ModelAndView("adding");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView post(@ModelAttribute @Valid Target targetAttribute,
                             HttpServletRequest request,
                             HttpServletResponse response,
                             Model model, Locale locale ){

        User user = userService.findOneByEmail(request.getRemoteUser());
        Target target = targetService.findOneByEmail(targetAttribute.getEmail());
        Message message = new Message();
        message.setType("error");

        if(!target.getPass().equals(targetAttribute.getPass())){

            message.setMessage("Mail or password is wrong");
            model.addAttribute("error_message", message );

            return new ModelAndView("adding");
        }else if(user.getTargets().contains(target)){

            message.setMessage("Target already tracked");
            model.addAttribute("error_message", message );

            return new ModelAndView("adding");
        }
        logger.info("Target added. Redirection..");
        user.getTargets().add(target);
        userService.save(user);

        return new ModelAndView("redirect:/tracking");
    }


    @ModelAttribute
    public void init(Model model){
        model.addAttribute("target",new Target());
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @Autowired
    public void setTargetService(TargetService targetService) {
        this.targetService = targetService;
    }
}
