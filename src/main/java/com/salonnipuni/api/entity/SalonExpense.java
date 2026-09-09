package com.salonnipuni.api.entity;

import com.salonnipuni.api.enumeration.RecordStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
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
@Table(name = "salon_expense")
public class SalonExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String category;

    private String description;

    private double amount;

    private LocalDate date;

    private String addedBy;

    @Enumerated(EnumType.STRING)
    private RecordStatus status = RecordStatus.ACTIVE;
}
