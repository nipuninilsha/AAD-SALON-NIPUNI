package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseReportLineDTO {
    private String date;
    private String category;
    private String description;
    private double amount;
    private String source;
}
