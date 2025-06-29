package net.edigest.journalApp.service;


import net.edigest.journalApp.entity.JournalEntry;
import net.edigest.journalApp.entity.User;
import net.edigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
@Autowired
    private UserRepository userRepository;
public void saveEntry(User user){
    userRepository.save(user);

}
    public List<User> getAll(){
        return userRepository.findAll();

    }
    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }
    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }
    public User findByUserName(String username){
    return  userRepository.findByUsername(username);
    }


}
