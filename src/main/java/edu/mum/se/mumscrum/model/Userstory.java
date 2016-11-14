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
public class Userstory {
    private int uid;
    private String name;
    private String description;
    private Integer estimatedEffort;
    private Integer actualEffort;
    private Date completDate;
    private String status;
    private Date assignedDate;

    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userstory userstory = (Userstory) o;

        if (uid != userstory.uid) return false;
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
