package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.Userstory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Repository("userStoryRepository")
public interface UserStoryRepository extends JpaRepository<Userstory, Long> {
    Userstory findByName(String name);
    Userstory findByUid(int uid);
    @Transactional
    Long deleteByUid(int uid);
}
