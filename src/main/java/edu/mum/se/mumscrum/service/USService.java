package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Userstory;

import java.util.List;
/**
 * Created by phandungmykieu on 11/13/16.
 */

public interface USService {
    List<Userstory> getAllUS();
    void save(Userstory userstory);
    Userstory retrieveUS(int id);
}
