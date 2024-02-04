package com.waterIntake.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waterIntake.entities.Users;
import com.waterIntake.entities.WaterIntake;

public interface WaterIntakeRepository  extends JpaRepository<WaterIntake, Long> {
    List<WaterIntake> findByUserOrderByDateDesc(Users user);
}
