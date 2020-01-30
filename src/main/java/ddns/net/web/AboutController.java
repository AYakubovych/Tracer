package ddns.net.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/about")
@Controller
public class AboutController {


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView about(){
        return new ModelAndView("about");
    }

}
