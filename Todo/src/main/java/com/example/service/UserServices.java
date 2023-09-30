package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserServices
{
    User registerUser(User user);

    User auth(String Email, String password);

}

