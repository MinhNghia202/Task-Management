package com.minhnghia.TaskManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDate createAt = LocalDate.now();

    @Column(name = "due_date")
    private LocalDate dueDate;


}
