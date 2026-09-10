package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StylistPerformanceDTO {
    private String username;
    private int bookingCount;
    private double totalSales;
    private double avgBookingValue;
}
