package edu.mum.se.mumscrum.model;

import org.hibernate.ejb.criteria.expression.function.AggregationFunction;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mehdi on 11/17/16.
 */
public class BurnDownChartData {
    private long Sid ;

    public int getProjected() {
        return projected;
    }

    public void setProjected(int projected) {
        this.projected = projected;
    }

    private Date startDate;
    private Date endDate;
    private int projected = -1; // the date when the sprint will finish using the velocity
    //private HashMap <Integer,Integer> bars ;
    //private ArrayList <Integer> bars ;



    private int deadLine = -1; // day number
    private boolean onTime = false;

    public int getDeadLine() {
        return deadLine;
    }

    public boolean isOnTime() {
        return onTime;
    }

    public void setOnTime(boolean onTime) {
        this.onTime = onTime;
    }

    public void setDeadLine(int deadLine) {
        this.deadLine = deadLine;
    }

    private HashMap<Integer,Integer> bars;


    private int firstKey = -1;
    private int lastKey = -1;


    public int getFirstKey() {
        return firstKey;
    }

    public void setFirstKey(int firstKey) {
        this.firstKey = firstKey;
    }

    public int getLastKey() {
        return lastKey;
    }

    public void setLastKey(int lastKey) {
        this.lastKey = lastKey;
    }



    public Date getEndDate() {

        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }


    public long getSid() {
        return Sid;
    }

    public void setSid(long sid) {
        Sid = sid;
    }

    public BurnDownChartData(){
    }

    public HashMap<Integer, Integer>  getBars() {
        return bars;
    }

    public void setBars(HashMap<Integer,Integer> bars) {
        this.bars = bars;
    }
}
