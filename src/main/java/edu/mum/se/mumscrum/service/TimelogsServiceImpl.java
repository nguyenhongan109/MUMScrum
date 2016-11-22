package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Timelogs;
import edu.mum.se.mumscrum.repository.TimelogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


/**
 * Created by phandungmykieu on 11/16/16.
 */
@Service("timelogsService")
public class TimelogsServiceImpl implements TimelogsService {

    @Autowired
    private TimelogsRepository timelogsRepository;

    @Override
    public Timelogs findByUidANDUpdatedDate(int uid, Date updatedDate) {
        return timelogsRepository.findByUidAndUpdatedDate(uid, updatedDate);
    }

    @Override
    public void saveTimeLog(Timelogs timelogs) {timelogsRepository.save(timelogs);}

}
