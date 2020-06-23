package com.example.struts2.example.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Roles {
	private Integer id;

	private String name;
}