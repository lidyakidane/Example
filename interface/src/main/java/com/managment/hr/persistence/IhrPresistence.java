package com.managment.hr.persistence;

import com.managment.hr.domain.Company;
import com.managment.hr.domain.Employee;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 11/26/14
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IhrPresistence {
    public void createEmployee(Employee emp) ;
    public void createCompany(Company company);
    public Employee deleteEmployee(long  id);
    public Company deleteCompany(long id);
    public boolean updatedCompany(Company company);
    public boolean updateEmployee(long id);
    public Employee getEmployee(long id);
    public Company  getCompany(long id);
    public List<Employee> getAllEmployee(long compid);
}
