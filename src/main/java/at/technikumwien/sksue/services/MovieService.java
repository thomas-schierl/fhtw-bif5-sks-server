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
        Query query = entityManager.createNamedQuery("Movie.findByPartOfName");
        query.setParameter("part", containedByTitle);
        return query.getResultList();
    }

    public List<Actor> getAllActors() {
        Query query = entityManager.createNamedQuery("Actor.getAll");
        return query.getResultList();
    }

    public List<Studio> getAllStudios() {
        Query query = entityManager.createNamedQuery("Studio.getAll");
        return query.getResultList();
    }
}
