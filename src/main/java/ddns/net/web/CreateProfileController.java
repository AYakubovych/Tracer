package ddns.net.web;



import ddns.net.entities.UserWithConfirmPass;
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

import javax.validation.Valid;
import java.util.Locale;


@RequestMapping("/create")
@Controller
public class CreateProfileController {


    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView create(){
        return new ModelAndView("create");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute @Valid UserWithConfirmPass user,BindingResult bindingResult, Model model, Locale locale ){
        Message message = new Message();
        message.setType("error");
        if(user.getConfirm_pass().equals(user.getPass()) && !bindingResult.hasErrors()){
            //Valid


            return new ModelAndView("index");

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

    @ModelAttribute
    public void init(Model model){
        model.addAttribute("user",new UserWithConfirmPass());
    }
}
