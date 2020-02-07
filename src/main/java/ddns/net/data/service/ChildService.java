package ddns.net.data.service;

import ddns.net.data.entities.Child;

public interface ChildService {

    Child save(Child child);
    Child findOneByName(String name);
    Child findOneById(int id);

}
