package edu.mum.se.mumscrum.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Min Gaung on 14/11/2016.
 */
@Entity
@Table(name="releaseBackLog")
public class ReleaseBackLog {
    private int rid;
    private int uid;
    private int pid;
    private String name;
    private String description;
    private Date releaseDate;
    private Set<ProductBackLog> productBackLogs = new HashSet<ProductBackLog>(0);



    @Id
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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
    @Column(name = "releaseDate")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="pid")
    public Set<ProductBackLog> getProductBackLogs() {
        return productBackLogs;
    }

    public void setProductBackLogs(Set<ProductBackLog> productBackLogs) {
        this.productBackLogs = productBackLogs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReleaseBackLog release = (ReleaseBackLog) o;

        if (rid != release.rid) return false;
        if (uid != release.uid) return false;
        if (pid != release.pid) return false;
        if (name != null ? !name.equals(release.name) : release.name != null) return false;
        if (description != null ? !description.equals(release.description) : release.description != null) return false;
        if (releaseDate != null ? !releaseDate.equals(release.releaseDate) : release.releaseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + uid;
        result = 31 * result + pid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }
}
