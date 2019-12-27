package ddns.net.repository;

import ddns.net.entities.Child;
import org.springframework.data.repository.CrudRepository;


public interface ChildRepository extends CrudRepository<Child,Integer> {

    Child findOneByName(String name);
    Child findOneById(int id);

}
