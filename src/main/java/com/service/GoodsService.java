package com.service;

import com.bean.Goods;
import com.mapper.GoodsMapper;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class GoodsService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 管理员添加新房型
     采购商品
     * @param username
     * @param number
     * @param image
     * @param price
     */
    public void addGoods(String username, String number, String image, String price){
        SqlSession sqlSession = factory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.addGoods(username,number,image,price);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 查询所有
     * @return
     */
    public List<Goods> selectAll(){

        SqlSession sqlSession = factory.openSession();

        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);

        List<Goods> goods = mapper.selectAll();

        sqlSession.close();

        return goods;
    }
}
