package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.AssignUSDev;
import edu.mum.se.mumscrum.model.Userstory;
import jdk.nashorn.internal.objects.annotations.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.SqlResultSetMapping;
import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Repository("userStoryRepository")
public interface UserStoryRepository extends JpaRepository<Userstory, Long> {
    Userstory findByName(String name);
    Userstory findByUid(int uid);
    List<Userstory> findBySid(int sid);
    List<Userstory> findBySidIsNull();
    @Transactional
    Long deleteByUid(int uid);
}
