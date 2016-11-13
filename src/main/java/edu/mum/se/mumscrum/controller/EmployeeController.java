package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.EmployeeLogin;
import edu.mum.se.mumscrum.model.HiddenValue;
import edu.mum.se.mumscrum.service.EmployeeService;
import edu.mum.se.mumscrum.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Min Gaung on 12/11/2016.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    HiddenValue hiddenValue=new HiddenValue();
    private void roles(Model model)
    {
        Map<String,String> roleH = new LinkedHashMap<String,String>();
        for (Role role : EnumSet.allOf(Role.class)) {
            roleH.put(role.name(),role.desc());
        }
        model.addAttribute("roleList",roleH);
    }

    @RequestMapping(value="/employeelist", method= RequestMethod.GET)
    public String employeeList(Model model) {

       model.addAttribute("hb",hiddenValue);
        model.addAttribute("employees",employeeService.getAllEmployee());
        return "employeelist";
    }



    @RequestMapping(value="/employeeUpdate", method= RequestMethod.POST)
    public String employeeUpdate(Model model) {

        String id=hiddenValue.getHiddenID();
        Employee employee=new Employee();

        if(id!=null)
            employee=employeeService.findByID(id);
        else
            roles(model);

        model.addAttribute("employee",employee);
        return "redirect:/employee";
    }

    /*

    @RequestMapping(value="/admin", method= RequestMethod.GET)
    public String adminPage(HttpServletRequest request , Model model) {
        String id=request.getParameter("hVal");
        Employee employee=new Employee();

        if(id !=null)
            employee=employeeService.findByID(id);
        else
            roles(model);
        employee.isNew();
        model.addAttribute("employee", employee);
        return "admin";
    }
    @RequestMapping(value="/admin", method=RequestMethod.POST)
    //@ModelAttribute("userForm") @Validated User user,
   // BindingResult result, Model model, final RedirectAttributes redirectAttributes)
    public String adminSave(Employee employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            roles(model);
            return "admin";
        } else if (employeeService.findByEmail(employee.getEmail())) {
            model.addAttribute("message", "Employee already exists. Try again");
            roles(model);
            return "admin";
        }
        employeeService.save(employee);
        model.addAttribute("message", "Saved employee details");
        return "adminlist";
    }
    */




}
