package com.example.demo.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserTableRepository
     extends JpaRepository<UserTable, Long> {

    Optional<UserTable> findUserByUsername(String username);
    Optional<UserTable> findUserByPassword(String password);
}
