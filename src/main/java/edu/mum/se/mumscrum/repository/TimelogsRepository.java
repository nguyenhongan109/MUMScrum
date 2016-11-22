package edu.mum.se.mumscrum.repository;

import edu.mum.se.mumscrum.model.Timelogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by phandungmykieu on 11/16/16.
 */
@Repository("timelogsRepository")
public interface TimelogsRepository extends JpaRepository<Timelogs, Long> {

    Timelogs findByUidAndUpdatedDate(int id, Date date);

}
