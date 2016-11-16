package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.ProductBackLog;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.service.ProductBackLogService;
import edu.mum.se.mumscrum.service.UserStoryService;
import edu.mum.se.mumscrum.utilities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Min Gaung on 12/11/2016.
 */
@Controller
public class UserStoryController {

    @Autowired
    private UserStoryService userStoryService;
    @Autowired
    private ProductBackLogService productBackLogService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,false));

    }
    @ModelAttribute("productBackLogs")
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
    }
    @RequestMapping(value = "/userstorylist", method = RequestMethod.GET)
    public String userStoryList(Model model) {
        model.addAttribute("userstories", userStoryService.getAllUserStory());
        return "userstorylist";
    }


    @RequestMapping(value = "/userstoryupdate/{id}", method = RequestMethod.GET)
    public String UserStoryUpdate(@PathVariable("id") int id, Model model) {

        Userstory userstory = new Userstory();
        userstory = userStoryService.findByID(id);
        model.addAttribute("userstory", userstory);
        return "userstory";
    }

    @RequestMapping(value = "/userstory", method = RequestMethod.GET)
    public String UserStoryPage(Model model) {

        model.addAttribute("userstory", new Userstory());
        return "userstory";
    }

    //Save or update
    @RequestMapping(value = "/userstory", method = RequestMethod.POST)
    public String saveOrUpdateUserStory(@ModelAttribute("userstory") @Validated Userstory userstory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "userstory";
        }else{
            //update
           if(userstory.getUid()!=0) {
                userStoryService.save(userstory);
               return "redirect:/admin";
           }
            else if (userStoryService.checkByName(userstory.getName())){
               model.addAttribute("message", "UserStory already exists. Try again");
               return "userstory";
           }
            userStoryService.save(userstory);
            return "redirect:/userstorylist";
        }


    }

    //Delete
    @RequestMapping(value = " userstorydelete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id){
        userStoryService.delete(id);
        return "redirect:/userstorylist";
    }
}
