package edu.mum.se.mumscrum.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Min Gaung on 22/11/2016.
 */
public class AssignUSDev {
    private int uid;
    private String Developer;
    private String name;
    private String description;
    public AssignUSDev(int uid,String Developer,String name,String description)
    {
        this.uid=uid;
        this.Developer=Developer;
        this.name=name;
        this.description=description;
    }
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    public String getDeveloper() {
        return Developer;
    }

    public void setDeveloper(String developer) {
        Developer = developer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
