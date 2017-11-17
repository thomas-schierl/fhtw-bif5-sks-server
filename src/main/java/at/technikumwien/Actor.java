package at.technikumwien;

import java.util.*;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import static javax.persistence.TemporalType.DATE;

/**
 * @author Link
 */
@Entity
@Table(name = "actors")
@SuppressWarnings("Serialize")
public class Actor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "birthday")
    @Temporal(DATE)
    private Date birthday;
    @ManyToMany
    private List<Movie> movies;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
