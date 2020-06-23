package com.example.struts2.example.mapper;

import com.example.struts2.example.entity.Genders;
import com.example.struts2.example.entity.GendersCriteria;
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

public interface GendersMapper {
	@SelectProvider(type = GendersSqlProvider.class, method = "countByExample")
	long countByExample(GendersCriteria example);

	@DeleteProvider(type = GendersSqlProvider.class, method = "deleteByExample")
	int deleteByExample(GendersCriteria example);

	@Delete({
			"delete from genders",
			"where id = #{id,jdbcType=INTEGER}"
	})
	int deleteByPrimaryKey(Integer id);

	@Insert({
			"insert into genders (id, name)",
			"values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
	})
	int insert(Genders record);

	@InsertProvider(type = GendersSqlProvider.class, method = "insertSelective")
	int insertSelective(Genders record);

	@SelectProvider(type = GendersSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "g_id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "g_name", property = "name", jdbcType = JdbcType.VARCHAR)
	})
	List<Genders> selectByExampleWithRowbounds(GendersCriteria example, RowBounds rowBounds);

	@SelectProvider(type = GendersSqlProvider.class, method = "selectByExample")
	@Results({
			@Result(column = "g_id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "g_name", property = "name", jdbcType = JdbcType.VARCHAR)
	})
	List<Genders> selectByExample(GendersCriteria example);

	@Select({
			"select",
			"g.id as g_id, g.name as g_name",
			"from genders g",
			"where g.id = #{id,jdbcType=INTEGER}"
	})
	@Results({
			@Result(column = "g_id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
			@Result(column = "g_name", property = "name", jdbcType = JdbcType.VARCHAR)
	})
	Genders selectByPrimaryKey(Integer id);

	@UpdateProvider(type = GendersSqlProvider.class, method = "updateByExampleSelective")
	int updateByExampleSelective(@Param("record") Genders record, @Param("example") GendersCriteria example);

	@UpdateProvider(type = GendersSqlProvider.class, method = "updateByExample")
	int updateByExample(@Param("record") Genders record, @Param("example") GendersCriteria example);

	@UpdateProvider(type = GendersSqlProvider.class, method = "updateByPrimaryKeySelective")
	int updateByPrimaryKeySelective(Genders record);

	@Update({
			"update genders",
			"set name = #{name,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}"
	})
	int updateByPrimaryKey(Genders record);
}