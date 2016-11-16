package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.ReleaseBackLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tony on 11/14/16.
 */
@Repository("releaseBackLogRepository")
public interface ReleaseBackLogRepository extends JpaRepository<ReleaseBackLog, Long>{
    List<ReleaseBackLog> findByPid(int pid);
    ReleaseBackLog findByRid(int rid);
    ReleaseBackLog findByPidAndName(int pid, String name);

    @Transactional
    void deleteByRid(int rid);
}
