package com.example.demo.domain.user;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data // Getters, Setters, Equals, HashCode, Constructor for all fields
@NoArgsConstructor // Default constructor
@Entity // declare as Entity
@Table(name = "users") // write table name "users"
public class User {

    @Id // mark this field as id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generation of id
    private Long id;

    private String name;
}
