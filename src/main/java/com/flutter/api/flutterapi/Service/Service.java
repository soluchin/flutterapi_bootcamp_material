package com.flutter.api.flutterapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flutter.api.flutterapi.Model.UserModel;
import com.flutter.api.flutterapi.Repository.IRepository;

@org.springframework.stereotype.Service
public class Service implements IService{

    @Autowired
    IRepository repository;

    @Override
    public int createUser(UserModel data) {
        repository.createUser(data);
        return 0;
    }

    @Override
    public List<UserModel> getAllUser() {
        return repository.getAllUser();
    }

    @Override
    public UserModel getUser(int id) {
        return repository.getUser(id);
    }
    
    @Override
    public int updateUser(int id, UserModel data) {
        repository.updateUser(id, data);
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        repository.deleteUser(id);
        return 0;
    }


}
