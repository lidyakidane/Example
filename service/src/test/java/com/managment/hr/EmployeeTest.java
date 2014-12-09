package com.managment.hr;

import com.managment.hr.Service.IhrService;
import com.managment.hr.domain.Company;
import com.managment.hr.domain.Employee;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 12/2/14
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeTest extends BaseTestCase {
@Autowired
private IhrService services;

@Test
public void createEmployeeTest()
{
Company cmp=services.getCompany(2);
    Employee emp=new Employee("Mussie","Engineer",34343);
    emp.setCompany(cmp);
    Assert.assertTrue(services.createEmploye(emp).getName().equals(emp.getName()));
    Assert.assertNotNull(emp);
    List<Employee>  employeeList=services.getAllEmploye(7);
    Assert.assertNotNull(employeeList);
}
}
