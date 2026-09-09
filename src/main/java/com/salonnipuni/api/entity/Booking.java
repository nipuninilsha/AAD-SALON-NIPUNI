package com.salonnipuni.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    private long bookingNumber;

    private String clientId;

    private String clientName;

    private LocalDate date;

    private String time;

    private String status;

    private double subtotal;

    private double tax;

    private double discount;

    private double total;

    private String paymentMethod;

    private String staffUsername;

    // ---- Public-site booking request fields (populated when a client books via
    // the Salon Nipuni website booking form rather than being checked out in person) ----

    /** Stylist requested/assigned for this booking, if any. */
    private String stylistId;

    /** Guest contact info, used for phone-in / walk-in booking requests logged by staff where there's no Client record yet. */
    private String clientPhone;

    private String preferredDate;

    private String preferredTime;

    @Column(length = 1000)
    private String message;

    /** Whether the "New booking received" admin notification email was sent. */
    private boolean whatsappSent;

    /** Whether the client completed the "Confirm via WhatsApp" handoff on the site. */
    private boolean whatsappConfirmed;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<BookingItem> salonServices = new ArrayList<>();
}

