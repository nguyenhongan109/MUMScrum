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
        Employee employee = employeeRepository.findByEmail(email);
        if(employee !=null && employee.getPassword().equals(password))
            return employee;
        else
            return null;
    }

    public List<Employee> getAllEmployee() {
       return employeeRepository.findAll();
    }

    public boolean findByEmail(String email) {
        Employee employee=  employeeRepository.findByEmail(email);
        if(employee !=null)
            return true;
        return false;
    }

    @Override
    public Employee findByID(int id) {
        Employee employee = employeeRepository.findByEid(id);
        if(employee !=null)
            return employee;
        else
            return null;
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(int id)
    {
        employeeRepository.deleteByEid(id);
    }

    @Override
    public List<Employee> findByRole(String role) {
        return employeeRepository.findByRole(role);
    }
}
