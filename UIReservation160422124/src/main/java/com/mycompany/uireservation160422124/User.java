/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uireservation160422124;

import java.time.LocalDate;

/**
 *
 * @author natha
 */
public class User {
    public int id;
    public String fullName;
    public String username;
    public String password;
    public String email;
    public LocalDate dob;
    public LocalDate memberSince;
    
    public User() throws Exception{
        setId(0);
        setFullName("My name");
        setUsername("Username");
        setEmail("Email");
        setPassword("Password");
        setDob(LocalDate.now());
        setMemberSince(LocalDate.now());
    }
    
    public User(int id, String fullName, String username, String email, String password, LocalDate dob, LocalDate memberSince) throws Exception{
        setId(id);
        setFullName(fullName);
        setUsername(username);
        setEmail(email);
        setPassword(password);
        setDob(dob);
        setMemberSince(memberSince);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws Exception{
        if (fullName == "") {
            throw(new Exception("Full Name can not be empty!"));
        }
        else {
            this.fullName = fullName;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws Exception{
        if (username == "") {
            throw(new Exception("Username can not be empty!"));
        }
        else {
            this.username = username;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception{
        if (password == "") {
            throw(new Exception("Password can not be empty!"));
        }
        else {
            this.password = password;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception{
        if (email == "") {
            throw(new Exception("Email can not be empty!"));
        }
        else {
            this.email = email;
        }
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(LocalDate memberSince) {
        this.memberSince = memberSince;
    }
    
}
