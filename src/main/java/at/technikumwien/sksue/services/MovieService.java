package at.technikumwien.sksue.services;

import at.technikumwien.sksue.entities.*;
import java.util.*;
import javax.ejb.*;
import javax.persistence.*;

/**
 * @author Link
 */
@Stateless
public class MovieService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Movie> getMoviesContainingTitle(String containedByTitle) {
        return entityManager.createQuery("SELECT m FROM Movie m WHERE m.title LIKE '%" + containedByTitle + "%'", Movie.class).getResultList();
    }
}
