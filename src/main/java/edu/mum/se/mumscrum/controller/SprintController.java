package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.ProductBackLog;
import edu.mum.se.mumscrum.model.Sprint;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.service.ProductBackLogService;
import edu.mum.se.mumscrum.service.SprintService;
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

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Min Gaung on 12/11/2016.
 */
@Controller
public class SprintController {

    @Autowired
    private SprintService sprintService;
    @RequestMapping(value = "/sprintlist", method = RequestMethod.GET)
    public String userStoryList(Model model, HttpSession session) {
        Employee employee=(Employee)session.getAttribute("employee");
        model.addAttribute("sprints", sprintService.findByCreatedBy(employee.getEid()));
        return "sprintlist";
    }


    @RequestMapping(value = "/sprintupdate/{id}", method = RequestMethod.GET)
    public String UserStoryUpdate(@PathVariable("id") int id, Model model) {

        Sprint sprint = sprintService.findBySid(id);
        model.addAttribute("sprint", sprint);
        return "sprint";
    }

    @RequestMapping(value = "/sprint", method = RequestMethod.GET)
    public String UserStoryPage(Sprint sprint,Model model) {
        sprint.setStatus(Status.NEW.name());
        model.addAttribute("sprint", sprint);
        return "sprint";
    }

    //Save or update
    @RequestMapping(value = "/sprint", method = RequestMethod.POST)
    public String saveOrUpdateUserStory(@ModelAttribute("sprint") @Validated Sprint sprint, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "sprint";
        }else{
           if (sprint.getSid()==0 && sprintService.checkByName(sprint.getName())){
               model.addAttribute("message", "Sprint already exists. Try again");
               return "sprint";
           }
            sprintService.save(sprint);
            return "redirect:/sprintlist";
        }
    }

    //Delete
    @RequestMapping(value = " sprintdelete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        sprintService.delete(id);
        return "redirect:/sprintlist";
    }
}
