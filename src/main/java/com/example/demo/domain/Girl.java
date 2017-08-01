package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author E.Kobets <e.kobets@talantarium.com>
 */
@Data // Getters, Setters, Equals, HashCode, Constructor for all fields
@NoArgsConstructor // Default constructor
@Entity // declare as Entity
public class Girl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
}


