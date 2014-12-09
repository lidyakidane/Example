package com.managment.hr.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: mabraha
 * Date: 11/26/14
 * Time: 12:31 PM
 * To change this template use File | Settings | File Templates.
 */
 @Entity
public class Company implements Serializable
{
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String location;
    public Company()
    {

    }
   public Company(String name,String location)
   {
    this.name=name;
    this.location=location;
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
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}
