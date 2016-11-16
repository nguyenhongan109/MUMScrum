package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.ReleaseBackLog;

import java.util.List;

/**
 * Created by tony on 11/14/16.
 */
public interface ReleaseBackLogService {
    List<ReleaseBackLog> getAllReleaseBackLog(int pid);
    ReleaseBackLog findByRid(int rid);
    boolean findByName(int pid, String releaseName);
    void save(ReleaseBackLog releaseBackLog);
    void deleteByRid(int rid);
}
