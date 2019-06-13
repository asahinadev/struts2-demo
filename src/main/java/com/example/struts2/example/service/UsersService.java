package com.example.struts2.example.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.example.struts2.example.entity.Users;
import com.example.struts2.example.entity.UsersCriteria;
import com.example.struts2.example.filter.MyBatisFilter;
import com.example.struts2.example.mapper.UsersMapper;

public class UsersService {

	SqlSession session;

	UsersMapper mapper;

	public UsersService(HttpServletRequest request) {

		session = (SqlSession) request.getAttribute(MyBatisFilter.MYBATIS_SESSION);
		mapper = session.getMapper(UsersMapper.class);

	}

	public int insert(Users user) {

		return mapper.insertSelective(user);
	}

	public int update(Users user) {

		return update(user, false);
	}

	public int update(Users user, boolean excludeNull) {

		if (excludeNull) {
			return mapper.updateByExampleSelective(user, byId(user.getId()));
		}

		return mapper.updateByExample(user, byId(user.getId()));
	}

	public int delete(Users user) {

		return mapper.deleteByExample(byId(user.getId()));
	}

	public long count() {

		return count(all());
	}

	public long count(UsersCriteria criteria) {

		return mapper.countByExample(criteria);
	}

	public List<Users> findAll() {

		return findAll(all());
	}

	public List<Users> findAll(UsersCriteria criteria) {

		return mapper.selectByExample(criteria);
	}

	public List<Users> findAll(int offset, int limit) {

		return findAll(all(), offset, limit);
	}

	public List<Users> findAll(UsersCriteria criteria, int offset, int limit) {

		return mapper.selectByExampleWithRowbounds(criteria, new RowBounds(offset, limit));
	}

	public long countByUsername(String username) {

		return mapper.countByExample(byUsername(username));

	}

	public List<Users> findByUsername(String username) {

		return mapper.selectByExample(byUsername(username));
	}

	public UsersCriteria all() {

		UsersCriteria criteria = new UsersCriteria();
		criteria.createCriteria().andIdIsNotNull();
		return criteria;

	}

	public UsersCriteria byId(Integer id) {

		UsersCriteria criteria = new UsersCriteria();
		criteria.createCriteria().andIdEqualTo(id);
		return criteria;

	}

	public UsersCriteria byUsername(String username) {

		UsersCriteria criteria = new UsersCriteria();
		criteria.createCriteria().andUsernameEqualTo(username);
		return criteria;

	}

}
