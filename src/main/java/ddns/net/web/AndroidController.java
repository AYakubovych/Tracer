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


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  try to RESTController in login and registration
 */

@Controller
@RequestMapping("/android")
public class AndroidController {

    private Logger logger = LoggerFactory.getLogger(AndroidController.class);

    private static final SimpleDateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private ChildService childService;
    private LocationDataService locationDataService;

    @RequestMapping("/registration")
    public String createChildProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Child child = new Child(
                request.getParameter("username"),request.getParameter("pass")
        );

        childService.save(child);
        response.getWriter().println(child.getId());

        return null;
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Child child = childService.findOneByName(request.getParameter("username"));
        if(child.getPass().equals(request.getParameter("pass"))){
            response.getWriter().println(child.getId());
        }
        response.getWriter().println("null");
        return null;
    }

    @RequestMapping("/tracking/{id}")
    public String addLocation(@PathVariable String id, HttpServletRequest request){

        Date date = new Date();
        String d = FULL_DATE_FORMAT.format(date);

        String[] dateArray = d.split(" ");

        LocationData locationData = new LocationData();
        locationData.setChildId(Integer.parseInt( id ));
        locationData.setLatitude(Double.parseDouble( request.getParameter("lat")));
        locationData.setLongitude(Double.parseDouble( request.getParameter("lon")));

        locationData.setDate(dateArray[0]);
        locationData.setTime(dateArray[1]);

        locationDataService.save(locationData);

        return null;
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
