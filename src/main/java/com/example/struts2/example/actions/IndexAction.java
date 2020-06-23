package com.example.struts2.example.actions;

import org.apache.struts2.convention.annotation.Action;

import com.example.struts2.example.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Action()
@SuppressWarnings("serial")
public class IndexAction extends ActionSupport {

	UsersService service;

	public String execute() {
		log.debug("execute");
		return SUCCESS;
	}

}
