package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findByLogin(String email, String password) {
        Employee employee = employeeRepository.findByEmployeeEmail(email);
        if(employee !=null && employee.getPassword().equals(password))
            return employee;
        else
            return null;
    }

    public List<Employee> getAllEmployee() {
       return employeeRepository.getAllEmployee();
    }

    public boolean findByEmail(String email) {
        Employee employee=  employeeRepository.findByEmployeeEmail(email);
        if(employee !=null)
            return true;
        return false;
    }

    @Override
    public Employee findByID(String eid) {
        Employee employee = employeeRepository.findByEmployeeEmail(eid);
        if(employee !=null)
            return employee;
        else
            return null;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
