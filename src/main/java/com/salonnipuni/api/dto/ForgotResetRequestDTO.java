package com.salonnipuni.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForgotResetRequestDTO {
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Verification code is required")
    private String otp;

    @NotBlank(message = "New password is required")
    @Size(min = 4, message = "New password must be at least 4 characters")
    private String newPassword;
}
