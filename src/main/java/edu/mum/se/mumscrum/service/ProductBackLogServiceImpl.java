package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.ProductBackLog;
import edu.mum.se.mumscrum.repository.ProductBackLogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by tony on 11/14/16.
 */
public class ProductBackLogServiceImpl implements ProductBackLogService {
    @Autowired
    private ProductBackLogRepository productBackLogRepository;

    @Override
    public ProductBackLog findByPid(int pid) {
        return productBackLogRepository.findByPid(pid);
    }

    @Override
    public List<ProductBackLog> getAllProductBackLog() {
        return productBackLogRepository.findAll();
    }

    @Override
    public void save(ProductBackLog productBackLog) {
        productBackLogRepository.save(productBackLog);
    }

    @Override
    public void deleteByPid(int pid) {
        productBackLogRepository.deleteByPid(pid);
    }
}
