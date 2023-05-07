package com.mapper;

import com.bean.Admin;
import com.bean.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AdminMapper {

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */

    @Select("select * from admin where username = #{username} and password = #{password}")
    Admin select (@Param("username") String username, @Param("password") String password);


    /**
     * 查询管理员的个人信息
     * @param id
     * @return
     */
    @Select("select * from admin where id = #{id}")
    Admin selectAll(int id);


    /**
     * 修改管理员个人信息
     * @param Id
     * @param username
     * @param password
     */
    @Update("update admin set username = #{username},password = #{password} where id = #{Id}")
    void revise(@Param("username") String username,@Param("password") String password,@Param("Id") int Id);


}
