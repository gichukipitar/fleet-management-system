package com.fleet.management.security.controller;

import com.fleet.management.security.dtos.UserEditResponse;
import com.fleet.management.security.entity.Role;
import com.fleet.management.security.entity.User;
import com.fleet.management.security.service.RoleService;
import com.fleet.management.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserEditResponse> editUser(@PathVariable Long id, @PathVariable String op) {
        User user = userService.findUserById(id);
        Set<Role> userRoles = roleService.getUserRoles(user);
        Set<Role> userNotRoles = roleService.getUserNotRoles(user);
        UserEditResponse userEditResponse = new UserEditResponse(user, userRoles, userNotRoles);
        return ResponseEntity.status(HttpStatus.OK).body(userEditResponse);
    }
    @PostMapping ("/users/addNew")
    public ResponseEntity<User> addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
