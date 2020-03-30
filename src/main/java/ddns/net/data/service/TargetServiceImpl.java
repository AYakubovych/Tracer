package ddns.net.data.service;


import ddns.net.data.entities.Target;
import ddns.net.data.repository.TargetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
@Transactional
public class ChildServiceImpl implements ChildService {

    private static Logger logger = LoggerFactory.getLogger(ChildServiceImpl.class);


    private TargetRepository targetRepository;

    @Transactional
    @Override
    public Target save(Target child){
        return targetRepository.save(child);
    }

    @Transactional(readOnly = true)
    @Override
    public Target findOneByName(String name){
        return targetRepository.findOneByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public Target findOneById(int id){
        return targetRepository.findOneById(id);
    }

    @Autowired
    public void setTargetRepository(TargetRepository targetRepository) {
        this.targetRepository = targetRepository;
    }
}
