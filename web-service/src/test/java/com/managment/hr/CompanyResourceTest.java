package com.managment.hr;

import com.managment.hr.domain.Company;
import com.sun.jersey.api.client.WebResource;
import junit.framework.Assert;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import javax.ws.rs.core.MediaType;
/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 12/8/14
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class CompanyResourceTest extends TestNg {
  private static String compnayId="2";
  private static String path="/company/2";

 @Test
 public void CompanyfoTest()
 {
     WebResource resource = resource();
     String str=resource.path(path).accept(MediaType.APPLICATION_JSON).get(String.class);
     System.out.println(str);
     Assert.assertNotNull(str);
 }
 @Test
 public void createCompanyTest() throws Exception
 {
  WebResource resource=resource();
     Company company=new Company("veron","zeron");
     ObjectMapper objectMapper=new ObjectMapper();
     String joson=objectMapper.writeValueAsString(company);
     resource.path("/company").type(MediaType.APPLICATION_JSON).post(joson);
 }
 @Test
 public void updateCompanyTest() throws Exception
 {
    Company company=findCompnay("2");
    company.setName("UpdateCompany");
    String updated=convertToJoson(company);
    WebResource webResource=resource();
    resource().path("/company/2").type(MediaType.APPLICATION_JSON).put(updated);
 }

 public String convertToJoson(Object object) throws Exception
 {
  ObjectMapper objectMapper=new ObjectMapper();
  return objectMapper.writeValueAsString(object);
 }

public Company findCompnay(String id) throws Exception
{
 WebResource resource=resource();
 String josonCompany=resource.path("/company/"+id).accept(MediaType.APPLICATION_JSON).get(String.class);
 ObjectMapper objectWriter=new ObjectMapper();
 return objectWriter.readValue(josonCompany,Company.class);
}
 @Test
public void deletCompany() throws  Exception
{
 WebResource resource=resource();
 resource.path("/company/9").type(MediaType.APPLICATION_JSON).delete();
  }

}
