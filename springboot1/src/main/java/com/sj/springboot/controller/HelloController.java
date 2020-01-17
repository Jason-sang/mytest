package com.sj.springboot.controller;


import com.sj.springboot.pojo.Emp;
import com.sj.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private EmpService service;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


    @RequestMapping("/list")
    public List<Emp> show(){
        return service.select();
    }

    //增
    @RequestMapping("/save")
    public Emp save(@RequestBody Emp emp){
        return service.save(emp);
    }

    //删
    @RequestMapping("/del")
    public int del(Integer id){
        return service.del(id);
    }

    //改
    @RequestMapping("/update")
    public int update(Emp emp){
        return service.update(emp);
    }

    //分页查
    @RequestMapping("/selectpage")
    public List<Emp> selectByPage(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum, @RequestParam(value = "pageSize",defaultValue = "1")int pageSize){
        return service.selectByPage(pageNum,pageSize);
    }

    //查单个
    @RequestMapping("/select1")
    public Emp selectOne(Integer id){
        return service.selectOne(id);
    }

}
