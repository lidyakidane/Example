package com.managment.hr.domain;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 11/26/14
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String position;
    private long salary;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="companyId")
    private Company company;
  public Employee()
  {
  }
  public Employee(String name,String position,long salary)
  {
   this.name=name;
   this.position=position;
   this.salary=salary;
  }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
