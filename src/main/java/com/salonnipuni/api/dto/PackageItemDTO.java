package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageItemDTO {
    private String salonServiceId;
    private String salonServiceName;
    private int qty;
}
