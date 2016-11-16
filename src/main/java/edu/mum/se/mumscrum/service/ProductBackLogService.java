package edu.mum.se.mumscrum.service;
import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.ProductBackLog;

import java.util.List;

/**
<<<<<<< HEAD
 * Created by Min Gaung on 11/11/2016.
 */
public interface ProductBackLogService {
    ProductBackLog findByPid(int pid);
    boolean findByName(String name);
    List<ProductBackLog> getAllProductBackLog();
    void save(ProductBackLog productBackLog);
    void deleteByPid(int pid);
}
