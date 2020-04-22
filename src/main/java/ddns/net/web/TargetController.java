package ddns.net.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/target")
public class TargetController {

    @PostMapping
    public ModelAndView getById(){
        return new ModelAndView();
    }

    @DeleteMapping
    public ModelAndView deleteTarget(){
        return new ModelAndView();
    }


}
