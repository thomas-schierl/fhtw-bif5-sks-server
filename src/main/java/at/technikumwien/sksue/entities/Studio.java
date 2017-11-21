package at.technikumwien.sksue.entities;

import java.io.*;
import java.util.*;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

/**
 * @author Link
 */
@Entity
@Table(name = "studios")
@SuppressWarnings("Serialize")
public class Studio implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;
    private String countryCode;
    private String postCode;
    @OneToMany(mappedBy = "studio")
    private List<Movie> movieList;

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
