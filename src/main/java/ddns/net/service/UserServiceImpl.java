package ddns.net.service;

import com.google.common.collect.Lists;
import ddns.net.entities.User;
import ddns.net.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@Repository
@Transactional
public class UserServiceImpl implements UserService{

    final static String ALL_USERS_NATIVE_QUERY = "select id, email, last_name,"+
            "name, pass from users";

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll(){
        return Lists.newArrayList(userRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findByName(String firstName){
        return userRepository.findByName(firstName);
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findOneByEmail(String email){
        return userRepository.findOneByEmail(email);
    }

    @Transactional(readOnly = true)
    @Override
    public User findOneById(long id){
        return userRepository.findOneById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public User findOneByName(String name) {
        return userRepository.findOneByName(name);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
