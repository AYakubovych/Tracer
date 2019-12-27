package ddns.net.service;

import ddns.net.entities.Child;

public interface ChildService {

    Child save(Child child);
    Child findOneByName(String name);
    Child findOneById(int id);

}
