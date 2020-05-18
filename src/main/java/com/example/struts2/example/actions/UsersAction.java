package com.example.struts2.example.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.example.struts2.example.entity.Users;
import com.example.struts2.example.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("serial")
@Action()
public class UsersAction
		extends ActionSupport
		implements ServletRequestAware {

	@Setter
	protected HttpServletRequest servletRequest;

	@Getter
	protected List<Users> users;

	UsersService service;

	public String execute() {

		log.debug("{} {}", this.getClass(), "execute");

		service = new UsersService(servletRequest);
		users = service.findAll();

		return SUCCESS;
	}

	@Action("edit")
	public String edit() {

		log.debug("{} {}", this.getClass(), "edit");

		service = new UsersService(servletRequest);
		users = service.findAll();

		return SUCCESS;
	}

	@Action("delete")
	public String delete() {

		log.debug("{} {}", this.getClass(), "delete");

		service = new UsersService(servletRequest);
		users = service.findAll();

		return SUCCESS;
	}

}
