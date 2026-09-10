package com.salonnipuni.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private String id;
    private String username;
    private String name;
    private String role;
    private String email;
    private boolean active;
    private String token;
    private boolean forcePasswordChange;
    private boolean otpRequired;
}
