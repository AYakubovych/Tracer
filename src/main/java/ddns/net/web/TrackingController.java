package ddns.net.web;

import ddns.net.entities.LocationData;
import ddns.net.entities.User;
import ddns.net.service.LocationDataService;
import ddns.net.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  try @NamedQuery in GET of list of date
 */

@RequestMapping("/tracking")
@Controller
public class TrackingController {

    private Logger logger = LoggerFactory.getLogger(TrackingController.class);

    private LocationDataService locationDataService;
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView tracking(Model model, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        int userId = 0;
        for (Cookie cookie: cookies
             ) {
            if(cookie.getName().equals("id")){
                userId = Integer.parseInt(cookie.getValue());
                break;
            }
        }

        User user = userService.findOneById(userId);
        List<LocationData> locationDataList = locationDataService.findAllByChildId(user.getChild().getId());

        Map< String,List<String> > locationMap = new HashMap<>();
        List<String> timeList = new ArrayList<>();
        String date = "";

        for (LocationData location: locationDataList
             ) {
            date = location.getDate();

            if(!locationMap.containsKey(date)){
                timeList = new ArrayList<>();
            }

            timeList.add(location.getTime());
            locationMap.put(date,timeList);
        }

        model.addAttribute("locationMap", locationMap);

        return new ModelAndView("tracking");
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
