package ddns.net.data.service;

import ddns.net.data.entities.Target;

public interface TargetService {

    Target save(Target child);
    Target findOneByName(String name);
    Target findOneById(long id);
    Target findOneByEmail(String email);

}
