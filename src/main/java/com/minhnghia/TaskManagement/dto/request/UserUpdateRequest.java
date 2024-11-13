package com.minhnghia.TaskManagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
    @Size(min = 8, message = "Password must be more than 8 character")
    String password;
    @NotBlank(message = "Email not blank!")
    String email;
    String status;
}
