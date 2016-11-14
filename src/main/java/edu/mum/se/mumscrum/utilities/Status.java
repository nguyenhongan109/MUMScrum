package edu.mum.se.mumscrum.utilities;

/**
 * Created by tony on 11/14/16.
 */
public enum Status {
    NEW("New"),
    INPROGRESS("In Progress");


    private String desc;
    Status(String desc){
        this.desc = desc;
    }
    public String desc(){
        return desc;
    }
}
