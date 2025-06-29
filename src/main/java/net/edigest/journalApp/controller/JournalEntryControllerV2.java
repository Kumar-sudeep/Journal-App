package net.edigest.journalApp.controller;

import net.edigest.journalApp.entity.JournalEntry;
import net.edigest.journalApp.entity.User;
import net.edigest.journalApp.service.JournalEntryService;
import net.edigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;
  @Autowired
  private UserService userService;
    @GetMapping  //http://localhost:9090/journal GET
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String user_name){
      User user= userService.findByUserName(user_name);
      List<JournalEntry> all= user.getJournalEntries();
      if(all!=null&&!all.isEmpty()){
return new ResponseEntity<>(all,HttpStatus.OK);
      }
      return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{user_name}")  //http://localhost:9090/journal POST
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry,@PathVariable String user_name){
       try {

           journalEntryService.saveEntry(myEntry,user_name);
           return  new ResponseEntity<>(myEntry,HttpStatus.CREATED);

       } catch (Exception e) {
       return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

    }
    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
        if(journalEntry.isPresent()){
            return  new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
        }
        return   new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("id/{user_name}/{myId}")
    public ResponseEntity<?> DeleteEntryById(@PathVariable ObjectId myId,@PathVariable String user_name){
      journalEntryService.deleteById(myId,user_name);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping ("id/{user_name}/{id}")
    public ResponseEntity<JournalEntry> UpdateJournalById(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry,@PathVariable String user_name){

       JournalEntry old= journalEntryService.findById(id).orElse(null);
       if(old!=null){

        old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle(): old.getTitle());
        old.setContent(newEntry.getContent()!=null && !newEntry.equals("")? newEntry.getContent() : old.getContent());
           journalEntryService.saveEntry(old);
           return new ResponseEntity<>(old,HttpStatus.OK);
       }
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
