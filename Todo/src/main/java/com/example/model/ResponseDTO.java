package com.example.model;

import com.example.entity.User;

public class ResponseDTO
{
    private String result;
    private User user;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public ResponseDTO()
    {
    }

    public ResponseDTO(String result) {
        this.result = result;
    }

    public ResponseDTO(String result, User user) {
        this.result = result;
        this.user = user;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "ResponseDTO [result=" + result + ", user=" + user + "]";
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

