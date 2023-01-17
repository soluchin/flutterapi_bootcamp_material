package com.flutter.api.flutterapi.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "user")
public class UserModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int userid;
	private String firstname;
	private String lastname;
	private String email;
	private Integer gender;

	public void Construct(String firstname, String lastname, String email, Integer gender){
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.gender = gender;
	};
}