/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jasper
 */

    @Entity
@Table(name = "employee")
@XmlRootElement

public class EmployeeEntity extends BasicEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String starthr;
    private String endhr;
    private String job;
    private String address;
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStarthr() {
        return starthr;
    }

    public void setStarthr(String starthr) {
        this.starthr = starthr;
    }

    public String getEndhr() {
        return endhr;
    }

    public void setEndhr(String endhr) {
        this.endhr = endhr;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
