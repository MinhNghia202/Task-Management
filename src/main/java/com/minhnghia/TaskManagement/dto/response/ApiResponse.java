package com.minhnghia.TaskManagement.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.DateTimeException;
import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T>{

    int code = 1000;
    String message;
    T result;

}
