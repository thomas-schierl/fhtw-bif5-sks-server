package at.technikumwien.sksue.entities;

import java.io.*;
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
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    @Temporal(DATE)
    private Date birthday;

    @ManyToMany(mappedBy = "actorList")
    private List<Movie> movieList;

    //<editor-fold defaultstate="collapsed" desc="Getter/Setter">
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

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
    //</editor-fold>

}
