package com.salonnipuni.api.entity;

import com.salonnipuni.api.enumeration.RecordStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stylist")
public class Stylist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String contact;

    private String address;

    private String email;

    private String specialty;

    @jakarta.persistence.Column(length = 1000)
    private String bio;

    @jakarta.persistence.Column(length = 1000)
    private String photo;

    private String assignedServiceCategories;

    @Enumerated(EnumType.STRING)
    private RecordStatus status = RecordStatus.ACTIVE;
}
