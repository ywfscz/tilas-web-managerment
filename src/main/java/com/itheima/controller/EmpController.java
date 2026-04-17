package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


/**
 * 员工管理Controller
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 查询所有员工
     *
     * @return
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("查询所有员工，page={},pageSize={},name={},gender={},begin={},end={}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }


    /**
     * 删除员工
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除员工，ids={}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 新增员工
     *
     * @param emp
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工，emp={}", emp);
        empService.save(emp);
        return Result.success();
    }



    /**
     * 查询员工
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("查询员工，id={}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    /**
     * 更新员工
     *
     * @param emp
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("更新员工，emp={}", emp);
        empService.update(emp);
        return Result.success();
    }
}
