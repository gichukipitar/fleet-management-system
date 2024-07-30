package com.fleet.management.security.dtos;

import com.fleet.management.security.entity.Role;
import com.fleet.management.security.entity.User;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserEditResponse {
    private User user;
    private Set<Role> userRoles;
    private Set<Role> userNotRoles;
    public UserEditResponse(User user, Set<Role> userRoles, Set<Role> userNotRoles) {
        this.user = user;
        this.userRoles = userRoles;
        this.userNotRoles = userNotRoles;
    }
}
