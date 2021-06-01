package com.example.jpa.service;

import java.util.List;

import com.example.jpa.model.Role;
import com.example.jpa.model.User;
import com.example.jpa.model.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private User n;
    @Autowired
    private Role r;
    @Autowired
    private UserRepo repo;
    
    @Override
    public String addUser(String name, String email, Integer id_role){
        n.setName(name);
        n.setEmail(email);
        //r.setId(id_role);
        //r.setRoleName(name_role);
        n.setRol(id_role);
        repo.save(n);
        return "Saved";  
    }
    @Override
    public String deleteUser(Integer id){
        repo.deleteById(id);
        return "Deleted";  
    }
    @Override
    public List<User> findAll(){ 
        return repo.findAll();  
    }
    @Override
    public String updateUser(Integer id, String name, String email, Integer id_role){ 
        n = repo.getOne(id);
        n.setName(name);
        n.setEmail(email);
        n.setRol(id_role);
        repo.save(n); 
        return "Updated";
    }
    @Override
    public List<User> customquery(){ 
        return repo.customquery();  
    }
}
