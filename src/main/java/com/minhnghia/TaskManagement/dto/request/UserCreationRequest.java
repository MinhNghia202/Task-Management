package com.minhnghia.TaskManagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @NotBlank(message = "Username not blank!")
    String username;
    @Size(min = 8, message = "Password must be more than 8 character")
    String password;
    @NotBlank(message = "Email not blank!")
    String email;
    String status;
}
