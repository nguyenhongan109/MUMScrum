package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.BurnDownChartData;
import edu.mum.se.mumscrum.model.BurnDownData;
import edu.mum.se.mumscrum.model.Timelogs;

import java.util.List;

/**
 * Created by mehdi on 11/17/16.
 */
public interface BurnDownChartService {


    public  BurnDownChartData getBurnDownData(int sid);
    //public BurnDownChartData getBurnDownChartData();

}
