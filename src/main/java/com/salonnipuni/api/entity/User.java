package com.salonnipuni.api.entity;

import com.salonnipuni.api.enumeration.RecordStatus;
import com.salonnipuni.api.enumeration.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String email;

    @Enumerated(EnumType.STRING)
    private RecordStatus status = RecordStatus.ACTIVE;

    private boolean forcePasswordChange = false;

    private boolean twoFactorEnabled = false;

    private String otpCode;

    private java.time.LocalDateTime otpExpiry;
}
