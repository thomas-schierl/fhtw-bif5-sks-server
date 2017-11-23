package at.technikumwien.sksue.services;

import at.technikumwien.sksue.entities.*;
import at.technikumwien.sksue.enums.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.annotation.*;
import javax.ejb.*;
import static javax.ejb.TransactionAttributeType.REQUIRED;
import javax.inject.*;
import javax.jws.*;
import javax.persistence.*;
import javax.transaction.*;
import static javax.xml.bind.JAXBContext.newInstance;
import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

/**
 * @author Link
 */
@WebService(endpointInterface = "at.technikumwien.sksue.services.MovieWebService",
        serviceName = "MovieWebService",
        portName = "MovieWebServicePort")
public class MovieWebServiceImpl implements MovieWebService {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    @Inject
    private MovieService movieService;

    @Override
    public List<Movie> SearchByTitle(String containedByTitle) {
        //FIXME: containedByTitle has to be cleaned, dirty userinput
        return movieService.getMoviesContainingTitle(containedByTitle);
    }

    @Override
    public boolean AddMovieByParameters(String title, String description, int releaseYear, int movieLength, int studioId, Genre genre, List<Integer> actorIds) throws Exception {
        Studio studio = entityManager.find(Studio.class, studioId);
        if (studio == null) {
            throw new IllegalArgumentException("Id does not correspond to any Studio");
        }
        List<Actor> actorList = new ArrayList<>();
        for (int i = 0; i < actorIds.size(); i++) {
            Actor a = entityManager.find(Actor.class, actorIds.get(i));
            if (a == null) {
                throw new IllegalArgumentException("Id does not correspond to any Actor");
            }
            actorList.add(a);
        }

        Movie movie = new Movie(title, description, releaseYear, movieLength, studio, Genre.DRAMA, actorList);
        return AddMovie(movie);
    }

    @Override
    public boolean AddMovieViaJaxb(String xml) throws Exception {
        JAXBContext jaxbc = newInstance(Movie.class);
        Unmarshaller unmarshaller = jaxbc.createUnmarshaller();
        Source source = new StreamSource(new StringReader(xml));
        JAXBElement<Movie> jaxbe = unmarshaller.unmarshal(source, Movie.class);

        Movie movie = jaxbe.getValue();
        return AddMovie(movie);
    }

    @Override
    @TransactionAttribute(REQUIRED)
    public boolean AddMovie(Movie movie) throws Exception {
        try {
            userTransaction.begin();
            entityManager.persist(movie);
            userTransaction.commit();
        } catch (Exception ex) {
            Logger.getLogger(MovieWebServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            userTransaction.rollback();
            throw ex;
        }
        return true;
    }
}
