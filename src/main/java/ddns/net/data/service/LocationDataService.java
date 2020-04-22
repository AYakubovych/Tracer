package ddns.net.data.service;


import ddns.net.data.entities.LocationData;

import java.util.List;

public interface LocationDataService  {

    LocationData save(LocationData locationData);
    LocationData findOneById(long id);
    List<LocationData> findAllByChildId(long id);

}
