package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {

    /**
     * 查询所有员工
     *
     * @return
     */
    PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end);


    /**
     * 删除员工
     *
     * @param ids
     */
    void delete(List<Integer> ids);


    /**
     * 新增员工
     *
     * @param emp
     */
    void save(Emp emp);


    /**
     * 查询员工
     *
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 更新员工
     *
     * @param emp
     */
    void update(Emp emp);


    /**
     * 登录
     *
     * @param emp
     * @return
     */
    Emp login(Emp emp);

}
