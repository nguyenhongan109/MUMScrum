package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.ProductBackLog;

import java.util.List;

/**
 * Created by tony on 11/14/16.
 */
public interface ProductBackLogService {
    ProductBackLog findByPid(int pid);
    List<ProductBackLog> getAllProductBackLog();
    void save(ProductBackLog productBackLog);
    void deleteByPid(int pid);
}
