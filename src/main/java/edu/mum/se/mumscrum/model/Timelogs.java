package edu.mum.se.mumscrum.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Min Gaung on 14/11/2016.
 */
@Entity
@Table(name="timelogs")
public class Timelogs {
    private int tid;
    private Integer duration;
    private Date updatedDate;

    @Id
    @Column(name = "tid")
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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
