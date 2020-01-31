package ddns.net.web;

import ddns.net.entities.LocationData;
import ddns.net.entities.User;
import ddns.net.service.LocationDataService;
import ddns.net.service.UserService;
import ddns.net.util.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    private LocationDataService locationDataService;
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView tracking(Model model,
                                 RedirectAttributes redirectAttributes,
                                 @CookieValue(value = "id", defaultValue = "0") int id){


        if(id != 0){
            User user = userService.findOneById(id);
            List<LocationData> locationDataList = locationDataService.findAllByChildId(user.getChild().getId());

            Map<String,List<LocationData> > locationMap = new HashMap<>();
            List<LocationData> timeList = new ArrayList<>();
            String date = "";

            for (LocationData location: locationDataList) {
                date = location.getDate();

                if(!locationMap.containsKey(date)){
                    timeList = new ArrayList<>();
                }
                timeList.add(location);
                locationMap.put(date,timeList);
            }

            model.addAttribute("locationMap", locationMap);
            model.addAttribute("api_key", API_KEY);

            return new ModelAndView("tracking");
        }
        Message message = new Message();
        message.setMessage("Cookie expire");
        message.setType("error");

        redirectAttributes.addFlashAttribute("error_message", message);
        return new ModelAndView("redirect:/login");
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setLocationDataService(LocationDataService locationDataService) {
        this.locationDataService = locationDataService;
    }
}
