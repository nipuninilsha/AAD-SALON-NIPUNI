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
public class CreateBookingCancellationRequestDTO {
    @NotBlank(message = "Booking is required")
    private String bookingId;

    @NotBlank(message = "Reason is required")
    private String reason;

    @NotEmpty(message = "At least one item must be selected for return")
    @Valid
    private List<CancellationItemRequestDTO> salonServices;
}
