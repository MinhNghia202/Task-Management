package com.minhnghia.TaskManagement.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.sql.results.graph.embeddable.EmbeddableInitializer;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskCreationRequest {
    @NotEmpty(message = "Title is not empty!")
    @NotNull(message = "Title is not null!")
    String title;

    @NotEmpty(message = "Description is not empty!")
    @NotNull(message = "Description is not null!")
    String description;
    @NotEmpty(message = "Status is not empty!")
    @NotNull(message = "Status is not null!")
    String status;

    @FutureOrPresent(message = "The due date must be a future date!")
    @NotNull(message = "Due date is not null!")
    LocalDate dueDate;


}
