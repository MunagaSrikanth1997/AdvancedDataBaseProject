package com.example.datarepo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.objects.User;

@Repository
public interface UserDataRepo extends MongoRepository<User, String> {

    // Custom query method
    //List<User> findByFirstName(String firstName);
}
