/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.User;

public class User {
    
    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;
    
    public int getId(){
        return id;
    }
    public int setId(int id){
    return id;
}
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

    public void setRole(String role){
        this.role=role;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public Object getUsername() {
        return username;
    }

    public Object getRole() {
       return role;
    }
}