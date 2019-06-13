package com.example.struts2.example.filter;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class FlywayFilter implements Filter {

	FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {

		log.debug("init {}", config.getFilterName());
		this.config = config;

		try {

			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/struts2-demo");
			Flyway flyway = Flyway.configure()
					.dataSource(dataSource)
					.locations("classpath:/db/migrations")
					.load();
			flyway.migrate();

		} catch (NamingException e) {
			log.warn(e.getMessage(), e);

		}

	}

	@Override
	public void destroy() {

		log.debug("destroy {}", config.getFilterName());
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		chain.doFilter(request, response);
	}

}
