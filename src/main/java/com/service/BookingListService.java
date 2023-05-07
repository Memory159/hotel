package com.service;

import com.bean.BookingList;
import com.mapper.BookingListMapper;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BookingListService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 添加预约信息到我的订单
     * @param nowTime
     * @param bookingTime
     * @param leaveTime
     * @param roomImg
     * @param type
     * @param customerName
     * @param telephone
     * @param identity
     */
    public void addInPeople(String bookingTime,String leaveTime,String nowTime,String roomImg,String price,String type,String customerName,String telephone,String identity,int id,SqlSession sqlSession){
        BookingListMapper mapper = sqlSession.getMapper(BookingListMapper.class);
        mapper.addInPeople(bookingTime, leaveTime, nowTime, roomImg, price, type, customerName, telephone, identity, id);
        sqlSession.commit();
        sqlSession.close();
    }



    /**
     * 查询所有到我的订单
     * @return
     */

    public List<BookingList> selectAll(int userId){
        SqlSession sqlSession = factory.openSession();
        BookingListMapper mapper = sqlSession.getMapper(BookingListMapper.class);
        List<BookingList> bookingLists = mapper.selectAll(userId);
        sqlSession.close();
        return bookingLists;
    }



    /**
     * 删除预约
     * @param id
     */
    public void deleteReserve(int id){
        SqlSession sqlSession = factory.openSession();
        BookingListMapper mapper = sqlSession.getMapper(BookingListMapper.class);
        mapper.deleteReserve(id);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 管理员查询所有顾客的预定信息
     * @return
     */
    public List<BookingList> selectAllReserve(){
        SqlSession sqlSession = factory.openSession();
        BookingListMapper mapper = sqlSession.getMapper(BookingListMapper.class);
        List<BookingList> bookingLists = mapper.selectAllReserve();
        sqlSession.close();
        return bookingLists;
    }

    /**
     * 查询相应字段到财务统计
     * @return
     */
    public List<BookingList> selectProperty(){
        SqlSession sqlSession = factory.openSession();
        BookingListMapper mapper = sqlSession.getMapper(BookingListMapper.class);
        List<BookingList> bookingLists = mapper.selectProperty();
        sqlSession.close();
        return bookingLists;
    }



}
