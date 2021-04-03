package org.example.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.jws.WebService;

@WebService(serviceName = "HelloWorld",endpointInterface="org.example.soap.HelloWorld")
@ApplicationScoped
public class HelloWorldImpl implements HelloWorld{
    static final Logger logger = LoggerFactory.getLogger(HelloWorldImpl.class);

    public HelloWorldImpl() {
        logger.info("starting");
    }

    @Override
    public String hello() {
        return "Hello";
    }
}
