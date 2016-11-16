package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.ReleaseBackLog;
import edu.mum.se.mumscrum.repository.ReleaseBackLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 11/14/16.
 */
@Service("releaseBackLogService")
public class ReleaseBackLogServiceImpl implements ReleaseBackLogService{

    @Autowired
    private ReleaseBackLogRepository releaseBackLogRepository;

    @Override
    public List<ReleaseBackLog> getAllReleaseBackLog(int pid) {
        return releaseBackLogRepository.findByPid(pid);
    }

    @Override
    public boolean findByName(int pid, String releaseName) {
        return releaseBackLogRepository.findByPidAndName(pid, releaseName) == null ? false : true;
    }

    @Override
    public void save(ReleaseBackLog releaseBackLog) {
        releaseBackLogRepository.save(releaseBackLog);
    }

    @Override
    public void deleteByRid(int rid) {
        releaseBackLogRepository.deleteByRid(rid);
    }

    @Override
    public ReleaseBackLog findByRid(int rid) {
        return releaseBackLogRepository.findByRid(rid);
    }
}
