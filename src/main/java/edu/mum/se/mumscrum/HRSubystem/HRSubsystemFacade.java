package edu.mum.se.mumscrum.HRSubystem;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Min Gaung on 18/11/2016.
 */
@Service("hrSubsystemFacade")
public class HRSubsystemFacade implements IHRSubsystem {

    @Autowired
    EmployeeService employeeService;

    @Override
    public Employee findByLogin(String email, String password) {
        return employeeService.findByLogin(email,password);
    }

    @Override
    public boolean findByEmail(String email) {
        return employeeService.findByEmail(email);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @Override
    public Employee findByID(int id) {
        Employee employee = employeeService.findByID(id);
        if(employee !=null)
            return employee;
        else
            return null;
    }

    @Override
    public void save(Employee employee) {
        employeeService.save(employee);
    }
    @Override
    public void delete(int id)
    {
        employeeService.delete(id);
    }
}
