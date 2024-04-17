package com.example.servicevirtualization.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "endpoints")
public class Endpoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "endpoint_name", nullable = false)
    private String name;

    @Column(name = "endpoint_url", nullable = false)
    private String url;

    @OneToMany(mappedBy = "endpoint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Rule> rules = new HashSet<>();

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Getters and Setters
}