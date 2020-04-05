package ddns.net.web;


import ddns.net.data.entities.Target;
import ddns.net.data.entities.LocationData;
import ddns.net.data.service.TargetService;
import ddns.net.data.service.LocationDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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

    private TargetService childService;
    private LocationDataService locationDataService;

    @RequestMapping("/registration")
    public long createTarget(@RequestParam("username")String mail,
                                   @RequestParam("pass") String pass){

        Target child = childService.findOneByName(mail);

        if(child != null){
            logger.error("Target already exist. Return 0 to response");
            return 0;
        }
        child = new Target(mail,pass);
        childService.save(child);
        logger.info("Target added to database. Target id: " + child.getId());
        return child.getId();
    }

    @RequestMapping("/login")
    public long login(@RequestParam("username")String username,
                      @RequestParam("pass") String pass){

        Target child = childService.findOneByName(username);
        if(child.getPass().equals(pass)){
            logger.info("Target exist. Id: " + child.getId());
            return child.getId();
        }
        logger.error("Target does not exist. Return 0 to response");
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
        locationData.setTargetId(id);
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
    public void setChildService(TargetService childService) {
        this.childService = childService;
    }
}
