package com.fleet.management.security.service;

import com.fleet.management.exceptions.RoleNotFoundException;
import com.fleet.management.exceptions.UserNotFoundException;
import com.fleet.management.security.entity.Role;
import com.fleet.management.security.entity.User;
import com.fleet.management.security.repository.RoleRepository;
import com.fleet.management.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    //get all roles
    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    //get role by id
    public Role findRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    //Update Role
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
    //delete by id
    public boolean deleteRole(Long id) {
       if (roleRepository.existsById(id)) {
           roleRepository.deleteById(id);
           return true;
       } else {
           return false;
       }
    }



    //assign role to user
    @Override
    public void assignRoleToUser(Long userId, Long roleId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new UserNotFoundException(userId));
        Role role = roleRepository.findById(roleId).
                orElseThrow(() -> new RoleNotFoundException(roleId));

        Set<Role> userRoles = user.getRoles();
        if(userRoles.contains(role)){
            return;
        }
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);

    }
    //Unassign Role to User
    public boolean unassignUserRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RoleNotFoundException(roleId));
        Set<Role> userRoles = user.getRoles();
        boolean roleRemoved = userRoles.remove(role);
        if (roleRemoved) {
            userRepository.save(user);
        }

        return roleRemoved;
    }
    @Override
    public Set<Role> getUserRoles(User user) {
        return user.getRoles();
    }

    @Override
    public Set<Role> getUserNotRoles(User user) {
        return roleRepository.getUserNotRoles(user.getId());
    }

}


