package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.ReleaseBackLog;
import edu.mum.se.mumscrum.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Service("releaseService")
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    private ReleaseRepository releaseRepository;

    public List<ReleaseBackLog> findAll(){
        return  releaseRepository.findAll();
    }
    @Override
    public ReleaseBackLog findByRID(int id) {
        return releaseRepository.findByRid(id);
    }
    @Override
    public List<ReleaseBackLog> findByPID(int id) {
        return releaseRepository.getbyProdid(id);
    }

}
