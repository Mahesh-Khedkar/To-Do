package com.example.daos;

import com.example.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDao extends JpaRepository<Task,Integer>
{
    List<Task> findByUserId(String userId);
}
