package edu.mum.se.mumscrum.service;

import org.springframework.stereotype.Service;
import edu.mum.se.mumscrum.model.Timelogs;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.repository.TimelogsRepository;
import edu.mum.se.mumscrum.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Service("userStoryService")
public class UserStoryServiceImpl implements UserStoryService {
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
    @Override
    public List<Userstory> findBySid(int sid){
        return userStoryRepository.findBySid(sid);
    }
    @Override
    public List<Userstory> findBySidIsNull()
    {
        return userStoryRepository.findBySidIsNull();
    }

    public void save(Userstory userstory) {
        userStoryRepository.save(userstory);
    }

    public void delete(int id)
    {
        userStoryRepository.deleteByUid(id);
    }

    @Override
    public List<Userstory> findByEmployee(int eid) { return userStoryRepository.findByEid(eid); }



}
