package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLogDTO {
    private Long id;
    private String username;
    private String action;
    private String details;
    private String timestamp;
}
