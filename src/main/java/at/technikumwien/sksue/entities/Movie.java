package at.technikumwien.sksue.entities;

import at.technikumwien.sksue.enums.*;
import java.io.*;
import java.util.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;
import javax.xml.bind.annotation.*;

/**
 * @author Link
 */
@Entity
@Table(name = "movies")
@XmlRootElement
@XmlAccessorType(FIELD)
@NamedQuery(name = "Movie.findByPartOfName", query = "SELECT m FROM Movie m WHERE m.title LIKE '%:part%'")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @XmlTransient
    private int id;

    @XmlAttribute(required = true)
    @Column(nullable = false)
    private String title;
    @XmlAttribute(required = false)
    @Column(length = 1023)
    private String description;
    @XmlAttribute(name = "releaseyear", required = false)
    private int releaseYear;
    @XmlAttribute(required = true)
    @Column(nullable = false)
    private int movieLength;
    @XmlAttribute(required = true)
    @Column(nullable = false)
    @Enumerated(STRING)
    private Genre genre;

    @ManyToOne(optional = false)
    @JoinColumn
    private Studio studio;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
    )
    @XmlElementWrapper(name = "actors")
    @XmlElement(name = "actor")
    private List<Actor> actorList;

    public Movie() {
    }

    public Movie(String title, String description, int releaseYear, int movieLength, Studio studio, Genre genre, List<Actor> actorList) {
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.movieLength = movieLength;
        this.studio = studio;
        this.genre = genre;
        this.actorList = actorList;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter/Setter">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
    //</editor-fold>

}
