package com.example.struts2.example.interceptor;

import com.example.struts2.example.mapper.UsersMapper;
import com.example.struts2.example.service.UsersService;

public interface MyBatisUserAware extends MyBatisAware {

	default UsersService usersService() {
		return new UsersService(getSqlSession(), getMapper(UsersMapper.class));
	}
}
