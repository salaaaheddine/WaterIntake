package com.waterIntake.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waterIntake.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}

