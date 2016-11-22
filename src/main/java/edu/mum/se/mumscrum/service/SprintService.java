package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Sprint;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
public interface SprintService {
    List<Sprint> getAllSprint();
    List<Sprint> findByAssignedTo(int AssignedTo);
    Sprint findBySid(int sid);
    List<Sprint> findByCreatedBy(int createdBy);
    boolean checkByName(String name);
    void save(Sprint sprint);
    void delete(int id);
}
