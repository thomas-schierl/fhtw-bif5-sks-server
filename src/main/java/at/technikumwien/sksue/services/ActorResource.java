package at.technikumwien.sksue.services;

import at.technikumwien.sksue.entities.*;
import java.util.*;
import javax.inject.*;
import javax.persistence.*;
import javax.transaction.*;
import javax.ws.rs.*;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import javax.ws.rs.core.*;

/**
 * @author Link
 */
@Path("/actor")
@Transactional
public class ActorResource {

    @PersistenceContext
    private EntityManager em;

    @Context
    private UriInfo uriInfo;

    @Inject
    private MovieService movieService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Actor> getAll() {
        return movieService.getAllActors();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Actor actor) {
        em.persist(actor);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(actor.getId() + "").build()).build();
    }

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public String readAsString(@PathParam("id") int id) {
        Actor actor = em.find(Actor.class, id);
        return actor != null ? actor.toString() : null;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Actor readAsJson(@PathParam("id") int id) {
        return em.find(Actor.class, id);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{id}")
    public void update(@PathParam("id") int id, Actor newActor) {
        Actor oldActor = em.find(Actor.class, id);
        if (oldActor == null)
            throw new WebApplicationException(NOT_FOUND);
        oldActor.initialise(newActor);
    }

    @DELETE
    @Consumes()
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        Actor actor = em.find(Actor.class, id);
        if (actor == null)
            throw new WebApplicationException(NOT_FOUND);
        em.remove(actor);
    }
}
