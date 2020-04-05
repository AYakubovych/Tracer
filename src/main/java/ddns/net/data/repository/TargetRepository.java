package ddns.net.data.repository;

import ddns.net.data.entities.Target;
import org.springframework.data.repository.CrudRepository;


public interface TargetRepository extends CrudRepository<Target,Integer> {

    Target findOneByName(String name);
    Target findOneById(int id);

}
