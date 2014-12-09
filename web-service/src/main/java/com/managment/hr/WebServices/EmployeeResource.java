package com.managment.hr.WebServices;
import com.managment.hr.Service.IhrService;
import com.managment.hr.domain.Employee;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 12/4/14
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
@Path("/employee")
@Component
public class EmployeeResource {
@Autowired
private IhrService service;
 @GET
 @Path("/status")
 @Produces(MediaType.TEXT_HTML)
public String getStatus() throws Exception
 {
 return "Employee Status";
 }
@GET
@Path("/{EmployeeId}")
@Produces(MediaType.APPLICATION_XML)
public Response getEmpolyeeInfo(@PathParam("EmployeeId") long id) throws Exception
{
    Employee emplyee=service.getEmploye(id);
    ObjectWriter objectWriter=new ObjectMapper().writerWithDefaultPrettyPrinter();
    String  joson=objectWriter.writeValueAsString(emplyee);
    return  Response.ok(joson).build();
}

@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response createEmployee(String incomingData)throws Exception
{
 ObjectMapper objectMapper=new ObjectMapper();
 Employee employee=objectMapper.readValue(incomingData, Employee.class);
 service.createEmploye(employee);
 return  Response.ok(incomingData).build();

}
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{eId}")
    public Response updateEmployee(@PathParam("eId")long id,String comingData) throws  Exception
    {
     ObjectMapper objectMapper=new ObjectMapper();
     Employee employee=objectMapper.readValue(comingData,Employee.class);
     service.updateEmployee(employee);
     return Response.ok(comingData).build();
    }
   @DELETE
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/{id}")
  public Response deleteEmployee(@PathParam("id") long id) throws Exception
  {
   Employee employee=service.deleteEmployee(id);
   ObjectWriter objectWriter=new ObjectMapper().writerWithDefaultPrettyPrinter();
   String joson=objectWriter.writeValueAsString(employee);
  return Response.ok(joson).build();
  }

}


