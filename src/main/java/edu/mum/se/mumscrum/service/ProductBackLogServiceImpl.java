package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.ProductBackLog;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.repository.ProductBackLogRepository;
import edu.mum.se.mumscrum.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Service("productBackLogService")
public class ProductBackLogServiceImpl implements ProductBackLogService {

    @Autowired
    private ProductBackLogRepository productBackLogRepository;

    @Override
    public List<ProductBackLog> getAllProductBackLogs()
    {
        return productBackLogRepository.findAll();
    }

}
