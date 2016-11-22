package edu.mum.se.mumscrum.controller;

/**
 * Created by mehdi on 11/15/16.
 */



import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.Sprint;
import edu.mum.se.mumscrum.service.BurnDownChartService;
import edu.mum.se.mumscrum.service.EmployeeService;
import edu.mum.se.mumscrum.service.SprintService;
import edu.mum.se.mumscrum.service.UserStoryService;
import edu.mum.se.mumscrum.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



@Controller
public class BurnDownChartController {


    @Autowired
    UserStoryService usService;

    @Autowired
    BurnDownChartService bdcService;

    @Autowired
    SprintService sprintService;

    @RequestMapping(value = "/burndownchart", method = RequestMethod.POST)
    public String bdc(Sprint sprint,Model model) {
        model.addAttribute("bdc", bdcService.getBurnDownData(sprint.getSid()));
        return "burndownchartview";
    }


    @RequestMapping(value = "/burndownchart", method = RequestMethod.GET)
    public String burndown(Model model, HttpSession session) {
        Employee employee=(Employee)session.getAttribute("employee");
        model.addAttribute("sprint",new Sprint());
        model.addAttribute("sprints", sprintService.findByCreatedBy(employee.getEid()));
        return "burndownchart";
    }


}
