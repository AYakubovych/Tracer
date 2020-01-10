package ddns.net;

import ddns.net.entities.Child;
import ddns.net.entities.LocationData;
import ddns.net.entities.User;
import ddns.net.service.ChildService;
import ddns.net.service.LocationDataService;
import ddns.net.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDataBaseEntities {

    private static UserService userService;
    private static ChildService childService;
    private static LocationDataService locationDataService;

    public static void run(){
        addChilds();
        addUsers();
        addLocationDataS();
    }

    private static void addLocationDataS(){
        LocationData locationData = new LocationData();

        locationData.setChildId(1);
        locationData.setLongitude(2.2);
        locationData.setLatitude(2.2);
        locationData.setDate("2020-01-01");
        locationData.setTime("10:00");

        locationDataService.save(locationData);
        locationData = new LocationData();

        locationData.setChildId(1);
        locationData.setLongitude(2.3);
        locationData.setLatitude(2.3);
        locationData.setDate("2020-01-01");
        locationData.setTime("11:00");

        locationDataService.save(locationData);
        locationData = new LocationData();

        locationData.setChildId(1);
        locationData.setLongitude(2.4);
        locationData.setLatitude(2.4);
        locationData.setDate("2020-01-02");
        locationData.setTime("8:00");

        locationDataService.save(locationData);
        locationData = new LocationData();

        locationData.setChildId(1);
        locationData.setLongitude(1.2);
        locationData.setLatitude(1.2);
        locationData.setDate("2020-01-02");
        locationData.setTime("11:10");

        locationDataService.save(locationData);
        locationData = new LocationData();

        locationData.setChildId(1);
        locationData.setLongitude(1.1);
        locationData.setLatitude(1.1);
        locationData.setDate("2020-01-03");
        locationData.setTime("10:00");

        locationDataService.save(locationData);
    }

    private static void addUsers(){
        User user = new User();

        user.setEmail("asd@asd.com");
        user.setName("asd");
        user.setLast_name("asd");
        user.setPass("asd");

        userService.save(user);
        user = new User();

        user.setEmail("zzz@zzz.com");
        user.setName("zzz");
        user.setLast_name("zzz");
        user.setPass("zzz");

        userService.save(user);
        user = new User();

        user.setEmail("xxx@xxx.com");
        user.setName("xxx");
        user.setLast_name("xxx");
        user.setPass("xxx");

        userService.save(user);
        user = new User();

        user.setEmail("qwe@qwe.com");
        user.setName("qwe");
        user.setLast_name("qwe");
        user.setPass("qwe");

        userService.save(user);
    }

    private static void addChilds(){
        Child child = new Child();
        child.setName("asd");
        child.setPass("asd");

        childService.save(child);
        child = new Child();

        child.setName("zzz");
        child.setPass("zzz");

        childService.save(child);
        child = new Child();

        child.setName("xxx");
        child.setPass("xxx");

        childService.save(child);
        child = new Child();

        child.setName("qwe");
        child.setPass("qwe");

        childService.save(child);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setChildService(ChildService childService) {
        this.childService = childService;
    }
    @Autowired
    public void setLocationDataService(LocationDataService locationDataService) {
        this.locationDataService = locationDataService;
    }
}
