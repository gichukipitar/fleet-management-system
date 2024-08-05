package com.fleet.management.security.repository;

import com.fleet.management.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String userName);

    Optional<User> findUserByPhoneNumber(String phoneNumber);
}
