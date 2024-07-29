package com.fleet.management.exceptions;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(Long roleId) {
        super("Role with id " + roleId + " not found");
    }
}
