package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CancellationItemDTO {
    private String salonServiceId;
    private String name;
    private int qty;
    private double price;
}
