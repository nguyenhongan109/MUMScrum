package edu.mum.se.mumscrum.model;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Created by mehdi on 11/20/16.
 */


public class BurnDownData {



    private Date updatedDate;
    private Double duration;


    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Date getUpdatedDate() {

        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "BurnDownData{" +
                "updatedDate=" + updatedDate +
                ", duration=" + duration +
                '}';
    }
}
