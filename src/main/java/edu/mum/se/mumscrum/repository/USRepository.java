package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.Userstory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by phandungmykieu on 11/13/16.
 */
@Repository("usRepository")
public interface USRepository extends JpaRepository<Userstory, Long>{

    Userstory findByUid(int id);
}
