package ddns.net.data.service;

import ddns.net.data.entities.Target;

public interface ChildService {

    Target save(Target child);
    Target findOneByName(String name);
    Target findOneById(int id);

}
