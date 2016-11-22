package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.Timelogs;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.service.TimelogsService;
import edu.mum.se.mumscrum.service.UserStoryService;
import edu.mum.se.mumscrum.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by phandungmykieu on 11/13/16.
 */
@Controller
public class EffortController {

    @Autowired
    UserStoryService usService;
    @Autowired
    TimelogsService timelogsService;

    private void status(Model model){
        Map<String, String> statusH = new LinkedHashMap<String, String>();
        for (Status status : EnumSet.allOf(Status.class)) {
            if(status.name()!=status.NEW.toString())
            statusH.put(status.name(), status.desc());
        }
        model.addAttribute("statusList", statusH);
    }


    //show a list of Estimate
    @RequestMapping(value ="/effortList", method = RequestMethod.GET)
    public String USList(Model model, HttpSession session){
        Employee employee = (Employee) session.getAttribute("employee");
        model.addAttribute("USList", usService.findByEmployee(employee.getEid()));
        return "effortList";
    }

    //retrieve 1 userStory
    @RequestMapping(value = "/estimateEffort/{id}", method = RequestMethod.GET)
    public String retrieveUserStory(Model model, @PathVariable("id") int id){
        model.addAttribute("userStory", usService.findByID(id));
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
    public ModelAndView retrieveUpdateEffort(@ModelAttribute("timelogs") @Validated Timelogs timelogs
            , @PathVariable("id") int id, Model model, HttpSession session){


        status(model);
        session.setAttribute("userStory", usService.findByID(id));
        ModelAndView mv=new ModelAndView("updateEffort");
        mv.addObject("userStory",usService.findByID(id));
        mv.addObject("timelogs",timelogs);
       // model.addAttribute("userStory", usService.findByID(id));
        //return "updateEffort";


        return mv;
    }

    //update Effort
    @RequestMapping(value ="/updateEffort", method = RequestMethod.POST)
    public String updateEffort(@ModelAttribute("timelogs") @Validated Timelogs timelogs,
                                    BindingResult result, Model model, HttpSession session){


        int newActualEffort = 0;
        Userstory userstory = (Userstory) session.getAttribute("userStory");

        //save information to timelogs
        java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        timelogs.setUpdatedDate(currentDate);

        Timelogs oldTimelogs = timelogsService.findByUidANDUpdatedDate(userstory.getUid(), currentDate);



        int oldActualEffort = usService.findByID(userstory.getUid()).getActualEffort();

        if(oldTimelogs !=null) {


            newActualEffort = oldActualEffort - oldTimelogs.getTodayEffort()+ timelogs.getTodayEffort();

        }
            else {

                oldTimelogs=new Timelogs();

                newActualEffort = oldActualEffort + timelogs.getTodayEffort();
        }


        userstory.setActualEffort(newActualEffort);

        int remainingEffort = userstory.getEstimatedEffort() - newActualEffort;

        oldTimelogs.setTodayEffort(timelogs.getTodayEffort());

        oldTimelogs.setUpdatedDate(currentDate);

        oldTimelogs.setDuration(remainingEffort);

        oldTimelogs.setSid(userstory.getSid());

        oldTimelogs.setUid(userstory.getUid());

            timelogsService.saveTimeLog(oldTimelogs);

            usService.save(userstory);


        return "redirect:/effortList";
    }



}
