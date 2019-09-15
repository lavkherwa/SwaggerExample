package com.example.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All the details about user")
public class User {

	@ApiModelProperty(notes = "The unique ID for a user record")
	private int id;

	@ApiModelProperty(notes = "User name")
	private String name;

	@ApiModelProperty(notes = "User phone number")
	private String phone;

	@ApiModelProperty(notes = "User address")
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
