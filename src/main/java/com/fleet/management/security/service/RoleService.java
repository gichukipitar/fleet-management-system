package com.fleet.management.security.service;

import com.fleet.management.security.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRoles();
    Role findRoleById(Long roleName);
    Role saveRole(Role role);
}
