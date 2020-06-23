package com.example.struts2.example.interceptor;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SuppressWarnings("serial")
public class FlywayInterceptor implements Interceptor {

	SqlSessionFactory factory;

	@Override
	public void destroy() {
		log.debug("destroy");
	}

	@Override
	public void init() {
		log.debug("init");
		Flyway flyway;

		try {

			Context context = new InitialContext();
			Context eventContext = (Context) context.lookup("java:comp/env");
			DataSource dataSource = (DataSource) eventContext.lookup("jdbc/struts2-example");

			try (Connection connection = dataSource.getConnection()) {
				DatabaseMetaData dm = connection.getMetaData();

				log.debug("{}", dm.getURL());
				log.debug("{}", dm.getUserName());
				log.debug("{}", dm.getDriverName());
				log.debug("{}", dm.getDriverMajorVersion());
				log.debug("{}", dm.getDriverMinorVersion());

			}

			FluentConfiguration configuration = new FluentConfiguration(getClass().getClassLoader());

			configuration.dataSource(dataSource);
			configuration.locations("classpath:db/migration");

			flyway = configuration.load();
			flyway.migrate();

		} catch (SQLException | NamingException e) {
			log.warn(e.getMessage(), e);
		}
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		log.debug("intercept");
		return invocation.invoke();
	}

}
