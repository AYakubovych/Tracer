package ddns.net.web;


import ddns.net.entities.Child;
import ddns.net.entities.LocationData;
import ddns.net.service.ChildService;
import ddns.net.service.LocationDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  try to RESTController in login and registration
 */

@RestController
@RequestMapping("/android")
public class AndroidController {

    private Logger logger = LoggerFactory.getLogger(AndroidController.class);

    private static final SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private ChildService childService;
    private LocationDataService locationDataService;

    @RequestMapping("/registration")
    public long createChildProfile(@RequestParam("username")String username,
                                   @RequestParam("pass") String pass){

        Child child = childService.findOneByName(username);

        if(child != null){
            return 0;
        }
        child = new Child(username,pass);
        childService.save(child);

        return child.getId();
    }

    @RequestMapping("/login")
    public long login(@RequestParam("username")String username,
                      @RequestParam("pass") String pass){

        Child child = childService.findOneByName(username);
        if(child.getPass().equals(pass)){
            return child.getId();
        }
        return 0;
    }

    @RequestMapping("/tracking/{id}")
    public void addLocation(@PathVariable int id,
                            @RequestParam("lat") double lat,
                            @RequestParam("lon") double lon){

        Date date = new Date();
        String d = FULL_DATE_FORMAT.format(date);

        String[] dateArray = d.split(" ");

        LocationData locationData = new LocationData();
        locationData.setChildId(id);
        locationData.setLatitude(lat);
        locationData.setLongitude(lon);

        locationData.setDate(dateArray[0]);
        locationData.setTime(dateArray[1]);

        locationDataService.save(locationData);
    }

    @Autowired
    public void setLocationDataService(LocationDataService locationDataService) {
        this.locationDataService = locationDataService;
    }

    @Autowired
    public void setChildService(ChildService childService) {
        this.childService = childService;
    }
}
