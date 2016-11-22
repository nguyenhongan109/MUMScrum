package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.BurnDownChartData;
import edu.mum.se.mumscrum.model.BurnDownData;
import edu.mum.se.mumscrum.model.Sprint;
import edu.mum.se.mumscrum.model.Timelogs;
import edu.mum.se.mumscrum.repository.SprintRepository;
import edu.mum.se.mumscrum.repository.TimelogsRepository;
import edu.mum.se.mumscrum.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mehdi on 11/17/16.
 */

@Service("burnDownChartService1")
public class BurnDownChartServiceImpl implements BurnDownChartService {


    @Autowired
    private UserStoryRepository userStoryRepository;

    @Autowired
    private SprintRepository sprintRepository;

   @Autowired
   private TimelogsRepository timelogsRepository;


    public BurnDownChartData getBurnDownData(int sid){




        int mySprintId =  sid ; // i forced the sprint id to 2 for now


        Sprint s = sprintRepository.findBySid(mySprintId);

        BurnDownChartData bdc = new BurnDownChartData();
        bdc.setSid(s.getSid());
        bdc.setStartDate(s.getStartDate());
        bdc.setEndDate(s.getEndDate());

        bdc.setDeadLine(getDateDiffByDays(s.getEndDate(),s.getStartDate()));


        List<Timelogs> fromdb =  timelogsRepository.findAll();


        int firstKey = -1;
        int lastKey = -1;

        HashMap<Integer,Integer> myMap = new HashMap<Integer,Integer>();

        for(Timelogs t : fromdb){

            if(t.getSid() == mySprintId){

                int index =  getDateDiffByDays(t.getUpdatedDate(),bdc.getStartDate());
                if(firstKey == -1){
                    firstKey = index;
                }
                if(myMap.get(index) != null){
                    myMap.put(index, myMap.get(index) +  t.getDuration());
                }else{
                    myMap.put(index,t.getDuration());
                }

                lastKey = index;
            }
        }

        bdc.setFirstKey(firstKey);
        bdc.setLastKey(lastKey);

        bdc.setBars(myMap);


        int x = (int) Math.ceil((float)(myMap.get(firstKey) - myMap.get(lastKey)) /  (float)lastKey) ;

        bdc.setProjected((int) Math.ceil((float)myMap.get(lastKey)/(float)x)+lastKey);


        if(bdc.getProjected() <= bdc.getDeadLine()){

            bdc.setOnTime(true);
        }

        return bdc;

    }

    public int getDateDiffByDays(Date d1 , Date d2){
        long diff = d1.getTime() - d2.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

/*
    public BurnDownChartData getBurnDownChartData(){




        BurnDownChartData bdc = new BurnDownChartData();

        // TODO : change the Sprint id cause a set it manualy
        Sprint s = sprintRepository.findBySid(2);
        if(s != null){
             bdc.setSid(s.getSid());
             bdc.setStartDate(s.getStartDate());
             bdc.setEndDate(s.getEndDate());

            long diff = s.getEndDate().getTime() - s.getStartDate().getTime();
            bdc.setDeadLine((int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

        }


        List<Userstory> userStories = userStoryRepository.findAll();


        int[] bars = new int[bdc.getDeadLine()];

        //ArrayList<Date> bars = new ArrayList<Date>();

        for (Userstory us: userStories) {
            Date d = us.getCompletDate();
            bars.add(d);
        }

        bdc.setBars(bars);



        return bdc;


    }

    */




}
