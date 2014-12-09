package com.managment.hr.persistence;

import com.managment.hr.domain.Company;
import com.managment.hr.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import org.hibernate.SessionFactory;
/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 11/26/14
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */

@Transactional
@Component
public class PersitenceImp implements IhrPresistence{
    @Autowired
    private SessionFactory  sessionFacoty;

    @Override
    public void createEmployee(Employee emp) {
        sessionFacoty.getCurrentSession().saveOrUpdate(emp);
    }

    @Override
    public void createCompany(Company company) {
      sessionFacoty.getCurrentSession().saveOrUpdate(company);
    }
    @Override
    public Employee deleteEmployee(long id) {
        Employee emp=getEmployee(id);
       sessionFacoty.getCurrentSession().delete(emp);
        return emp;
    }
    @Override
    public Company deleteCompany(long id) {
      Company company=getCompany(id);
        sessionFacoty.getCurrentSession().delete(company);
        return company;
    }
    @Override
    public boolean updatedCompany(Company company) {
       sessionFacoty.getCurrentSession().update(company);
       return true;
    }
    @Override
    public boolean updateEmployee(long id) {
        Employee emp=getEmployee(id);
       sessionFacoty.getCurrentSession().update(emp);
        return true;
    }
    @Override
    public Employee getEmployee(long id) {
     return (Employee)sessionFacoty.getCurrentSession().get(Employee.class,id);
    }

    @Override
    public Company getCompany(long id) {
       return (Company)sessionFacoty.getCurrentSession().get(Company.class,id);
    }

    @Override
    public List<Employee> getAllEmployee(long compid) {
        return  (List<Employee>)sessionFacoty.getCurrentSession().createQuery("select e from Employee e right join fetch e.company where e.company="+compid).list();
    }
}
