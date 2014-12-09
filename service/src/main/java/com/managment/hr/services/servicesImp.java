package com.managment.hr.services;

import com.managment.hr.Service.IhrService;
import com.managment.hr.domain.Company;
import com.managment.hr.domain.Employee;
import com.managment.hr.persistence.IhrPresistence;
import com.managment.hr.persistence.PersitenceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 12/1/14
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class servicesImp implements IhrService{
    @Autowired
    private IhrPresistence persistenc;
    @Override
    public Employee createEmploye(Employee employee) {
       persistenc.createEmployee(employee);
        return employee;
    }
    @Override
    public Company createCompany(Company company) {
        persistenc.createCompany(company);
     return company;
    }
    @Override
    public Employee getEmploye(long id) {
     return persistenc.getEmployee(id);
    }
    @Override
    public Company getCompany(long id) {
       return persistenc.getCompany(id);
    }
    @Override
    public Employee deleteEmployee(long id) {
       return persistenc.deleteEmployee(id);
    }
    @Override
    public List<Employee> getAllEmploye(long companyId) {
    return persistenc.getAllEmployee(companyId);
    }
    @Override
    public Company deleteCompany(long Id) {
        return persistenc.deleteCompany(Id);
    }
    @Override
    public boolean updateCompany(Company Id) {
        return persistenc.updatedCompany(Id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return persistenc.updateEmployee(employee.getId());
    }

}
