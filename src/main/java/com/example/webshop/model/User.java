package com.example.webshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true, nullable = false)
        private String username;

        private String password;
        private String email;

        // Számlázási adatok
        private String billingAddress;

        // Szállítási adatok
        private String shippingAddress;


    }
