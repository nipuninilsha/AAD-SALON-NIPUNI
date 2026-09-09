package com.salonnipuni.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking_cancellation")
public class BookingCancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String bookingId;

    private String clientId;

    private String reason;

    private LocalDate date;

    private double totalRefund;

    @OneToMany(mappedBy = "bookingCancellation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CancellationItem> salonServices = new ArrayList<>();
}
