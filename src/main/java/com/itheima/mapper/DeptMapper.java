package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    /**
     * 查询全部部门数据
     *
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 删除部门
     *
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void delete(Integer id);

    /**
     * 添加部门
     *
     * @param dept
     */
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 更新部门
     *
     * @param dept
     */
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);


    /**
     * 根据id查询部门
     *
     * @param id
     * @return
     */
    @Select("select * from dept where id = #{id}")
    Dept select(Integer id);
}
