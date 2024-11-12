package com.minhnghia.TaskManagement.repository;

import com.minhnghia.TaskManagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TaskRepository extends JpaRepository<Task, String> {

    @Query("SELECT t FROM Task t WHERE t.status = :status")
    List<Task> findTasksByStatus(@Param("status") String status);

    List<Task> findByTitle(String title);

}
