package at.technikumwien;

import java.util.*;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

/**
 * @author Link
 */
@Entity
@Table(name = "studios")
@SuppressWarnings("Serialize")
public class Studio {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;
    @Column(name = "countrycode")
    private String countryCode;
    @Column(name = "postcode")
    private String postCode;
    @OneToMany
    private List<Movie> movies;

}
