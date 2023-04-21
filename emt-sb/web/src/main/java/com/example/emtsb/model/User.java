package com.example.emtsb.model;

import com.example.emtsb.model.ENUM.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="table_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String password;
    @Enumerated(EnumType.STRING)
    Role role;

}
