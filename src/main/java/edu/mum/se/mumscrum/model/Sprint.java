package edu.mum.se.mumscrum.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Min Gaung on 14/11/2016.
 */
@Entity
public class Sprint {
    private int sid;
    private int uid;
    private int rid;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Byte status;
    private Date assignedDate;
    private int assignedTo;

    @Id
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "startDate")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "endDate")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "assignedDate")
    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Basic
    @Column(name = "assignedTo")
    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sprint sprint = (Sprint) o;

        if (sid != sprint.sid) return false;
        if (uid != sprint.uid) return false;
        if (rid != sprint.rid) return false;
        if (assignedTo != sprint.assignedTo) return false;
        if (name != null ? !name.equals(sprint.name) : sprint.name != null) return false;
        if (description != null ? !description.equals(sprint.description) : sprint.description != null) return false;
        if (startDate != null ? !startDate.equals(sprint.startDate) : sprint.startDate != null) return false;
        if (endDate != null ? !endDate.equals(sprint.endDate) : sprint.endDate != null) return false;
        if (status != null ? !status.equals(sprint.status) : sprint.status != null) return false;
        if (assignedDate != null ? !assignedDate.equals(sprint.assignedDate) : sprint.assignedDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + uid;
        result = 31 * result + rid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (assignedDate != null ? assignedDate.hashCode() : 0);
        result = 31 * result + assignedTo;
        return result;
    }
}
