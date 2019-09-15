package com.example.swagger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.model.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class UserController {

	ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<>();

	@GetMapping("/users")
	public List<User> getUsers() {
		return new ArrayList<User>(users.values());
	}

	@GetMapping("/users/{id}")
	@ApiOperation(//
			value = "Find user by ID", //
			notes = "Provide an ID to find a user", //
			response = User.class)
	public User getUser(//
			@ApiParam(value = " ID value for the user you want to find", required = true) //
			@PathVariable Integer id) {
		return users.get(id);
	}

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		users.put(user.getId(), user);
		return user;
	}

}
