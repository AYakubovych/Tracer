package ddns.net.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.FIND_ALL",
        query= "select u from User u")
@SqlResultSetMapping(
        name = "userResult",
        entities = @EntityResult(entityClass = User.class)
)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "create.form.name.surname.empty" )
    @Column(name = "name")
    private String name;

    @NotBlank(message = "create.form.name.surname.empty")
    @Column(name = "last_name")
    private String last_name;

    @NotBlank(message = "create.form.email.error" )
    @Email(message = "create.form.email.error" )
    @Column(name ="email")
    private String email;

    @Size(min = 2,message = "create.form.pass.length")
    @Column(name = "pass")
    private String pass;

    @Column(name = "child_id")
    private int child_id;


    public User(){}

    public User(String name, String last_name, String email, String pass) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
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

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getChild_id() {
        return child_id;
    }

    public void setChild_id(int child_id) {
        this.child_id = child_id;
    }

    @Override
    public String toString() {
        return email;
    }
}
