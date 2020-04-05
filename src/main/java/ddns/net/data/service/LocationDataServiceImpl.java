package ddns.net.data.service;

import ddns.net.data.entities.LocationData;
import ddns.net.data.repository.LocationDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Repository
@Transactional
public class LocationDataServiceImpl implements LocationDataService {

    private static Logger logger = LoggerFactory.getLogger(LocationDataServiceImpl.class);

    private LocationDataRepository locationDataRepository;

    @Transactional
    @Override
    public LocationData save(LocationData locationData){
        return locationDataRepository.save(locationData);
    }

    @Transactional(readOnly = true)
    @Override
    public LocationData findOneById(long id) {
        return locationDataRepository.findOneById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<LocationData> findAllByChildId(int id) {
        return locationDataRepository.findAllByTargetId(id);
    }



    @Autowired
    public void setLocationDataRepository(LocationDataRepository locationDataRepository) {
        this.locationDataRepository = locationDataRepository;
    }
}
