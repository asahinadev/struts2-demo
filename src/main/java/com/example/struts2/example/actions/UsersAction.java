package com.example.struts2.example.actions;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.convention.annotation.Action;

import com.example.struts2.example.entity.Users;
import com.example.struts2.example.interceptor.MyBatisUserAware;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Action()
@SuppressWarnings("serial")
public class UsersAction
		extends ActionSupport
		implements MyBatisUserAware {

	public List<Users> getUsers() {
		List<Users> users = usersService().findAll();
		if (log.isDebugEnabled()) {
			users.forEach(u -> System.out.printf("%5d:%s", u.getId(), u.getUsername()).println());
		}
		return users;
	}

	@Setter
	@Getter
	protected SqlSession sqlSession;

	public String execute() {
		log.debug("execute");
		return SUCCESS;
	}

}
