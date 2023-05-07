package com.mapper;

import com.bean.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsMapper {

    /**
     * 采购商品
     * @param username
     * @param number
     * @param image
     * @param price
     */
    @Insert("insert into goods (id,username,number,image,price) values (null,#{username},#{number},#{image},#{price})")
    void addGoods(@Param("username") String username, @Param("number") String number, @Param("image") String image, @Param("price") String price);


    /**
     * 查询所有
     * @return
     */
    @Select("select * from goods")
    List<Goods> selectAll();

}
