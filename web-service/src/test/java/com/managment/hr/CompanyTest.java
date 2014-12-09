/*
package com.managment.hr;
import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Assert;
import org.junit.Test;

*/
/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 12/5/14
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 *//*


public class CompanyTest {
@Test
public void testCompany() throws JsonGenerationException,JsonMappingException,IOException
{
    ClientConfig clientConfig = new ClientConfig();
    clientConfig.register(JacksonFeature.class);

    Client client = ClientBuilder.newClient(clientConfig);

    WebTarget webTarget = client
            .target("http://localhost:8080/hr/api/company/7");

    Builder request = webTarget.request();
    request.header("Content-type", MediaType.APPLICATION_JSON);

    Response response = request.get();
    Assert.assertTrue(response.getStatus() == 200);

}

}
*/
