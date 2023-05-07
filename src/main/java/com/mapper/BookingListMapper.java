package com.mapper;

import com.bean.BookingList;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookingListMapper {
    /**
     * 添加预约信息到数据库
     * @param nowTime
     * @param bookingTime
     * @param leaveTime
     * @param roomImg
     * @param type
     * @param customerName
     * @param telephone
     * @param identity
     */
    @Insert("insert into booking_list (bookingTime,leaveTime,nowTime,id,roomImg,price,type,customerName,telephone,identity,state,userid) values (#{bookingTime},#{leaveTime},#{nowTime},null,#{roomImg},#{price},#{type},#{customerName},#{telephone},#{identity},0,#{userId})")
    void addInPeople(@Param("bookingTime") String bookingTime, @Param("leaveTime") String leaveTime, @Param("nowTime") String nowTime, @Param("roomImg") String roomImg,@Param("price") String price,@Param("type") String type,@Param("customerName") String customerName,@Param("telephone") String telephone,@Param("identity") String identity,@Param("userId") int userId);


    /**
     * 查询所有到我的订单
     * @return
     */

    @Select("select * from booking_list where state = 0 and userid = #{userId}")
    List<BookingList> selectAll(int userId);


    /**
     * 逻辑删除预约
     * @param id
     */
    @Update("update booking_list set state = 1 where id = #{Id}")
    void deleteReserve(int id);


    /**
     * 管理员查询所有顾客的预定信息
     * @return
     */
    @Select("select b.username,a.bookingTime,a.leaveTime,a.customerName,a.telephone,a.identity from customer b join booking_list a on a.userid = b.id")
    List<BookingList> selectAllReserve();


    /**
     * 查询相应字段到财务统计
     * @return
     */
    @Select("select b.price,a.id,a.bookingTime,a.leaveTime,a.type,a.customerName,a.nowTime from room b join booking_list a on a.type = b.type")
    List<BookingList> selectProperty();

}
