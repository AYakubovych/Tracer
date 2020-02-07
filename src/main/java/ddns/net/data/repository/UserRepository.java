package ddns.net.data.repository;


import ddns.net.data.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {

    List<User> findByName(String name);
    User findOneByEmail(String email);
    User findOneById(long id);
    User findOneByName(String name);
}
