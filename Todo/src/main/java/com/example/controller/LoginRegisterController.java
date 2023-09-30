package com.example.controller;

import com.example.daos.UserDao;
import com.example.entity.User;
import com.example.model.ResponseDTO;
import com.example.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginRegisterController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserServices userservice;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        System.out.println("In register User"+user);
        try{
            if(userDao.findByEmail(user.getEmail()) == null) {

                User usersaved=userservice.registerUser(user);
                usersaved.setPassword("**");
                if(usersaved != null) {
                    ResponseDTO response= new ResponseDTO("successfully Registered");
                    return  ResponseEntity.ok(response);
                }
                else
                    throw new Exception();
            }else {
                ResponseDTO response= new ResponseDTO("email already exist");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e) {
            ResponseDTO response= new ResponseDTO("something went wrong");
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> LoginUser(@RequestBody User user) {
        System.out.println("in get user dtls " + user.getEmail()+user.getPassword());
        try{
            User userauth=userservice.auth(user.getEmail(), user.getPassword());
            System.out.println("user"+userauth);
            if(userauth==null) {
                ResponseDTO response= new ResponseDTO("please insert valid Email and Password");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            else {
                userauth.setPassword("***");

                ResponseDTO response= new ResponseDTO("success",userauth);
                return  ResponseEntity.ok(response);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            ResponseDTO response= new ResponseDTO("something went wrong");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

