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

	@Getter
	protected List<Users> users;

	@Setter
	@Getter
	protected SqlSession sqlSession;

	public String execute() {
		log.debug("execute");
		users = usersService().findAll();
		return SUCCESS;
	}

	@Action("add")
	public String add() {
		log.debug("add");
		return SUCCESS;
	}

	@Action("edit")
	public String edit() {
		log.debug("edit");
		return SUCCESS;
	}

	@Action("delete")
	public String delete() {
		log.debug("delete");
		return SUCCESS;
	}

}
