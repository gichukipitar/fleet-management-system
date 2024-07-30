package com.fleet.management.security.controller;

import com.fleet.management.security.entity.Role;
import com.fleet.management.security.entity.User;
import com.fleet.management.security.service.RoleService;
import com.fleet.management.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/security")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public ResponseEntity <List<User>> getAllUsers() {
        List <User> users = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    @GetMapping("/security/user/{op}/{id}")
    public ResponseEntity<List> editUser(@PathVariable Long id, @PathVariable String op) {
        User user = userService.findUserById(id);
        Set<Role> userRoles = roleService.getUserRoles(user);
        Set<Role> userNotRoles = roleService.getUserNotRoles(user);

        return null;
    }
}
