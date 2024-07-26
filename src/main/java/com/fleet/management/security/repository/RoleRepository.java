package com.fleet.management.security.repository;

import com.fleet.management.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(
            value = "SELECT * FROM role WHERE id NOT IN (SELECT roleId FROM userRole WHERE userId = ?1)",
            nativeQuery = true
    )
    List<Role> getUserNotRoles(Long userId);
}
