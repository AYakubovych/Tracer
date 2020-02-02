package ddns.net.web;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@PropertySource("classpath:/properties/map.properties")
@RequestMapping("/")
@Controller
public class IndexController {

    @Value("${api.key}")
    private String API_KEY;

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(Model model){
        model.addAttribute("api_key", API_KEY);
        return new ModelAndView("index");
    }


}
