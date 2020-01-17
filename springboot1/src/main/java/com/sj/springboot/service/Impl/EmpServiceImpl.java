package com.sj.springboot.service.Impl;

import com.github.pagehelper.PageHelper;
import com.sj.springboot.mapper.EmpMapper;
import com.sj.springboot.pojo.Emp;
import com.sj.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper mapper;

    @Override
    public Emp save(Emp emp) {
        int result = mapper.insertSelective(emp);
        if(result > 0)
            return emp;
        return null;
    }

    @Override
    public int del(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Emp emp) {
        return mapper.updateByPrimaryKeySelective(emp);
    }

    @Override
    public List<Emp> select() {
        return mapper.selectAll();
    }

    @Override
    public Emp selectOne(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Emp> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return mapper.selectAll();
    }
}
