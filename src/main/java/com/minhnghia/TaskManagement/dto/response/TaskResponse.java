package com.minhnghia.TaskManagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskResponse {
    private String id;
    private String title;
    private String description;
    private String status;
    private LocalDate createAt;
    private LocalDate dueDate;

}
