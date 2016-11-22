package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Employee;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
public interface EmployeeService {
    Employee findByLogin(String email, String password);
    boolean findByEmail(String email);
    List<Employee> getAllEmployee();
    Employee findByID(int id);
    void save(Employee employee);
    void delete(int id);
    List<Employee> findByRole(String role);
}
