package at.technikumwien.sksue.services;

import at.technikumwien.sksue.entities.*;
import java.util.*;
import javax.jws.*;

/**
 * @author Link
 */
@WebService
public interface MovieWebService {

    @WebMethod()
    List<Movie> SearchByTitle(@WebParam(name = "containedByTitle") String containedByTitle);

/*    @WebMethod()
    boolean AddMovieByParameters(
            @WebParam(name = "title") String title,
            @WebParam(name = "desc") String description,
            @WebParam(name = "year") int releaseYear,
            @WebParam(name = "length") int movieLength,
            @WebParam(name = "studio") int studioId,
            @WebParam(name = "genre") Genre genre,
            @WebParam(name = "actors") List<Integer> actorIds) throws Exception;

    @WebMethod()
    boolean AddMovieViaJaxb(@WebParam(name = "xml") String xml) throws Exception;
*/
    @WebMethod()
    boolean AddMovies(@WebParam(name = "movie") List<Movie> movieList) throws Exception;
}
