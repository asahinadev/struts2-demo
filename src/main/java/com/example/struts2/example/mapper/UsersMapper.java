package com.example.struts2.example.mapper;

import com.example.struts2.example.entity.Users;
import com.example.struts2.example.entity.UsersCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface UsersMapper {
	@SelectProvider(type = UsersSqlProvider.class, method = "countByExample")
	long countByExample(UsersCriteria example);

	@DeleteProvider(type = UsersSqlProvider.class, method = "deleteByExample")
	int deleteByExample(UsersCriteria example);

	@Delete({
			"delete from users",
			"where id = #{id,jdbcType=INTEGER}"
	})
	int deleteByPrimaryKey(Integer id);

	@Insert({
			"insert into users (id, username, ",
			"password)",
			"values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
			"#{password,jdbcType=VARCHAR})"
	})
	int insert(Users record);

	@InsertProvider(type = UsersSqlProvider.class, method = "insertSelective")
	int insertSelective(Users record);

	@SelectProvider(type = UsersSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "u_id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "u_username", property = "username", jdbcType = JdbcType.VARCHAR),
			@Result(column = "u_password", property = "password", jdbcType = JdbcType.VARCHAR)
	})
	List<Users> selectByExampleWithRowbounds(UsersCriteria example, RowBounds rowBounds);

	@SelectProvider(type = UsersSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "u_id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "u_username", property = "username", jdbcType = JdbcType.VARCHAR),
			@Result(column = "u_password", property = "password", jdbcType = JdbcType.VARCHAR)
	})
	List<Users> selectByExample(UsersCriteria example);

	@Select({
			"select",
			"u.id as u_id, u.username as u_username, u.password as u_password",
			"from users u",
			"where u.id = #{id,jdbcType=INTEGER}"
	})
	@Results({
			@Result(column = "u_id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "u_username", property = "username", jdbcType = JdbcType.VARCHAR),
			@Result(column = "u_password", property = "password", jdbcType = JdbcType.VARCHAR)
	})
	Users selectByPrimaryKey(Integer id);

	@UpdateProvider(type = UsersSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersCriteria example);

	@UpdateProvider(type = UsersSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Users record, @Param("example") UsersCriteria example);

	@UpdateProvider(type = UsersSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Users record);

	@Update({
			"update users",
			"set username = #{username,jdbcType=VARCHAR},",
			"password = #{password,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}"
	})
	int updateByPrimaryKey(Users record);
}