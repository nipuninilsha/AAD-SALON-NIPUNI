package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncomeReportLineDTO {
    private String date;
    private String bookingId;
    private String clientName;
    private String paymentMethod;
    private double amount;
    private String type;
}
