package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    /**
     * 查询员工总数
     *
     * @return
     */
//    @Select("select count(*) from emp")
//    public Long count();

    /**
     * 查询所有员工
     *
     * @return
     */
//    @Select("select * from emp limit #{start}, #{pageSize}")
//    public List<Emp> page(Integer start, Integer pageSize);

    /**
     * 查询所有员工
     *
     * @return
     */
    //@Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


    /**
     * 删除员工
     *
     * @param ids
     */
    void delete(@Param("ids") List<Integer> ids);

    /**
     * 新增员工
     *
     * @param emp
     */
    @Insert("insert into emp(username,name, gender, image, job,entrydate,dept_id , create_time, update_time) " +
            "values(#{username},#{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);

    /**
     * 查询员工
     *
     * @param id
     * @return
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 更新员工
     *
     * @param emp
     */
    void update(Emp emp);


    /**
     * 根据用户名和密码查询员工
     *
     * @param emp
     * @return
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);


    /**
     * 根据部门ID删除该部门下的员工数据
     * @param deptId
     */
    @Delete("delete  from emp where  dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
