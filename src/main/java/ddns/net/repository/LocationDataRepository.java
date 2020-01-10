package ddns.net.repository;

import ddns.net.entities.LocationData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationDataRepository extends CrudRepository<LocationData, Long> {

    LocationData findOneById(long id);
    List<LocationData> findAllByChildId(int id);


}
