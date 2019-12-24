package ddns.net.service;

import ddns.net.entities.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    List<User> findByName(String name);
    User save(User user);
    User findOneByEmail(String email);
    User findOneById(int id);


}
