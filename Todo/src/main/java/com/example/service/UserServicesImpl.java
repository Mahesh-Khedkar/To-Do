package com.example.service;

import com.example.daos.UserDao;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServicesImpl implements UserServices
{
    @Autowired
    private UserDao userdao;

    PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User userSaved= userdao.save(user);
        return userSaved;
    }

    @Override
    public User auth(String Email, String password) {
        User user = userdao.findByEmail(Email);
        System.out.println("user ===="+user);
        passwordEncoder= new BCryptPasswordEncoder();
        if(user != null && passwordEncoder.matches(password,user.getPassword())) {
            return user;
        }
        return null;
    }

}

