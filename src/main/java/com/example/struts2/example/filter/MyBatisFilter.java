package com.example.struts2.example.filter;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebFilter
public class MyBatisFilter implements Filter {

	public static final String MYBATIS_SESSION = "MYBATIS_SESSION";

	SqlSessionFactory factory;

	@Override
	public void init(FilterConfig config) throws ServletException {

		log.debug("init {}", this.getClass());

		ToStringBuilder.setDefaultStyle(ToStringStyle.JSON_STYLE);

		try (InputStream in = MyBatisFilter.class.getResourceAsStream("/mybatis-config.xml")) {
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			throw new ServletException(e.getMessage(), e);
		}
	}

	@Override
	public void destroy() {
		log.debug("destroy {}", this.getClass());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try (SqlSession session = factory.openSession(ExecutorType.SIMPLE, false)) {

			log.info("TRANSACTION {}", "START");
			log.debug("setAttribute {} {}", MYBATIS_SESSION, session);

			request.setAttribute(MYBATIS_SESSION, session);
			try {
				chain.doFilter(request, response);
				log.info("TRANSACTION {}", "END");
				session.commit();
			} catch (Throwable e) {
				log.warn("TRANSACTION {}", "ERROR", e);
				session.rollback();
				throw e;
			}

			log.debug("removeAttribute {}", MYBATIS_SESSION);
			request.removeAttribute(MYBATIS_SESSION);
		}

	}

}
