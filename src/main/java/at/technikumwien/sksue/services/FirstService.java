package at.technikumwien.sksue.services;

import javax.ejb.*;

/**
 * @author Link
 */
@Stateless
public class FirstService {
    public String helloText() {
        return "EY";
    }
}
