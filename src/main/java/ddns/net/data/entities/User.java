package ddns.net.data.entities;

import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
    private long id;

    @NotBlank(message = "create.form.name.surname.empty" )
    @Column(name = "username")
    private String name;

    @NotBlank(message = "create.form.name.surname.empty")
    @Column(name = "last_name")
    private String last_name;

    @Unique
    @NotBlank(message = "create.form.email.error" )
    @Email(message = "create.form.email.error" )
    @Column(name ="email")
    private String email;

    @Size(min = 2,message = "create.form.pass.length")
    @Column(name = "pass")
    private String pass;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "child_id")
    private Child child;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Authorities> authorities = new HashSet<>();

    public User(){
        this.enabled = true;
    }

    public User(String name, String last_name, String email, String pass) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.pass = pass;
        this.enabled = true;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEnabled(){
        return enabled;
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

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authorities> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return email;
    }
}
