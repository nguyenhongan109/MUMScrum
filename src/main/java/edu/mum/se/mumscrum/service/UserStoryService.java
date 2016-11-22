package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.AssignUSDev;
import edu.mum.se.mumscrum.model.Userstory;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
public interface UserStoryService {
    List<Userstory> getAllUserStory();
    Userstory findByName(String name);
    boolean checkByName(String name);
    Userstory findByID(int id);
    List<Userstory> findBySid(int sid);
    List<Userstory> findBySidIsNull();
    void save(Userstory userstory);
    void delete(int id);
}
