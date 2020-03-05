package ddns.net.util;

import ddns.net.data.entities.LocationData;
import ddns.net.data.service.LocationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocationMapCreator {

    private LocationDataService locationDataService;


    public Map<String,List<LocationData>> createMap(int childId){

        List<LocationData> locationDataList = locationDataService.findAllByChildId(childId);

        Map<String,List<LocationData> > locationMap = new HashMap<>();
        
//        List<LocationData> timeList = new ArrayList<>();
//        String date = "";

//        for (LocationData location: locationDataList) {
//            date = location.getDate();
//
//            if(!locationMap.containsKey(date)){
//                timeList = new ArrayList<>();
//            }
//            timeList.add(location);
//            locationMap.put(date,timeList);
//        }

        locationDataList.forEach(
                (location) -> {
                        List<LocationData> testList;

                        if(!locationMap.containsKey(location.getDate())){
                            testList = new ArrayList<>();
                        }else{
                            testList = locationMap.get(location.getDate());
                        }

                        testList.add(location);
                        locationMap.put(location.getDate(),testList);
                });

        return locationMap;
    }

    @Autowired
    public void setLocationDataService(LocationDataService locationDataService) {
        this.locationDataService = locationDataService;
    }
}
