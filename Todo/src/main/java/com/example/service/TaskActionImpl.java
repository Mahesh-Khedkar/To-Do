package com.example.service;

import com.example.daos.TaskDao;
import com.example.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskActionImpl implements TaskAction
{
    @Autowired
    private TaskDao taskdao;

    @Override
    public Task register(Task task)
    {
        Task saveTask=taskdao.save(task);
        return saveTask;
    }
}