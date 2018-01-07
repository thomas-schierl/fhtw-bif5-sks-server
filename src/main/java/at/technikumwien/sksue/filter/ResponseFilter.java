package at.technikumwien.sksue.filter;

import java.io.*;
import javax.ws.rs.container.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

/**
 * @author Link
 */
@Provider
public class ResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
        MultivaluedMap<String, Object> headers = response.getHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", "Authorization");
        headers.add("Access-Control-Allow-Methods", "DELETE, GET, OPTIONS, POST, PUT");

        CacheControl control = new CacheControl();
        control.setNoCache(true);
        headers.add("Cache-Control", control);

    }

}
