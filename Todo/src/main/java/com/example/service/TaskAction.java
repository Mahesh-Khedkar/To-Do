package com.example.service;

import com.example.entity.Task;
import org.springframework.stereotype.Service;

@Service
public interface TaskAction
{
    Task register(Task task);
}
