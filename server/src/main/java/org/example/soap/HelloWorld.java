package org.example.soap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Simple Hello (Greeter) Webservice.
 *
 * <p>
 * Say hi to well known users.
 */

@SuppressWarnings("unused")
@WebService(serviceName = "HelloWorld")
public interface HelloWorld {

    /**
     * Most basic service function.
     */
    @WebMethod
    String hello();


}
