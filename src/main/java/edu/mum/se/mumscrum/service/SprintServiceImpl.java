package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Sprint;
import edu.mum.se.mumscrum.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Service("sprintService")
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Override
    public List<Sprint> getAllSprint()
    {
        return sprintRepository.findAll();
    }
    @Override
    public List<Sprint> findByAssignedTo(int AssignedTo)
    {
        return sprintRepository.findByAssignedTo(AssignedTo);
    }
    @Override
    public Sprint findBySid(int sid)
    {
        return sprintRepository.findBySid(sid);
    }
    @Override
    public List<Sprint> findByCreatedBy(int createdBy)
    {
        return sprintRepository.findByCreatedBy(createdBy);
    }

    @Override
    public boolean checkByName(String name) {
        Sprint sprint=  sprintRepository.findByName(name);
        if(sprint !=null)
            return true;
        return false;
    }

    @Override
    public void save(Sprint sprint) {
        sprintRepository.save(sprint);
    }

    @Override
    public void delete(int id) {
        sprintRepository.deleteBySid(id);
    }
}
