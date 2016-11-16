package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.ProductBackLog;
import edu.mum.se.mumscrum.model.Sprint;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.service.ProductBackLogService;
import edu.mum.se.mumscrum.service.SprintService;
import edu.mum.se.mumscrum.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Min Gaung on 12/11/2016.
 */
@Controller
public class SprintController {

    @Autowired
    private SprintService sprintService;
    @Autowired
    private ProductBackLogService productBackLogService;


    @RequestMapping(value = "/sprint/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Sprint>> listSprintByProject(@PathVariable("id") int projectId) {

        HttpStatus httpStatus = HttpStatus.OK;
        Project project = projectService.findProjectByID(projectId);
        List<Sprint> listSprint;
        if(project == null){
            listSprint = sprintService.findAll();
        }else{
            listSprint = sprintService.findSprintByProject(project);
        }

        return new ResponseEntity<List<Sprint>>(listSprint, httpStatus);
    }
}
