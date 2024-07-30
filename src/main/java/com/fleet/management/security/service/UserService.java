package com.fleet.management.security.service;

import com.fleet.management.security.entity.User;
import com.fleet.management.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {


    //find all users
    public List<User> findAllUsers();
    //find user by id
    public User findUserById(Long id);
    //delete user
    public void deleteUser(Long id);
    //update user
    public void saveUser(User user);

}
