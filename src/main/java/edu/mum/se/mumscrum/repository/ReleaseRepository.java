package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.ReleaseBackLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Repository("releaseRepository")
public interface ReleaseRepository extends JpaRepository<ReleaseBackLog, Long> {

    ReleaseBackLog findByRid(int rid);
    @Query("select r from ReleaseBackLog r where r.pid = :pid")
    List<ReleaseBackLog> getbyProdid(@Param("pid") int pid);
}
