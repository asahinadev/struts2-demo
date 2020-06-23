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
	 * �C���T�[�g�����B
	 * 
	 * @param user data
	 * @return ��������
	 */
	public int insert(Users user) {
		log.debug("insert");
		return mapper.insert(user);
	}

	/**
	 * �C���T�[�g�����iNULL�ȊO�j�B
	 * 
	 * @param user data
	 * @return ��������
	 */
	public int insertSelective(Users user) {
		log.debug("insert");
		return mapper.insertSelective(user);
	}

	/**
	 * �X�V�����B
	 * 
	 * @param user data
	 * @return ��������
	 */
	public int update(Users user) {
		log.debug("update");
		return mapper.updateByExample(user, byId(user.getId()));
	}

	/**
	 * �X�V�����iNULL�ȊO�j�B
	 * 
	 * @param user data
	 * @return ��������
	 */
	public int updateSelective(Users user) {
		log.debug("update");
		return mapper.updateByExampleSelective(user, byId(user.getId()));
	}

	/**
	 * ��䏈���B
	 * 
	 * @param user data
	 * @return ��������
	 */
	public int delete(Users user) {
		log.debug("delete");
		return mapper.deleteByExample(byId(user.getId()));
	}

	/**
	 * ��䏈���B
	 * 
	 * @param id user.id
	 * @return ��������
	 */
	public int delete(Integer id) {
		log.debug("delete");
		return mapper.deleteByExample(byId(id));
	}

	/**
	 * �J�E���g�B
	 * 
	 * @return �����B
	 */
	public long count() {
		log.debug("count");
		return mapper.countByExample(all());
	}

	/**
	 * �J�E���g�B
	 * 
	 * @param criteria ��������
	 * @return �����B
	 */
	public long count(UsersCriteria criteria) {
		log.debug("count");
		return mapper.countByExample(criteria);
	}

	/**
	 * �����B
	 * 
	 * @return �������ʁB
	 */
	public List<Users> findAll() {
		log.debug("findAll");
		return mapper.selectByExample(all());
	}

	/**
	 * �����B
	 * 
	 * @param criteria ��������
	 * @return �������ʁB
	 */
	public List<Users> findAll(UsersCriteria criteria) {
		log.debug("findAll");
		return mapper.selectByExample(criteria);
	}

	/**
	 * �����B
	 * 
	 * @param offset �J�n�ʒu
	 * @param limit  ����
	 * @return �������ʁB
	 */
	public List<Users> findAll(int offset, int limit) {
		log.debug("findAll");
		return mapper.selectByExampleWithRowbounds(all(), new RowBounds(offset, limit));
	}

	/**
	 * �����B
	 * 
	 * @param criteria ��������
	 * @param offset   �J�n�ʒu
	 * @param limit    ����
	 * @return �������ʁB
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
