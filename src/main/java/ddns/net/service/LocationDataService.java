package ddns.net.service;


import ddns.net.entities.LocationData;

import java.util.List;

public interface LocationDataService  {

    LocationData save(LocationData locationData);
    LocationData findOneById(long id);
    List<LocationData> findAllByChildId(int id);

}
