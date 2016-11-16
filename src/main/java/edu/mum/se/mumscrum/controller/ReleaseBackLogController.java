package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.ReleaseBackLog;
import edu.mum.se.mumscrum.service.ReleaseBackLogService;
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
import java.sql.Date;

/**
 * Created by tony on 11/14/16.
 */
@Controller
public class ReleaseBackLogController {

    @Autowired
    private ReleaseBackLogService releaseBackLogService;

    @RequestMapping(value = "/releaseBackLogList/{pid}", method = RequestMethod.GET)
    public String releaseBackLogList(@PathVariable("pid") int pid,
                                     Model model){
        model.addAttribute("currentProductBackLog", pid);
        model.addAttribute("releaseBackLogList", releaseBackLogService.getAllReleaseBackLog(pid));
        return "releaseBackLogList";
    }

    @RequestMapping(value = "/releaseBackLog/{pid}", method = RequestMethod.GET)
    public String releaseBackLogPage(@PathVariable("pid") int pid,
                                     Model model,
                                     HttpSession session){
        ReleaseBackLog releaseBackLog = new ReleaseBackLog();
        releaseBackLog.setPid(pid);

        Employee e = (Employee)session.getAttribute("employee");
        releaseBackLog.setUid(e.getEid());

        releaseBackLog.setReleaseDate(new Date(2016,11,15));
        model.addAttribute("currentProductBackLog", pid);
        model.addAttribute("releaseBackLog", releaseBackLog);
        return "releaseBackLog";
    }

    @RequestMapping(value = "releaseBackLog/{pid}/{rid}", method = RequestMethod.GET)
    public String updateReleaseBackLog(@PathVariable("pid") int pid,
                                     @PathVariable("rid") int rid,
                                     Model model){
        ReleaseBackLog releaseBackLog = releaseBackLogService.findByRid(rid);
        model.addAttribute("currentProductBackLog", pid);
        model.addAttribute("releaseBackLog", releaseBackLog);
        return "releaseBackLog";
    }

    // Save and Update
    @RequestMapping(value = "/releaseBackLog/{pid}", method = RequestMethod.POST)
    public String saveOrUpdateReleaseBackLog(@PathVariable("pid") int pid,
                                             @ModelAttribute("releaseBackLog") @Validated ReleaseBackLog releaseBackLog,
                                             BindingResult result,
                                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("currentProductBackLog", pid);
            model.addAttribute("releaseBackLog", releaseBackLog);
            return "releaseBackLog";
        }else{
            //update
            if(releaseBackLog.getRid()!=0) {
                releaseBackLogService.save(releaseBackLog);
                model.addAttribute("releaseBackLogList", releaseBackLogService.getAllReleaseBackLog(pid));
                return "redirect:/releaseBackLogList/"+pid;
            }
            else if (releaseBackLogService.findByName(pid, releaseBackLog.getName())){
                model.addAttribute("message", "Release BackLog already exists. Try again");
                model.addAttribute("currentProductBackLog", pid);
                return "releaseBackLog";
            }
            releaseBackLogService.save(releaseBackLog);
            model.addAttribute("releaseBackLogList", releaseBackLogService.getAllReleaseBackLog(pid));
            return "redirect:/releaseBackLogList/"+pid;
        }
    }


    // Delete
    @RequestMapping(value = "/releaseBackLog/{pid}/{rid}/delete")
    public String deleteByRid(@PathVariable("pid") int pid,
                              @PathVariable("rid") int rid,
                              Model model){
        releaseBackLogService.deleteByRid(rid);
        model.addAttribute("releaseBackLogList", releaseBackLogService.getAllReleaseBackLog(pid));
        return "redirect:/releaseBackLogList/"+pid;
    }
}
