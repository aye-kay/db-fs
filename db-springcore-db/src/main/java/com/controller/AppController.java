package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/db")
@CrossOrigin("*")
public class AppController {

    @Autowired
    private UserService service;



    List<User> list = new ArrayList<User>();

    @GetMapping("/welcome")
    public String ayWelcome(){
        return "welcome to spring boot.";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        boolean isFound=service.findUser(user.getUserName(), user.getPassword());
        if(isFound){
            return user.getUserName() + " " + "Found";
        }
        else{
            return "User not found";

        }


    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
//        list.add(user);
        service.addUser(user);
        return "you have successfully registered " + user;
    }
//role-manager
    @GetMapping("/loadusers")
    public List<User> loadusers(){
        return service.loadAll();
    }

    //role-- admin
    @DeleteMapping("/deleteuser/{uname}")
    public String deleteuser(@PathVariable String uname){
        if(service.deleteuser(uname)){
            return  uname + " " + " found and deleted";
        }
        return "user not found!";
    }

    @GetMapping("/finduser/{uname}")
    public String findUser(@PathVariable String uname){
        if(service.searchUser(uname)){
            return  uname + " " + " found ";
        }
        return "user not found!";
    }

    @PutMapping("/updateuser/{uname}")
    public String updateUser(@PathVariable String uname, @RequestBody User user){
        if(service.updateuser(uname, user)){
            return  uname + " " + " found and updated";
        }
        return "user not found!";
    }
}
