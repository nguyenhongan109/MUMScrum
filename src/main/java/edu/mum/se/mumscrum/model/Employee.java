package edu.mum.se.mumscrum.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Min Gaung on 11/11/2016.
 */


@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    @Size(min=4, max=20)
    private String firstName;
    @NotEmpty
    @Size(min=4, max=20)
    private String lastName;
    @NotEmpty(message = "Please enter your email addresss.")
    @Email
    private String email;
    @NotEmpty(message = "Please enter your password.")
    @Size(min=5, message="Password must be at least 5 characters.")
    private String password;
    private String role;
  //  private String roleDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
/*
    public String getroleDesc() {
        return roleDesc;
    }

    public void setroleDesc() {
        this.roleDesc = Role.valueOf(this.role).desc();
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (role != employee.role) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (password != null ? !password.equals(employee.password) : employee.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }


}
