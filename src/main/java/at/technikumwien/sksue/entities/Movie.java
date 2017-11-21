package at.technikumwien.sksue.entities;

import at.technikumwien.sksue.enums.*;
import java.io.*;
import java.sql.*;
import java.time.*;
import java.util.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

/**
 * @author Link
 */
@Entity
@Table(name = "movies")
@SuppressWarnings("Serialize")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String title;
    private String description;
    private Year releaseYear;
    private Time movieLength;

    @ManyToOne
    @JoinColumn
    private Studio studio;

    @Enumerated(STRING)
    private Genre genre;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
    )
    private List<Actor> actorList;

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

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Time getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(Time movieLength) {
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
