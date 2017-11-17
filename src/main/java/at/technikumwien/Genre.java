package at.technikumwien;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

/**
 * @author Link
 */
@Entity
@Table(name = "genres")
@SuppressWarnings("Serialize")
public class Genre {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;

    public Genre() {
    }

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

}
