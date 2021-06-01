package com.example.jpa.controller;

import java.util.List;

import com.example.jpa.model.User;
import com.example.jpa.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path="/api")
@Component
public class DataController {

    @Autowired
    UserService userService;
    
    @PostMapping(path="/add")
    public ResponseEntity<Object> addUser(@RequestParam String name, @RequestParam String email, @RequestParam Integer id_role){
		String response = userService.addUser(name, email, id_role);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
    @GetMapping(path="/findall")
    public ResponseEntity<Object> findAll(){
		List<User> response = userService.findAll();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
    @DeleteMapping(path="/delete")
    public ResponseEntity<Object> deleteUser(@RequestParam Integer id){
		String response = userService.deleteUser(id);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	@PutMapping(path="/update")
    public ResponseEntity<Object> updateeUser(@RequestParam Integer id, @RequestParam String name, @RequestParam String email, @RequestParam Integer id_role){
		String response = userService.updateUser(id, name, email, id_role);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
    @GetMapping(path="/custom")
    public ResponseEntity<Object> custom(){
		List<User> response = userService.customquery();
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
