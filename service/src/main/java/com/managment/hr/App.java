package com.managment.hr;

import com.managment.hr.Service.IhrService;
import com.managment.hr.domain.Company;
import com.managment.hr.domain.Employee;
import com.managment.hr.services.servicesImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        try
        {
         ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
         IhrService hrservice=(servicesImp)context.getBean("servicesImp",IhrService.class);
            Company cmp=new Company("Applo","Arizona");
            hrservice.createCompany(cmp);
            Employee emp=new Employee("Dawit","Software Engineer",69090);
            emp.setCompany(cmp);
            hrservice.createEmploye(emp);
            Employee emp1=new Employee("Feven","Engineer",369090);
            emp1.setCompany(cmp);
            hrservice.createEmploye(emp1);
            Employee emp2=new Employee("Chelley","Recriture",56262);
            emp2.setCompany(cmp);
            hrservice.createEmploye(emp2);
            System.out.println("Company created");
            Company c=hrservice.getCompany(cmp.getId());
            System.out.println("Company Found:"+c.getName());
            List<Employee> elist;
            elist=hrservice.getAllEmploye(cmp.getId());
            for(Employee e:elist)
            {
             System.out.println(e.getName()) ;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    }