package com.service;

import com.bean.Admin;
import com.bean.Customer;
import com.mapper.AdminMapper;
import com.mapper.CustomerMapper;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AdminService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */


    public Admin login(String username, String password){
        // 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 获取UserMapper
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        // 调用方法
        Admin admin = mapper.select(username, password);
        // 释放资源
        sqlSession.close();
        return admin;
    }


    /**
     * 查询管理员的个人信息
     * @param id
     * @return
     */
    public Admin selectAll(int id){
        SqlSession sqlSession = factory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = mapper.selectAll(id);
        sqlSession.close();
        return admin;
    }


    /**
     * 修改管理员个人信息
     * @param Id
     */
    public void revise(String username,String password,int Id){
        SqlSession sqlSession = factory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        mapper.revise(username,password,Id);
        sqlSession.commit();
        sqlSession.close();
    }




}
