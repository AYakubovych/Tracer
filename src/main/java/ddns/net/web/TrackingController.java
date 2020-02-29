package ddns.net.web;

import ddns.net.data.entities.LocationData;
import ddns.net.data.entities.User;
import ddns.net.data.service.LocationDataService;
import ddns.net.data.service.UserService;
import ddns.net.util.LocationMapCreator;
import ddns.net.util.Message;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  try @NamedQuery in GET of list of date
 */
@PropertySource("classpath:/properties/map.properties")
@RequestMapping("/tracking")
@Controller
public class TrackingController {

    @Value("${api.key}")
    private String API_KEY;
    private Logger logger = LoggerFactory.getLogger(TrackingController.class);

    private LocationMapCreator locationMapCreator;
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView tracking(Model model,
                                 HttpServletRequest request){

        User user = userService.findOneByEmail(request.getRemoteUser());

        if(user.getChild().getId() <= 0){
            logger.error("ChildId <= 0 for user witf id: " + user.getId());
            //No id logic
        }

        Map locationMap = locationMapCreator.createMap(user.getChild().getId());
        logger.info("Location data map created for user with id: " + user.getId());

        model.addAttribute("locationMap", locationMap);
        logger.info("Location data added as attribute for user with id: " + user.getId());

        model.addAttribute("api_key", API_KEY);
        logger.info("Api key added as attribute for user with id: " + user.getId());

        return new ModelAndView("tracking");
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setLocationMapCreator(LocationMapCreator locationMapCreator){
        this.locationMapCreator = locationMapCreator;
    }

}
