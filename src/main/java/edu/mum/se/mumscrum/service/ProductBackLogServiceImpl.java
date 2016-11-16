package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.Employee;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.repository.EmployeeRepository;
import edu.mum.se.mumscrum.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Service("userStoryService")
public class UserSToryServiceImpl implements UserStoryService {

    @Autowired
    private UserStoryRepository userStoryRepository;

    @Override
    public List<Userstory> getAllUserStory()
    {
        return userStoryRepository.findAll();
    }
    @Override
    public Userstory findByName(String name) {
        return userStoryRepository.findByName(name);
    }
    @Override
    public Userstory findByID(int id) {
        return userStoryRepository.findByUid(id);
    }
    public boolean checkByName(String name) {
        Userstory userstory=  userStoryRepository.findByName(name);
        if(userstory !=null)
            return true;
        return false;
    }
    public void save(Userstory userstory) {
        userStoryRepository.save(userstory);
    }

    public void delete(int id)
    {
        userStoryRepository.deleteByUid(id);
    }
}
