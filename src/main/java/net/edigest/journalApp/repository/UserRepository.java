package net.edigest.journalApp.repository;

import net.edigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
// UserRepository.java
public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);
}
