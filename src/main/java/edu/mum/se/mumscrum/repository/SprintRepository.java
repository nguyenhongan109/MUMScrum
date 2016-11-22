package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Repository("sprintRepository")
public interface SprintRepository extends JpaRepository<Sprint, Long> {
    List<Sprint> findByAssignedTo(int AssignedTo);
    List<Sprint> findByCreatedBy(int createdBy);
    Sprint findBySid(int sid);
    Sprint findByName(String name);
    @Transactional
    Long deleteBySid(int sid);
}
