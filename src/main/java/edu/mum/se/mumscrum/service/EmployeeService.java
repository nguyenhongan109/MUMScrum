package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Employee;

/**
 * Created by Min Gaung on 11/11/2016.
 */
public interface EmployeeService {
    Employee findByLogin(String email, String password);
}
