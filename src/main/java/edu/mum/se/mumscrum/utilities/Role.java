package edu.mum.se.mumscrum.utilities;

/**
 * Created by Min Gaung on 11/11/2016.
 */
public enum Role {

    ADMIN("HR Admin"),
    POWNER("Product Owner"),
    SCRUMASTER("Scrum Master"),
    DEVELOPER("Developer"),
    TESTER("Tester");

    private String desc;

    Role(String desc){
        this.desc=desc;
    }

    public String desc(){
        return desc;
    }
}
