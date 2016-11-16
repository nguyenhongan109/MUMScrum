package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.ReleaseBackLog;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
public interface ReleaseService {
    public List<ReleaseBackLog> findAll();
    public ReleaseBackLog findByRID(int id);
    public List<ReleaseBackLog> findByPID(int id);
}
