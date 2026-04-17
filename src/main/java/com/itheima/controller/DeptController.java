package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        //查询全部部门数据
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门:{}", id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 添加部门
     * @param dept
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("添加部门:{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 更新部门
     * @param dept
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("更新部门:{}", dept);
        deptService.update(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("根据id查询部门:{}", id);
        Dept dept = deptService.get(id);
        return Result.success(dept);
    }
}
