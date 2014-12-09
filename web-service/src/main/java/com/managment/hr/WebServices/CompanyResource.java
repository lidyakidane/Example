package com.managment.hr.WebServices;
import com.managment.hr.Service.IhrService;
import com.managment.hr.domain.Company;
import com.managment.hr.domain.Employee;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 12/2/14
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/company")
public class CompanyResource {
@Autowired
private IhrService service;
@GET
@Path("/status")
@Produces(MediaType.TEXT_HTML)
public String status()
{
 return "status page";
}
    @GET
    @Path("/{companyId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCompany(@PathParam("companyId") Long id) throws Exception
    {
        Response rs=null;
        try
        {
           Company company=service.getCompany(id);
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(company);
            rs=Response.ok(json).build();
            return rs;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return rs;
        }
    }
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
     public Response createCompany(String comnaydetail) throws Exception
  {
  ObjectMapper objectMapper=new ObjectMapper();
  Company company=objectMapper.readValue(comnaydetail, Company.class);
    service.createCompany(company);
      return Response.ok(comnaydetail).build();
  }
  @DELETE
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/{companyId}")
   public Response deleteCompany(@PathParam("companyId") long id) throws Exception
   {
    Company company=service.deleteCompany(id);
    ObjectWriter  objectMapper=new ObjectMapper().writerWithDefaultPrettyPrinter();
    String companyJoson= objectMapper.writeValueAsString(company);
    return Response.ok(companyJoson).build();
   }
  @PUT
  @Path("/{cId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateCompany(@PathParam("cId") long id, String companyIncoming) throws Exception
  {
   ObjectMapper objectMapper=new ObjectMapper();
   Company company=objectMapper.readValue(companyIncoming,Company.class);
   service.updateCompany(company);
   return Response.ok(companyIncoming).build();
  }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/employeelist/{id}")
 public Response getAllEmploye(@PathParam("id") long id) throws Exception
 {
     List<Employee> employeeList=service.getAllEmploye(id);
    ObjectWriter objectWriter=new ObjectMapper().writerWithDefaultPrettyPrinter();
     String joson=objectWriter.writeValueAsString(employeeList);
     return Response.ok(joson).build();
 }

}
