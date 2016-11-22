package edu.mum.se.mumscrum.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by Min Gaung on 14/11/2016.
 */
@Entity
@Table(name="timelogs")
public class Timelogs {
    private int tid;
    private int uid;
    private int sid;
    private Integer duration;
    private int todayEffort;
    private Date updatedDate;

    public Timelogs(){}
    public Timelogs(int uid, Integer duration){
        this.uid = uid;
        this.duration = duration;
    }

    @Id
    @Column(name = "tid")
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    @Basic
    @Column(name = "sid")
    public Integer Sid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    @Basic
    @Column(name = "todayEffort")
    public int getTodayEffort() { return todayEffort;}

    public void setTodayEffort(int todayEffort) {
        this.todayEffort = todayEffort;
    }
    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "updatedDate")
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Timelogs timelogs = (Timelogs) o;

        if (tid != timelogs.tid) return false;
        if (duration != null ? !duration.equals(timelogs.duration) : timelogs.duration != null) return false;
        if (updatedDate != null ? !updatedDate.equals(timelogs.updatedDate) : timelogs.updatedDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (updatedDate != null ? updatedDate.hashCode() : 0);
        return result;
    }
}


