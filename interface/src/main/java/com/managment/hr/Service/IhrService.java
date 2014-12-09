package com.managment.hr.Service;

import com.managment.hr.domain.Company;
import com.managment.hr.domain.Employee;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 11/26/14
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IhrService {
        public Employee createEmploye(Employee employee);
        public Company createCompany(Company company);
        public Employee getEmploye(long id);
        public Company getCompany(long id);
        public Employee deleteEmployee(long id);
        public List<Employee> getAllEmploye(long companyId);
        public Company deleteCompany(long Id);
        public boolean updateCompany(Company Id);
        public boolean updateEmployee(Employee employee);
}
