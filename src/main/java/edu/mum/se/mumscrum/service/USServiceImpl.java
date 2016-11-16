package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.repository.USRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by phandungmykieu on 11/13/16.
 */
@Service("usService")
public class USServiceImpl implements USService {

    @Autowired
    USRepository usRepository;

    public List<Userstory> getAllUS(){
        return usRepository.findAll();
    }

    @Override
    public void save(Userstory userstory) {
        usRepository.save(userstory);
    }

    @Override
    public Userstory retrieveUS(int id) {
      return   usRepository.findByUid(id);
    }


}
