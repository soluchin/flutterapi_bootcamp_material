package com.flutter.api.flutterapi.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.flutter.api.flutterapi.Model.UserModel;

@org.springframework.stereotype.Repository
public class Repository implements IRepository{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public int createUser(UserModel data) {
        var q= """
                INSERT INTO user(firstname, lastname, email, gender)
                VALUES(?,?,?,?);
                """;
        jdbc.update(q, new Object[]{
            data.getFirstname(),
            data.getLastname(),
            data.getEmail(),
            data.getGender()
        });
        return 0;
    }

    @Override
    public List<UserModel> getAllUser() {
        var q= """
                SELECT * FROM user;
                """;
        return jdbc.query(q, new BeanPropertyRowMapper<UserModel>(UserModel.class));
    }

    @Override
    public UserModel getUser(int id) {
        var q= """
                SELECT * FROM user
                WHERE userid = ?;
                """;
        return jdbc.queryForObject(q, new BeanPropertyRowMapper<UserModel>(UserModel.class), new Object[]{id});
    }

    @Override
    public int updateUser(int id, UserModel data) {
        // all null
        if(
            (data.getFirstname() == null) && 
            (data.getLastname() == null) &&
            (data.getEmail() == null) &&
            (data.getGender() == null)
        ){
            System.out.println("nothing changed");
            return 0;
        }

        // update not null
        String fn = (data.getFirstname() == null) ? "" : ",firstname = '" + data.getFirstname() +"'";
        String ln = (data.getLastname() == null) ? "" : ",lastname = '" + data.getLastname() +"'";
        String email = (data.getEmail() == null) ? "" : ",email = '" + data.getEmail() +"'";
        String gender = (data.getGender() == null) ? "" : ",gender = " + data.getGender();

        var q= "UPDATE user "
            + "SET userid = " + id + fn + ln + email + gender + " "
            + "WHERE userid = " + id + ";"; 

        return jdbc.update(q);
    }

    @Override
    public int deleteUser(int id) {
        var q= """
                DELETE FROM user
                WHERE userid = ?;
                """;
        return jdbc.update(q, id);
    }


}
