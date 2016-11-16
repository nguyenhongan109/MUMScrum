package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.ReleaseBackLog;
import edu.mum.se.mumscrum.service.ProductBackLogService;
import edu.mum.se.mumscrum.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Min Gaung on 12/11/2016.
 */
@Controller
public class ReleaseController {

    @Autowired
    private ReleaseService releaseService;
    @Autowired
    private ProductBackLogService productBackLogService;


    @RequestMapping(value = "/release/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ReleaseBackLog>> listSprintByProject(@PathVariable("id") int pid) {

        HttpStatus httpStatus = HttpStatus.OK;
        //ReleaseBackLog release = releaseService.findByPID(pid);
        List<ReleaseBackLog> releaseList;
        if(pid==0){
            releaseList = releaseService.findAll();
        }else{
            releaseList = releaseService.findByPID(pid);
        }

        return new ResponseEntity<List<ReleaseBackLog>>(releaseList, httpStatus);
    }
    @RequestMapping(value = "/release", method = RequestMethod.GET)
    public String listRelease(Model model) {
        List<ReleaseBackLog> listrelease = releaseService.findAll();
        model.addAttribute("releases", listrelease);
        return "listrelease";
    }
}
