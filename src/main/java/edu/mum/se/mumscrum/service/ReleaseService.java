package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Userstory;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
public interface SprintService {
    List<Userstory> getAllUserStory();
    Userstory findByName(String name);
    boolean checkByName(String name);
    Userstory findByID(int id);
    void save(Userstory userstory);
    void delete(int id);
}
