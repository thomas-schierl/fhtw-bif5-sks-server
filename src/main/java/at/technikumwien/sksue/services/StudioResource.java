package at.technikumwien.sksue.services;

import at.technikumwien.sksue.entities.*;
import java.util.*;
import javax.annotation.security.*;
import javax.inject.*;
import javax.persistence.*;
import javax.transaction.*;
import javax.ws.rs.*;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import javax.ws.rs.core.*;

/**
 * @author Link
 */
@Path("/studio")
@Transactional
public class StudioResource {

    @PersistenceContext
    private EntityManager em;

    @Context
    private UriInfo uriInfo;

    @Inject
    private MovieService movieService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @RolesAllowed("MSRead")
    public List<Studio> getAll() {
        return movieService.getAllStudios();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Studio studio) {
        em.persist(studio);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(studio.getId() + "").build()).build();
    }

    @GET
    @Produces({MediaType.TEXT_PLAIN})
    @Path("/{id}")
    public String readAsString(@PathParam("id") int id) {
        Studio studio = em.find(Studio.class, id);
        return studio != null ? studio.toString() : null;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{id}")
    public Studio readAsJson(@PathParam("id") int id) {
        return em.find(Studio.class, id);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{id}")
    public void update(@PathParam("id") int id, Studio newStudio) {
        Studio oldStudio = em.find(Studio.class, id);
        if (oldStudio == null)
            throw new WebApplicationException(NOT_FOUND);
        oldStudio.initialise(newStudio);
    }

    @DELETE
    @Consumes()
    @Path("/{id}")
    public void delete(@PathParam("id") int id) {
        Studio studio = em.find(Studio.class, id);
        if (studio == null)
            throw new WebApplicationException(NOT_FOUND);
        em.remove(studio);
    }
}
