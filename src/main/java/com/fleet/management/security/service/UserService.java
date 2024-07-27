package com.fleet.management.security.service;

import com.fleet.management.security.entity.User;
import com.fleet.management.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    //find all users
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    //find user by id
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    //delete user
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    //update user
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
