package at.technikumwien.sksue.services;

import javax.jws.*;

/**
 * @author Link
 */
@WebService
public interface FirstWebService {

    @WebMethod
    public String hello();
}
