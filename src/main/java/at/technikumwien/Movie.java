package at.technikumwien;

import java.sql.*;
import java.time.*;
import java.util.*;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

/**
 * @author Link
 */
@Entity
@Table(name = "movies")
@SuppressWarnings("Serialize")
public class Movie {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String title;
    private String description;
    private Year releaseyear;
    private Time length;
    @ManyToOne
    private Studio studio;
    @OneToOne
    private Genre genre;
    @OneToMany
    private List<Actor> actors;
}
