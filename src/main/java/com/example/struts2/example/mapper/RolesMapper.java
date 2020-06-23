package com.example.struts2.example.mapper;

import com.example.struts2.example.entity.Roles;
import com.example.struts2.example.entity.RolesCriteria;
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

public interface RolesMapper {
    @SelectProvider(type=RolesSqlProvider.class, method="countByExample")
    long countByExample(RolesCriteria example);

    @DeleteProvider(type=RolesSqlProvider.class, method="deleteByExample")
    int deleteByExample(RolesCriteria example);

    @Delete({
        "delete from roles",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into roles (id, name)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Roles record);

    @InsertProvider(type=RolesSqlProvider.class, method="insertSelective")
    int insertSelective(Roles record);

    @SelectProvider(type=RolesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="r_id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="r_name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Roles> selectByExampleWithRowbounds(RolesCriteria example, RowBounds rowBounds);

    @SelectProvider(type=RolesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="r_id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="r_name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Roles> selectByExample(RolesCriteria example);

    @Select({
        "select",
        "r.id as r_id, r.name as r_name",
        "from roles r",
        "where r.id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="r_id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="r_name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Roles selectByPrimaryKey(Integer id);

    @UpdateProvider(type=RolesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Roles record, @Param("example") RolesCriteria example);

    @UpdateProvider(type=RolesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Roles record, @Param("example") RolesCriteria example);

    @UpdateProvider(type=RolesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Roles record);

    @Update({
        "update roles",
        "set name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Roles record);
}