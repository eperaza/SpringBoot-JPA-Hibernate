package com.example.jpa.service;

import java.util.List;

import com.example.jpa.model.User;

public interface IUserService {
    
    public String addUser(String name, String email, Integer id_role);
    public String deleteUser(Integer id);
    public String updateUser(Integer id, String name, String email, Integer id_role);
    public List<User> findAll();
    public List<User> customquery();

}
