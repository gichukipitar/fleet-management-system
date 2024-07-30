package com.fleet.management.security.service;

import com.fleet.management.security.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();
    Role findRoleById(Long roleName);
    Role saveRole(Role role);

    //assign role to user
    void assignRoleToUser(Long userId, Long roleId);
    //unassign role to user
    boolean unassignUserRole(Long userId, Long roleId);

    boolean deleteRole(Long id);
}
