package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.*;
import edu.mum.se.mumscrum.service.*;
import edu.mum.se.mumscrum.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Min Gaung on 12/11/2016.
 */
@Controller
public class AssignSprintController {

    @Autowired
    private SprintService sprintService;
    @Autowired
    private UserStoryService userStoryService;
    @Autowired
    private ReleaseBackLogService releaseBackLogService;



    @RequestMapping(value = "/AssignSprintList", method = RequestMethod.GET)
    public String sprintList(Model model, HttpSession session) {
        Employee employee=(Employee)session.getAttribute("employee");
        model.addAttribute("sprints", sprintService.findByCreatedBy(employee.getEid()));
        return "AssignSprintList";
    }


    @RequestMapping(value = "/AssignSprint/{id}", method = RequestMethod.GET)
    public String SprintUpdate(@PathVariable("id") int id, Model model, HttpSession session) {
        model.addAttribute("userstorybysid", userStoryService.findBySid(id));
        model.addAttribute("userstory", userStoryService.findBySidIsNull());
        session.setAttribute("Sprint",sprintService.findBySid(id));
        return "AssignSprint";
    }
    //Update
    @RequestMapping(value = " assignSprintUpdate/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id,HttpSession session, Model model){
        Sprint sp=(Sprint)session.getAttribute("Sprint");
        Userstory userstory=userStoryService.findByID(id);
        ReleaseBackLog releaseBackLog=releaseBackLogService.findByRid(userstory.getRid());
        // Business Rule: Release Date must be greater than sprint End Date.
        if(releaseBackLog.getReleaseDate().compareTo(sp.getEndDate())<0)
        {
            model.addAttribute("message","Release Date must be greater than sprint End Date");
        }
        else
        {
            model.addAttribute("message","");
            userstory.setSid(sp.getSid());
            userStoryService.save(userstory);
        }
        model.addAttribute("userstorybysid", userStoryService.findBySid(sp.getSid()));
        model.addAttribute("userstory", userStoryService.findBySidIsNull());
        return "AssignSprint";
    }

        //Delete
    @RequestMapping(value = "assignSprintdelete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, Model model,HttpSession session){
        Sprint sp=(Sprint)session.getAttribute("Sprint");
        Userstory userstory=userStoryService.findByID(id);
        userstory.setSid(null);
        userStoryService.save(userstory);
        model.addAttribute("userstorybysid", userStoryService.findBySid(sp.getSid()));
        model.addAttribute("userstory", userStoryService.findBySidIsNull());
        return "AssignSprint";
    }

}
