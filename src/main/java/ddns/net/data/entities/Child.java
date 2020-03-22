package ddns.net.data.entities;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "child")
public class Child implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "pass")
    private String pass;

    @Column
    @ManyToMany(mappedBy = "childs")
    private List<User> users = new ArrayList<>();

    public Child(){}

    public Child(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString(){
        return "child id: " + this.getId();
    }

}
