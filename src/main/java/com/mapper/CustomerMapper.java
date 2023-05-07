package com.mapper;

import com.bean.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CustomerMapper {

    /**
     * 顾客/用户登录
     * @param username
     * @param password
     * @return
     */

    @Select("select * from customer where username = #{username} and password = #{password}")
    Customer select (@Param("username") String username, @Param("password") String password);


    /**
     * 根据用户名查询用户对象
     * @param username
     * @return
     */
    @Select("select * from customer where username = #{username}")
    Customer selectByUsername(String username);


    /**
     * 添加顾客/用户
     * @param customer
     */

    @Insert("insert into customer values(#{username},null,#{password},0,#{telephone},#{gender},#{identity},0)")
    void add(Customer customer);


    /**
     * 查询顾客的个人信息
     * @param id
     * @return
     */
    @Select("select * from customer where id = #{id}")
    Customer selectAll(int id);


    /**
     * 修改顾客个人信息
     * @param Id
     * @param username
     * @param password
     * @param telephone
     * @param identity
     * @param gender
     */
    @Update("update customer set username = #{username},password = #{password},telephone = #{telephone},identity = #{identity},gender = #{gender} where id = #{Id}")
    void revise(@Param("username") String username,@Param("password") String password,@Param("telephone") String telephone,@Param("identity") String identity,@Param("gender") String gender,@Param("Id") int Id);


    /**
     * 管理员查询顾客全部信息
     * @return
     */
    @Select("select * from customer where is_delete = 0")
    List<Customer> selectAllCustomer();


    /**
     * 逻辑删除顾客全部信息
     * @param id
     */
    @Update("update customer set is_delete = 1 where id = #{id}")
    void deleteCustomerInformation(int id);

}
