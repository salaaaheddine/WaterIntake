package com.waterIntake.entities;

import java.util.List;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    // other user-related fields

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WaterIntake> waterIntakes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<WaterIntake> getWaterIntakes() {
        return waterIntakes;
    }

    public void setWaterIntakes(List<WaterIntake> waterIntakes) {
        this.waterIntakes = waterIntakes;
    }
}
