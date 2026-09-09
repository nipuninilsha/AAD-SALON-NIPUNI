package com.salonnipuni.api.entity;

import com.salonnipuni.api.enumeration.PackageTier;
import com.salonnipuni.api.enumeration.RecordStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bridal_package")
public class BridalPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private double price;

    @Enumerated(EnumType.STRING)
    private PackageTier tier;


    @Column(length = 2000)
    private String description;

    private String image;

    @Enumerated(EnumType.STRING)
    private RecordStatus status = RecordStatus.ACTIVE;

    @OneToMany(mappedBy = "bridalPackage", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PackageItem> salonServices = new ArrayList<>();
}
