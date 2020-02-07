package ddns.net.data.repository;

import ddns.net.data.entities.Child;
import org.springframework.data.repository.CrudRepository;


public interface ChildRepository extends CrudRepository<Child,Integer> {

    Child findOneByName(String name);
    Child findOneById(int id);

}
