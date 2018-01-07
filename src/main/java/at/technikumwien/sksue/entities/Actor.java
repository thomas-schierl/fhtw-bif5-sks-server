package at.technikumwien.sksue.entities;

import at.technikumwien.sksue.enums.*;
import java.io.*;
import java.util.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import static javax.persistence.TemporalType.DATE;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;
import javax.xml.bind.annotation.*;

/**
 * @author Link
 */
@Entity
@Table(name = "actors")
@XmlAccessorType(FIELD)
@NamedQueries({
    @NamedQuery(name = "Actor.findByName", query = "SELECT a FROM Actor a WHERE a.firstName = :firstname AND a.lastName = :lastname")
    ,@NamedQuery(name = "Actor.getAll", query = "SELECT a FROM Actor a")})
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @XmlAttribute(required = false)
    private int id;
    @XmlAttribute(name = "firstname", required = true)
    @Column(nullable = false)
    private String firstName;
    @XmlAttribute(name = "lastname", required = true)
    @Column(nullable = false)
    private String lastName;
    @XmlAttribute(required = false)
    @Enumerated(STRING)
    private Sex sex;

    @Temporal(DATE)
    @XmlSchemaType(name = "date")
    @XmlAttribute(required = false)
    private Date birthdate;

    @ManyToMany(mappedBy = "actorList")
    @XmlTransient
    private List<Movie> movieList;

    public Actor() {
    }

    public Actor(String firstName, String lastName, Sex sex, Date birthdate, List<Movie> movieList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthdate = birthdate;
        this.movieList = movieList;
    }

    public void initialise(Actor newActor) {
        setFirstName(newActor.getFirstName());
        setLastName(newActor.getLastName());
        setSex(newActor.getSex());
        setBirthdate(newActor.getBirthdate());
        setMovieList(newActor.getMovieList());
    }

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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
    //</editor-fold>
}
