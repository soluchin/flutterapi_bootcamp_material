package com.flutter.api.flutterapi.Service;

import java.util.List;

import com.flutter.api.flutterapi.Model.UserModel;

public interface IService {
    public int createUser(UserModel data);
    public List<UserModel> getAllUser();
    public UserModel getUser(int id);
    public int updateUser(int id, UserModel data);
    public int deleteUser(int id);
}
