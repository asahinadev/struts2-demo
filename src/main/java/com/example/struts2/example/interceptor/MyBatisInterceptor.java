package com.example.struts2.example.interceptor;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.struts2.example.ApplicationRoot;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings("serial")
public class MyBatisInterceptor implements Interceptor {

	SqlSessionFactory factory;

	@Override
	public void destroy() {
		log.debug("destroy");
	}

	@Override
	public void init() {
		log.debug("init");
		try (InputStream in = getResourceAsStream("/mybatis/config.xml")) {
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 *
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		log.debug("intercept");
		final Object action = invocation.getAction();

		if (action instanceof MyBatisAware) {
			((MyBatisAware) action).setSqlSession(factory.openSession());
		}
		return invocation.invoke();
	}

	private InputStream getResourceAsStream(String name) {
		return ApplicationRoot.class.getResourceAsStream(name);
	}

}
