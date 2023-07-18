package com.example.datarepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.objects.User;

@Repository
public class UserDataService {

	private final UserDataRepo userRepository;
	

    @Autowired
    public UserDataService(UserDataRepo userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

//    public List<User> getUsersByFirstName(String firstName) {
//        return userRepository.findByFirstName(firstName);
//    }

}
