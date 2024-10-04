package com.example.tuneHub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tuneHub.entities.Users;
import com.example.tuneHub.repositories.UsersRepository;

@Service
public class UserServiceImplementation implements UsersService {

	@Autowired
	UsersRepository repo;

	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "User is  Created and Saved";
	}

	@Override
	public boolean emailExists(String email) {

		if (repo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean validateUser(String email, String password) {
		// TODO Auto-generated method stub
		Users user = repo.findByEmail(email);
		String db_password = user.getPassword();
		if (db_password.equals(password)) {
			return true;
		} else {
			return false;

		}
	}

	@Override
	public String getRole(String email) {
		// TODO Auto-generated method stub
		return (( repo.findByEmail(email)).getRole());
	}

	@Override
	public Users getUser(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);

		
	}

	}

	


