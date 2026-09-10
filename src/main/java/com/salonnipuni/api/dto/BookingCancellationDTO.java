package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingCancellationDTO {
    private String id;
    private String bookingId;
    private String clientId;
    private String reason;
    private LocalDate date;
    private List<CancellationItemDTO> salonServices;
    private double totalRefund;
}
