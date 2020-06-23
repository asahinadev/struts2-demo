package com.example.struts2.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Users {
	private Integer id;

	private String username;

	private String password;
}