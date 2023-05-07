package com.service;

import com.bean.Customer;
import com.mapper.CustomerMapper;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CustomerService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();


    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */

    public Customer login(String username, String password){

        // 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 获取UserMapper
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        // 调用方法
        Customer customer = mapper.select(username, password);
        // 释放资源
        sqlSession.close();
        return customer;
    }

    /**
     * 注册方法
     * @param customer
     * @return
     */

    public boolean register(Customer customer){
        // 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 获取CustomerMapper
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        // 判断用户名是否存在
       Customer c =  mapper.selectByUsername(customer.getUsername());

       if(c == null){
           // 用户名不存在，注册
           mapper.add(customer);
           // 提交事务
           sqlSession.commit();
       }
       // 释放资源
        sqlSession.close();
       // 用户名不存在，返回false
       return c == null;

    }


    /**
     * 查询顾客的个人信息
     * @param id
     * @return
     */
   public Customer selectAll(int id){
       // 获取sqlSession
       SqlSession sqlSession = factory.openSession();
       // 获取UserMapper
       CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
       // 调用方法
       Customer customer = mapper.selectAll(id);
       // 释放资源
       sqlSession.close();
       return customer;
   }


    /**
     * 修改顾客个人信息
     * @param Id
     */
    public void revise(String username,String password,String telephone,String identity,String gender,int Id){
        SqlSession sqlSession = factory.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        mapper.revise(username,password,telephone,identity,gender,Id);
        sqlSession.commit();
        sqlSession.close();
    }



    /**
     * 管理员查询顾客全部信息
     * @return
     */
    public List<Customer> selectAllCustomer(){
        SqlSession sqlSession = factory.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.selectAllCustomer();
        sqlSession.close();
        return customers;
    }


    /**
     * 逻辑删除顾客全部信息
     * @param id
     */
    public void deleteCustomerInformation(int id){
        SqlSession sqlSession = factory.openSession();
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        mapper.deleteCustomerInformation(id);
        sqlSession.commit();
        sqlSession.close();
    }

}
