package com.salonnipuni.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceBookingRequestDTO {
    @NotBlank(message = "Client is required")
    private String clientId;

    @NotEmpty(message = "At least one service or package must be added to the booking")
    @Valid
    private List<BookingItemRequestDTO> salonServices;

    private Double discount;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;
}
