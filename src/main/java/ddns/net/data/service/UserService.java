package ddns.net.data.service;

import ddns.net.data.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    List<User> findByName(String name);
    User save(User user);
    User findOneByEmail(String email);
    User findOneById(long id);
    User findOneByName(String name);

}
