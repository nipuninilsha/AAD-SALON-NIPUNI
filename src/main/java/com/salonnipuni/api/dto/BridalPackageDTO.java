package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridalPackageDTO {
    private String id;
    private String name;
    private double price;
    private String tier;
    private String description;
    private String image;
    private List<PackageItemDTO> salonServices;
}
