package com.garsa.corp.service;

import com.garsa.corp.model.UserModel;
import com.garsa.corp.respository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getAllUsers(){
        return (ArrayList)userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> getByPriority(Integer priority){
        return userRepository.findByPriority(priority);
    }

    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}
