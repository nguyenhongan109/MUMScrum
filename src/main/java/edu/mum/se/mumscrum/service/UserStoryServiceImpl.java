package edu.mum.se.mumscrum.service;

import edu.mum.se.mumscrum.model.AssignUSDev;
import edu.mum.se.mumscrum.model.Userstory;
import edu.mum.se.mumscrum.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Min Gaung on 11/11/2016.
 */
@Service("userStoryService")
public class UserStoryServiceImpl implements UserStoryService {
    @PersistenceContext
    private EntityManager em;
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
}
