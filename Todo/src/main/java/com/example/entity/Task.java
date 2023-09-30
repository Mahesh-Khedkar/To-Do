package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="Task")
public class Task
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="TaskId")
    private int TaskId;

    @Column(name="description")
    private String description;

    @Column(name="user_id")
    private String userId ;

    @Column(name="Date")
    private String Date;


    public Task() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Task(int taskId, String description, String userId, String date) {
        super();
        TaskId = taskId;
        this.description = description;
        this.userId = userId;
        Date = date;

    }

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int taskId) {
        TaskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }


    @Override
    public String toString()
    {
        return "Task [TaskId=" + TaskId + ", description=" + description + ", userId=" + userId + ", Date=" + Date
                + "]";
    }
}
