package ddns.net.web;

import ddns.net.service.MailService;
import ddns.net.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mail")
public class FeedBackController {

    private MailService mailService;

    private Logger logger = LoggerFactory.getLogger(FeedBackController.class);

    @GetMapping
    public ModelAndView feedBack(@RequestParam String text){

        logger.info("Mailing controller");

        try{
            mailService.sendMail(text);
            logger.info("Mail sended" );
        }catch (MailException e){
            logger.error("Error while mail sending: " + e.getMessage());
        }
        return new ModelAndView("redirect:/");
    }

    @Autowired
    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @ModelAttribute
    public void init(Model model){
        model.addAttribute("message",new Message());
    }
}
