package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.ProductBackLog;
import edu.mum.se.mumscrum.model.Timelogs;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.service.EmployeeService;
import edu.mum.se.mumscrum.service.ProductBackLogService;
import edu.mum.se.mumscrum.service.TimelogsService;
import edu.mum.se.mumscrum.service.UserStoryService;
import edu.mum.se.mumscrum.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by phandungmykieu on 11/13/16.
 */
@Controller
public class AssignPBController {

    @Autowired
    private ProductBackLogService productBackLogService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/assignPBL", method = RequestMethod.GET)
    public String productBackLogList(Model model){

        model.addAttribute("assignPBL", productBackLogService.getAllProductBackLog());
        return "assignPBL";
    }

    @RequestMapping(value = "/assignPB/{id}", method = RequestMethod.GET)
    public String productBackLogDetail(@PathVariable("id") int id, Model model, HttpSession session){
        ProductBackLog productBackLog = new ProductBackLog();
        productBackLog = productBackLogService.findByPid(id);

        session.setAttribute("productBackLog", productBackLog);
        model.addAttribute("productBackLog", productBackLog);
        List<Employee> employeeList = employeeService.findByRole("SCRUMASTER");
        model.addAttribute("employeeList", employeeList);

        return "assignPB";
    }

    @RequestMapping(value ="/assignPB", method = RequestMethod.POST)
    public String estimateUserStory(@ModelAttribute("productBackLog") @Validated ProductBackLog productBackLog,
                                    BindingResult result, Model model, HttpSession session){

        ProductBackLog oldProductBackLog = (ProductBackLog) session.getAttribute("productBackLog");

        oldProductBackLog.setAssignedTo(productBackLog.getAssignedTo());

        productBackLogService.save(oldProductBackLog);
        return "redirect:/assignPBL";
    }

}
