package com.garsa.corp.controller;

import com.garsa.corp.model.UserModel;
import com.garsa.corp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers(){
     return userService.getAllUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getById(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<UserModel> getByPriority(@RequestParam("priority")Integer priority){
        return this.userService.getByPriority(priority);

    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "The user "+id+" has been deleted";
        }
        else {
            return "User "+id+" has not been deleted";
        }
    }

}
