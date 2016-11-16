package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.ProductBackLog;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
public interface ProductBackLogService {

    List<ProductBackLog> getAllProductBackLogs();
}
