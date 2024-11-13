package com.minhnghia.TaskManagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id")
            @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "email")
    @Email String email;

    @Column(name = "role")
    String role;

    @Column(name = "status")
    String status;

    @Column(name = "created_at")
    LocalDate createdAt;

    @PrePersist
    public void prePersist() {
        if (this.role == null) {
            this.role = "User";
        }
        if (this.createdAt == null) {
            this.createdAt = LocalDate.now();
        }
    }
}
