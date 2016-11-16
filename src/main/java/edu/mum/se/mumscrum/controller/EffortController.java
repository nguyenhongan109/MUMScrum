package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.repository.USRepository;
import edu.mum.se.mumscrum.service.USService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by phandungmykieu on 11/13/16.
 */
@Controller
public class EffortController {

    @Autowired
    USService usService;

    //show a list of Estimate
    @RequestMapping(value ="/effortList", method = RequestMethod.GET)
    public String USList(Model model){
        model.addAttribute("USList", usService.getAllUS());
        return "effortList";
    }

    //retrieve 1 userStory
    @RequestMapping(value = "/estimateEffort/{id}", method = RequestMethod.GET)
    public String retrieveUserStory(Model model, @PathVariable("id") int id){
        model.addAttribute("userStory", usService.retrieveUS(id));
        return "estimateEffort";
    }

    @RequestMapping(value ="/estimateEffort/{id}", method = RequestMethod.POST)
    public String estimateUserStory(@ModelAttribute("userStory") @Validated Userstory userStory,
                                    BindingResult result, Model model){
        usService.save(userStory);
        return "redirect:/effortList";
    }

    //update Effort
    @RequestMapping(value = "/updateEffort/{id}", method = RequestMethod.GET)
    public String retrieveUpdateEffort(@ModelAttribute("userStory") @Validated Userstory userStory
            , @PathVariable("id") int id, Model model){

        model.addAttribute("userStory", usService.retrieveUS(id));
        return "updateEffort";
    }
//    @RequestMapping(value ="/updateEffort/${id}", method = RequestMethod.POST)
//    public String updateEstimateEffort(@ModelAttribute("userStory") @Validated Userstory userStory,
//                                    BindingResult result, Model model){
//        usService.save(userStory);
//        return "redirect:/userStoryList";
//    }


//    //Delete
//    @RequestMapping(value = " employee/{id}/delete", method = RequestMethod.GET)
//    public String delete(@PathVariable("id") int id){
//        employeeService.delete(id);
//        return "redirect:/employeelist";
//    }
}
