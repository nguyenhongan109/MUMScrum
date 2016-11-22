package edu.mum.se.mumscrum.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Min Gaung on 22/11/2016.
 */
@Entity
@Table(name="userstory")
public class Userstory {
    private int uid;
    private Integer sid;
    private int pid;
    private int rid;
    private Integer eid;
    private String name;
    private String description;
    private Integer estimatedEffort;
    private Integer actualEffort;
    private Date completDate;
    private String status;
    private Date assignedDate;

    public Userstory()
    {
        completDate=new Date(0,0,0);
        assignedDate=new Date(0,0,0);
    }
    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "sid")
    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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
    @Column(name = "eid")
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
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
    @Column(name = "estimatedEffort")
    public Integer getEstimatedEffort() {
        return estimatedEffort;
    }

    public void setEstimatedEffort(Integer estimatedEffort) {
        this.estimatedEffort = estimatedEffort;
    }

    @Basic
    @Column(name = "actualEffort")
    public Integer getActualEffort() {
        return actualEffort;
    }

    public void setActualEffort(Integer actualEffort) {
        this.actualEffort = actualEffort;
    }

    @Basic
    @Column(name = "completDate")
    public Date getCompletDate() {
        return completDate;
    }

    public void setCompletDate(Date completDate) {
        this.completDate = completDate;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public Date ComDate()
    {
        Date st=new Date(0,0,0);
        if(getCompletDate().equals(st)) return null;
        else return getCompletDate();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userstory userstory = (Userstory) o;

        if (uid != userstory.uid) return false;
        if (pid != userstory.pid) return false;
        if (rid != userstory.rid) return false;
        if (sid != null ? !sid.equals(userstory.sid) : userstory.sid != null) return false;
        if (eid != null ? !eid.equals(userstory.eid) : userstory.eid != null) return false;
        if (name != null ? !name.equals(userstory.name) : userstory.name != null) return false;
        if (description != null ? !description.equals(userstory.description) : userstory.description != null)
            return false;
        if (estimatedEffort != null ? !estimatedEffort.equals(userstory.estimatedEffort) : userstory.estimatedEffort != null)
            return false;
        if (actualEffort != null ? !actualEffort.equals(userstory.actualEffort) : userstory.actualEffort != null)
            return false;
        if (completDate != null ? !completDate.equals(userstory.completDate) : userstory.completDate != null)
            return false;
        if (status != null ? !status.equals(userstory.status) : userstory.status != null) return false;
        if (assignedDate != null ? !assignedDate.equals(userstory.assignedDate) : userstory.assignedDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + pid;
        result = 31 * result + rid;
        result = 31 * result + (eid != null ? eid.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (estimatedEffort != null ? estimatedEffort.hashCode() : 0);
        result = 31 * result + (actualEffort != null ? actualEffort.hashCode() : 0);
        result = 31 * result + (completDate != null ? completDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (assignedDate != null ? assignedDate.hashCode() : 0);
        return result;
    }
}
