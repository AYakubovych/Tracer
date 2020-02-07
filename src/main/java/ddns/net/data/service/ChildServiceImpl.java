package ddns.net.data.service;


import ddns.net.data.entities.Child;
import ddns.net.data.repository.ChildRepository;
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


    private ChildRepository childRepository;

    @Transactional
    @Override
    public Child save(Child child){
        return childRepository.save(child);
    }

    @Transactional(readOnly = true)
    @Override
    public Child findOneByName(String name){
        return childRepository.findOneByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public Child findOneById(int id){
        return childRepository.findOneById(id);
    }

    @Autowired
    public void setChildRepository(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }
}
