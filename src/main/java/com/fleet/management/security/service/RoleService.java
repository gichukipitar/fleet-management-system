package com.fleet.management.security.service;

import com.fleet.management.security.entity.Role;
import com.fleet.management.security.entity.User;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> findAllRoles();
    Role findRoleById(Long roleName);
    Role saveRole(Role role);

    //assign role to user
    void assignRoleToUser(Long userId, Long roleId);
    //unassign role to user
    boolean unassignUserRole(Long userId, Long roleId);

    boolean deleteRole(Long id);
    Set<Role> getUserRoles(User user);
    List<Role> getUserNotRoles(User user);
}
