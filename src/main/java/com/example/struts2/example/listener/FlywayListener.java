package com.example.struts2.example.listener ;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebListener
public class FlywayListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.debug("contextDestroyed {}", this.getClass());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.debug("contextInitialized {}", this.getClass());

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
}
