package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.EmployeeLogin;
import edu.mum.se.mumscrum.service.EmployeeService;
import edu.mum.se.mumscrum.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Controller
@SessionAttributes("employee")
public class LoginController {


    @Autowired
    private EmployeeService employeeService;

   @RequestMapping(value="/login", method= RequestMethod.GET)
    public String loginPage(Model model) {
       model.addAttribute("loginPage",true);
       model.addAttribute("employeeLogin", new EmployeeLogin());
       return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@Valid @ModelAttribute("employeeLogin") EmployeeLogin employeeLogin, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "login";
        } else {
            Employee employee = employeeService.findByLogin(employeeLogin.getEmail(),employeeLogin.getPassword());
            if (employee!=null) {
                session.setAttribute("employee",employee);

                if(Role.ADMIN.name().equals(employee.getRole()))
                    return "redirect:/admin";
                if(Role.POWNER.name().equals(employee.getRole()))
                    return "redirect:/productBackLogList";

                return "success";
            } else {
                return "failure";
            }
        }

    }

}
