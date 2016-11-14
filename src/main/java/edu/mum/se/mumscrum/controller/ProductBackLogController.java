package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.service.ProductBackLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tony on 11/14/16.
 */
@Controller
public class ProductBackLogController {
    @Autowired
    private ProductBackLogService productBackLogService;

    @RequestMapping(value = "/productBackLogList", method = RequestMethod.GET)
    public String productBackLogList(Model model){
        model.addAttribute("productBackLogList", productBackLogService.getAllProductBackLog());
        return "productBackLogList";
    }
}
