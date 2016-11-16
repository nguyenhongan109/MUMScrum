package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.ProductBackLog;
import edu.mum.se.mumscrum.repository.ProductBackLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 11/14/16.
 */
@Service("productBackLogService")
public class ProductBackLogServiceImpl implements ProductBackLogService {
    @Autowired
    private ProductBackLogRepository productBackLogRepository;

    @Override
    public boolean findByName(String name) {
        if (productBackLogRepository.findByName(name) != null)
            return true;
        return false;
    }

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
