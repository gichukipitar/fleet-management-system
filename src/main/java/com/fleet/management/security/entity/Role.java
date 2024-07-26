package com.fleet.management.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role extends Auditable <String> {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String description;
    private String details;
}
