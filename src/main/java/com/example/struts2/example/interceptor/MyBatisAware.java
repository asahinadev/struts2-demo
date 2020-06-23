package com.example.struts2.example.interceptor;

import org.apache.ibatis.session.SqlSession;

public interface MyBatisAware {

	public void setSqlSession(SqlSession session);

	public SqlSession getSqlSession();

	default <E> E getMapper(Class<E> type) {
		return getSqlSession().getMapper(type);
	}
}
