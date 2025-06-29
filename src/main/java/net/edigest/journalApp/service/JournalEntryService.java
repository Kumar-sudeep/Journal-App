package net.edigest.journalApp.service;

import net.edigest.journalApp.entity.JournalEntry;
import net.edigest.journalApp.entity.User;
import net.edigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
@Autowired
private UserService userService;
@Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
    try{
        User user=userService.findByUserName(userName);
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        user.setUsername(null);
        userService.saveEntry(user);}
    catch (Exception e){
       System.out.println(e);
       throw new RuntimeException("An error occured while saving the entry",e);
    }
    }
    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }



    public  List<JournalEntry> getAll(){
        return  journalEntryRepository.findAll();

    }
    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id, String user_name){
        User user=userService.findByUserName(user_name);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }
}
