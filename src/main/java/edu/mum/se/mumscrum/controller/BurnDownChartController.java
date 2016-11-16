package edu.mum.se.mumscrum.controller;

/**
 * Created by mehdi on 11/15/16.
 */



import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.service.EmployeeService;
import edu.mum.se.mumscrum.utilities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;



@Controller
public class BurnDownChartController {


    @RequestMapping(value = "/bdc", method = RequestMethod.GET)
    public String bdc(Model model) {
        return "BurnDownChart";
    }

}
