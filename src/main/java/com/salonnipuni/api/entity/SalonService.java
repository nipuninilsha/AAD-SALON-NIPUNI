package com.salonnipuni.api.entity;

import com.salonnipuni.api.enumeration.RecordStatus;
import com.salonnipuni.api.enumeration.ServiceCategory;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Entity;
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
@Table(name = "salon_service")
public class SalonService {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String code;

    private String name;

    @Enumerated(EnumType.STRING)
    private ServiceCategory category;

    private double price;

    private int durationMinutes;

    @Column(length = 2000)
    private String description;

    private boolean isFeatured;

    @Column(length = 1000)
    private String image;

    @Enumerated(EnumType.STRING)
    private RecordStatus status = RecordStatus.ACTIVE;
}
