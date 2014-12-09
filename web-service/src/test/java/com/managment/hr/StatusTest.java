package com.managment.hr;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import javax.ws.rs.core.MediaType;

import org.testng.annotations.Test;

import com.sun.jersey.api.client.WebResource;
/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 12/8/14
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class StatusTest extends TestNg {
    @Test
    public void statusPage() {
        WebResource resource = resource();
        String status = resource.path( "/company/status" )
                .accept( MediaType.TEXT_HTML )
                .get( String.class );
        assertNotNull(status);
    }
}
