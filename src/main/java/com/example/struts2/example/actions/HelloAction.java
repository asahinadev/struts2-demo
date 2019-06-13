package com.example.struts2.example.actions;

import org.apache.struts2.convention.annotation.Namespace;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <code>Set welcome message.</code>
 */
@Namespace("")
@SuppressWarnings("serial")
public class HelloAction
		extends ActionSupport {

	public String execute() throws Exception {

		setMessage("HL");
		return SUCCESS;
	}

	/**
	 * Provide default valuie for Message property.
	 */
	public static final String MESSAGE = "hello.message";

	/**
	 * Field for Message property.
	 */
	private String message;

	/**
	 * Return Message property.
	 *
	 * @return Message property
	 */
	public String getMessage() {

		return message;
	}

	/**
	 * Set Message property.
	 *
	 * @param message Text to display on HelloWorld page.
	 */
	public void setMessage(String message) {

		this.message = message;
	}
}
