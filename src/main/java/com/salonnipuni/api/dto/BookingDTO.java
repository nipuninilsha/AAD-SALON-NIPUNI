package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private String id;
    private long bookingNumber;
    private String clientId;
    private String clientName;
    private LocalDate date;
    private String time;
    private String status;
    private List<BookingItemDTO> salonServices;
    private double subtotal;
    private double tax;
    private double discount;
    private double total;
    private String paymentMethod;
}
