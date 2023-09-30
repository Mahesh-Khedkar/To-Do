package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO )
    @Column(name="UserId",unique=true)
    private int UserId;

    @Column(name="username", unique=true)
    private String email;

    @Column(name="password")
    private String Password;

    public User() {
        super();

    }

    public User(int userId, String eMail, String password) {
        super();
        UserId = userId;
        email = eMail;
        Password = password;
    }


    public int getUserId() {
        return UserId;
    }
    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String eMail) {
        email = eMail;
    }

    // @Override
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }


    @Override
    public String toString() {
        return "User [UserId=" + UserId + ",  email=" + email + ", Password=" + Password
                + "]";
    }
}
