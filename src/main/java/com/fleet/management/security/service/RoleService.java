package com.fleet.management.security.service;

import com.fleet.management.security.entity.Role;
import com.fleet.management.security.entity.User;
import com.fleet.management.security.repository.RoleRepository;
import com.fleet.management.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    //get all roles
    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }
    //get role by id
    public Role findRoleById(Long id){
        return roleRepository.findById(id).orElse(null);
    }
    //assign role to user
    public void assignRoleToUser(Long userId, Long roleId){
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);
        assert user != null;
        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);
    }
    public Set<Role> getUserRoles(User user){
        return user.getRoles();
    }
    public List<Role> getUserNotRoles(User user){
        return roleRepository.getUserNotRoles(user.getId());
    }
}
