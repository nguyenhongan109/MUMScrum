package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Timelogs;

import java.sql.Date;
import java.util.List;

/**
 * Created by phandungmykieu on 11/16/16.
 */
public interface TimelogsService {

   Timelogs findByUidANDUpdatedDate(int uid, Date updatedDate);
   void saveTimeLog(Timelogs timelogs);
}
