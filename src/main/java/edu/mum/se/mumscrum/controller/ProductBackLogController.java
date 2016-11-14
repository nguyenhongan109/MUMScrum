package edu.mum.se.mumscrum.controller;

import edu.mum.se.mumscrum.model.ProductBackLog;
import edu.mum.se.mumscrum.service.ProductBackLogService;
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

import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;

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

    private void status(Model model){
        Map<String, String> statusH = new LinkedHashMap<String, String>();
        for (Status status : EnumSet.allOf(Status.class)) {
            statusH.put(status.name(), status.desc());
        }
        model.addAttribute("statusList", statusH);
    }

    @RequestMapping(value = "/productBackLog", method = RequestMethod.GET)
    public String productBackLogPage(Model model) {

        status(model);
        model.addAttribute("productBackLog",new ProductBackLog());
        return "productBackLog";
    }

    //Save or update
    @RequestMapping(value = "/productBackLog", method = RequestMethod.POST)
    public String saveOrUpdateProductBackLog(@ModelAttribute("productBackLog") @Validated ProductBackLog productBackLog, BindingResult result, Model model) {
        if (result.hasErrors()) {
            status(model);
            return "productBackLog";
        }else{
            //update
            if(productBackLog.getPid()!=0) {
                productBackLogService.save(productBackLog);
                return "redirect:/productBackLogList";
            }
            else if (productBackLogService.findByName(productBackLog.getName())){
                model.addAttribute("message", "Product BackLog already exists. Try again");
                status(model);
                return "productBackLog";
            }
            productBackLogService.save(productBackLog);
            return "redirect:/productBackLogList";
        }
    }

    // Delete
    @RequestMapping(value = "/productBackLogList/{id}/delete")
    public String deleteByPid(@PathVariable("id") int id){
        productBackLogService.deleteByPid(id);
        return "redirect:/productBackLogList";
    }


}
