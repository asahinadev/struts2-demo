package com.example.struts2.example.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.example.struts2.example.entity.Users;
import com.example.struts2.example.entity.UsersCriteria;
import com.example.struts2.example.mapper.UsersMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class UsersService {

	final SqlSession session;

	final UsersMapper mapper;

	public UsersService(SqlSession session, UsersMapper mapper) {
		this.session = session;
		this.mapper = mapper;
	}

	/**
	 * インサート処理。
	 * 
	 * @param user data
	 * @return 処理結果
	 */
	public int insert(Users user) {
		log.debug("insert");
		return mapper.insert(user);
	}

	/**
	 * インサート処理（NULL以外）。
	 * 
	 * @param user data
	 * @return 処理結果
	 */
	public int insertSelective(Users user) {
		log.debug("insert");
		return mapper.insertSelective(user);
	}

	/**
	 * 更新処理。
	 * 
	 * @param user data
	 * @return 処理結果
	 */
	public int update(Users user) {
		log.debug("update");
		return mapper.updateByExample(user, byId(user.getId()));
	}

	/**
	 * 更新処理（NULL以外）。
	 * 
	 * @param user data
	 * @return 処理結果
	 */
	public int updateSelective(Users user) {
		log.debug("update");
		return mapper.updateByExampleSelective(user, byId(user.getId()));
	}

	/**
	 * 作御処理。
	 * 
	 * @param user data
	 * @return 処理結果
	 */
	public int delete(Users user) {
		log.debug("delete");
		return mapper.deleteByExample(byId(user.getId()));
	}

	/**
	 * 作御処理。
	 * 
	 * @param id user.id
	 * @return 処理結果
	 */
	public int delete(Integer id) {
		log.debug("delete");
		return mapper.deleteByExample(byId(id));
	}

	/**
	 * カウント。
	 * 
	 * @return 件数。
	 */
	public long count() {
		log.debug("count");
		return mapper.countByExample(all());
	}

	/**
	 * カウント。
	 * 
	 * @param criteria 検索条件
	 * @return 件数。
	 */
	public long count(UsersCriteria criteria) {
		log.debug("count");
		return mapper.countByExample(criteria);
	}

	/**
	 * 検索。
	 * 
	 * @return 検索結果。
	 */
	public List<Users> findAll() {
		log.debug("findAll");
		return mapper.selectByExample(all());
	}

	/**
	 * 検索。
	 * 
	 * @param criteria 検索条件
	 * @return 検索結果。
	 */
	public List<Users> findAll(UsersCriteria criteria) {
		log.debug("findAll");
		return mapper.selectByExample(criteria);
	}

	/**
	 * 検索。
	 * 
	 * @param offset 開始位置
	 * @param limit  件数
	 * @return 検索結果。
	 */
	public List<Users> findAll(int offset, int limit) {
		log.debug("findAll");
		return mapper.selectByExampleWithRowbounds(all(), new RowBounds(offset, limit));
	}

	/**
	 * 検索。
	 * 
	 * @param criteria 検索条件
	 * @param offset   開始位置
	 * @param limit    件数
	 * @return 検索結果。
	 */
	public List<Users> findAll(UsersCriteria criteria, int offset, int limit) {
		log.debug("findAll");
		return mapper.selectByExampleWithRowbounds(criteria, new RowBounds(offset, limit));
	}

	public boolean existsByUsername(String username) {
		log.debug("exists username {}", username);
		return mapper.countByExample(byUsername(username)) == 1;

	}

	public Users findByUsername(String username) {
		log.debug("find username {}", username);
		return mapper.selectByExample(byUsername(username)).get(0);
	}

	UsersCriteria all() {

		UsersCriteria criteria = new UsersCriteria();
		criteria.createCriteria().andIdIsNotNull();
		return criteria;

	}

	UsersCriteria byId(Integer id) {

		UsersCriteria criteria = new UsersCriteria();
		criteria.createCriteria().andIdEqualTo(id);
		return criteria;

	}

	UsersCriteria byUsername(String username) {

		UsersCriteria criteria = new UsersCriteria();
		criteria.createCriteria().andUsernameEqualTo(username);
		return criteria;

	}

}
