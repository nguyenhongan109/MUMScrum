package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.Userstory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Repository("sprintRepository")
public interface SprintRepository extends JpaRepository<Userstory, Long> {
    Userstory findByName(String name);
    Userstory findByUid(int uid);
    @Transactional
    Long deleteByUid(int uid);
}
