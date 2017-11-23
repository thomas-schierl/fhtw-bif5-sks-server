package at.technikumwien.sksue.services;

import java.net.*;
import javax.inject.*;
import javax.jws.*;
import javax.xml.namespace.*;
import javax.xml.ws.*;

/**
 * @author Link
 */
@WebService(endpointInterface = "at.technikumwien.sksue.services.FirstWebService",
        serviceName = "FirstWebService",
        portName = "FirstWebServicePort")
public class FirstWebServiceImpl implements FirstWebService {

    @Inject
    public FirstService service;

    @Override
    public String hello() {
        return service.helloText();
    }

    public void test() throws Exception {
        Service calculatorService = Service.create(
                new URL("http://localhost:8080/sksuebung/FirstWebService?wsdl"),
                new QName("http://localhost:8080/sksuebung", "FirstWebService"));


        FirstWebService calculator = calculatorService.getPort(FirstWebService.class);
        System.out.println(calculator.hello());
    }
// Siehe http://localhost:8080/news/NewsWebService?wsdl
}
