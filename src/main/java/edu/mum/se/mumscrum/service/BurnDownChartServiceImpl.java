package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.BurnDownChartData;
import edu.mum.se.mumscrum.model.Sprint;
import edu.mum.se.mumscrum.repository.SprintRepository;
import edu.mum.se.mumscrum.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mehdi on 11/17/16.
 */
public class BurnDownChartImpl implements BurnDownChart {


    @Autowired
    private UserStoryRepository userStoryRepository;

    @Autowired
    private SprintRepository sprintRepository;


    public BurnDownChartData getBurnDownChartData(){


        BurnDownChartData bdc = new BurnDownChartData();

        // TODO : change the Sprint id cause a set it manualy
        Sprint s = sprintRepository.findBySid(2);
        if(s != null){
             bdc.setSid(s.getSid());
        }


    }


}
