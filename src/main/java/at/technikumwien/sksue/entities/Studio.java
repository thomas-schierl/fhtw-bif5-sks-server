package at.technikumwien.sksue.entities;

import java.util.*;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;
import javax.xml.bind.annotation.*;

/**
 * @author Link
 */
@Entity
@Table(name = "studios")
@SuppressWarnings("Serialize")
@XmlAccessorType(FIELD)
public class Studio {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @XmlTransient
    private int id;
    @XmlAttribute(required = true)
    @Column(nullable = false)
    private String name;
    @XmlAttribute(name = "countrycode", required = false)
    private String countryCode;
    @XmlAttribute(name = "postcode", required = false)
    private String postCode;

    @OneToMany(mappedBy = "studio")
    @XmlTransient
    private List<Movie> movieList;

    public Studio() {
    }

    public Studio(String name, String countryCode, String postCode, List<Movie> movieList) {
        this.name = name;
        this.countryCode = countryCode;
        this.postCode = postCode;
        this.movieList = movieList;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter/Setter">
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
    //</editor-fold>
}
