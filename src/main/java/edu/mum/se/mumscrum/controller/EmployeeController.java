package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.service.EmployeeService;
import edu.mum.se.mumscrum.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Min Gaung on 12/11/2016.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    private void roles(Model model) {
        Map<String, String> roleH = new LinkedHashMap<String, String>();
        for (Role role : EnumSet.allOf(Role.class)) {
            roleH.put(role.name(), role.desc());
        }
        model.addAttribute("roleList", roleH);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String employeeList(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "admin";
    }


    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    public String employeeUpdate(@PathVariable("id") int id, Model model) {

        Employee employee = new Employee();
        roles(model);
        employee = employeeService.findByID(id);
        model.addAttribute("employee", employee);
        return "employee";
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employeePage(Employee employee,Model model) {

        roles(model);
        model.addAttribute("employee", employee);
        return "employee";
    }

    //Save or update
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String saveOrUpdateEmployee(@ModelAttribute("employee") @Validated Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            roles(model);
            return "employee";
        }else{
            //update
           if(employee.getEid()!=0) {
                employeeService.save(employee);
               return "redirect:/admin";
           }
            else if (employeeService.findByEmail(employee.getEmail())){
               model.addAttribute("message", "Employee already exists. Try again");
               roles(model);
               return "employee";
           }
            employeeService.save(employee);
            return "redirect:/admin";
        }


    }

    //Delete
    @RequestMapping(value = " employee/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        employeeService.delete(id);
        return "redirect:/employeelist";
    }
}
