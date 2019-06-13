package com.example.struts2.example.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.example.struts2.example.entity.Users;
import com.example.struts2.example.service.UsersService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

@Namespace("")
@SuppressWarnings("serial")
//@Results({
//		@Result(name = Action.SUCCESS, location = "${redirectName}", type = "redirectAction")
//})
public class IndexAction
		extends ActionSupport
		implements ServletRequestAware {

	@Setter
	protected HttpServletRequest servletRequest;

	@Getter
	protected List<Users> users;

	UsersService service;

	public String execute() {

		service = new UsersService(servletRequest);
		users = service.findAll();

		return Action.SUCCESS;
	}

}
