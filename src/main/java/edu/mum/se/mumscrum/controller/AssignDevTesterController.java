package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.ProductBackLog;
import edu.mum.se.mumscrum.model.ReleaseBackLog;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.service.EmployeeService;
import edu.mum.se.mumscrum.service.ProductBackLogService;
import edu.mum.se.mumscrum.service.ReleaseService;
import edu.mum.se.mumscrum.service.UserStoryService;
import edu.mum.se.mumscrum.utilities.Role;
import edu.mum.se.mumscrum.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Min Gaung on 12/11/2016.
 */
@Controller
public class AssignDevTesterController {

    @Autowired
    private UserStoryService userStoryService;
    @Autowired
    private EmployeeService employeeService;

    /*@ModelAttribute("productBackLogs")
    public List<ProductBackLog> getAllProductBackLog() {
        return productBackLogService.getAllProductBackLog();
    }
    @ModelAttribute("statuslists")
    private Map<String, String> status(Model model){
        Map<String, String> statusH = new LinkedHashMap<String, String>();
        for (Status status : EnumSet.allOf(Status.class)) {
            statusH.put(status.name(), status.desc());
        }
        return statusH;
    }*/
    @RequestMapping(value = "/AssignDevList", method = RequestMethod.GET)
    public String userStoryList(Model model) {
        model.addAttribute("AssignDevUSList", userStoryService.getAllUserStory());
        return "AssignDevList";
    }


    @RequestMapping(value = "/AssignDevList/{id}", method = RequestMethod.GET)
    public String UserStoryUpdate(@PathVariable("id") int id, Model model) {

        Userstory userstory = new Userstory();
        userstory = userStoryService.findByID(id);
        List<Employee> developerlist=employeeService.findByRole(Role.DEVELOPER.name());
        developerlist.addAll(employeeService.findByRole(Role.TESTER.name()));
        model.addAttribute("devlist",developerlist);
        model.addAttribute("userstory", userstory);
        return "assignUStoDev";
    }


    //Save or update
    @RequestMapping(value = "/assignUStoDev", method = RequestMethod.POST)
    public String saveOrUpdateUserStory(@ModelAttribute("userstory") @Validated Userstory userstory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "assignUStoDev";
        }else{
            userStoryService.save(userstory);
            return "redirect:/AssignDevList";
        }


    }

}
