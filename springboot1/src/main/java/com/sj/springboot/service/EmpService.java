package com.sj.springboot.service;

import com.sj.springboot.pojo.Emp;

import java.util.List;

public interface EmpService {

    //增删改查
    Emp save(Emp emp);
    int del(Integer id);
    int update(Emp emp);
    //cha查全部
    List<Emp> select();
    //根据id查
    Emp selectOne(Integer id);
    //分页查
    List<Emp> selectByPage(int pageNum,int pageSize);
}
