package com.managment.hr;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 12/8/14
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestNg {
    private static JerseyTest jersyTest;
    @BeforeSuite()
    public void init() {
        jersyTest = new JerseyTest( new WebAppDescriptor.Builder(
                "com.managment.hr.WebServices" ).contextPath( "/api" )
                .contextParam(
                        "contextConfigLocation", "classpath:applicationContext.xml" )
                .servletClass( SpringServlet.class )
                .contextListenerClass( ContextLoaderListener.class )
                .requestListenerClass( RequestContextListener.class )
                .build() ) {
        };
    }
    public WebResource resource() {
        return jersyTest.resource();
    }
    public Client client() {
        return jersyTest.client();
    }
    @BeforeTest
    public void setUp()
            throws Exception {
        jersyTest.setUp();
    }
    @AfterTest
    public void tearDown()
            throws Exception {
        jersyTest.tearDown();
    }

}