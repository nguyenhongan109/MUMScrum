package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.Timelogs;
import edu.mum.se.mumscrum.model.Userstory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;
import java.util.Date;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Repository("userStoryRepository")
public interface UserStoryRepository extends JpaRepository<Userstory, Long> {
    Userstory findByName(String name);
    Userstory findByUid(int uid);
    List<Userstory> findByEid(int eid);
    @Transactional
    Long deleteByUid(int uid);

}
