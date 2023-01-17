package com.flutter.api.flutterapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flutter.api.flutterapi.Model.UserModel;
import com.flutter.api.flutterapi.Service.IService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    IService service;

    @PostMapping("/createuser")
    public String createUser(@RequestBody UserModel data){
        if(service.createUser(data) == 0){
            return "user created";
        }else{
            return "failed";
        }
    }
    
    @GetMapping("/getuser")
    public List<UserModel> getAllUser(){
        return service.getAllUser();
    }
    
    @GetMapping("/getuser/{id}")
    public UserModel getUser(@PathVariable int id){
        return service.getUser(id);
    }

    @PutMapping("/updateuser/{id}")
    public String updateUser(@PathVariable int id, @RequestBody UserModel data){
        if(service.updateUser(id,data) == 0){
            return String.format("user %d updated", id);
        }else{
            return "failed";
        }
    }

    @DeleteMapping("/deleteuser/{id}")
    public String delteUser(@PathVariable int id){
        if(service.deleteUser(id) == 0){
            return String.format("user %d deleted", id);
        }
        else{
            return "failed";
        }
    }

}
