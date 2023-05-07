package com.mapper;

import com.bean.Room;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import sun.awt.SunHints;

import java.util.List;

public interface RoomMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from room where sumRoom > 0 and is_delete = 0")
    List<Room> selectAll();

    /**
     * 根据id查询单个房间
     * @param roomId
     * @return
     */
    @Select("select * from room where id = #{roomId}")
    Room selectById(int roomId);


    /**
     * 根据 id 修改房间预定的值，每次预定成功房间自增一
     * @param id
     */

    @Update("update room set reserveRoom = reserveRoom + 1 where id = #{id}")
    void updateRoom(int id);


    /**
     * 模糊查询搜索框
     * @param value
     */

    @Select("select * from room where concat(type,price,peopleNumber,bedNumber) like concat('%',#{value},'%')")
    List<Room> selectRoom(String value);


    /**
     * 多条件查询搜索框
     * @param tValue
     * @param pValue
     * @param value1
     * @param value2
     * @return
     */
    @Select("select * from room where ${tValue} = #{value1} or ${pValue} = #{value2}")
    List<Room> moreSelectAll(@Param("tValue") String tValue,@Param("pValue")String pValue,@Param("value1")String value1,@Param("value2")String value2);



    /**
     *管理员根据 id 增加房间
     * @param id
     */
    @Update("update room set sumRoom = sumRoom + 1 where id = #{id}")
    void addRoom(int id);


    /**
     * 管理员根据 id 删除房间
     * @param id
     */
    @Update("update room set sumRoom = sumRoom - 1 where id = #{id}")
    void delRoom(int id);


    /**
     * 管理员根据 id 逻辑删除整个房型
     * @param id
     */
    @Update("update room set is_delete = 1 where id = ${id}")
    void deleteRoomType(int id);


    /**
     * 管理员添加新房型
     * @param roomImage
     * @param price
     * @param type
     * @param des
     * @param peopleNumber
     * @param bedNumber
     * @param sumRoom
     */
    @Insert("insert into room (roomImage,price,type,state,des,peopleNumber,bedNumber,sumRoom,reserveRoom,is_delete) values (#{roomImage},#{price},#{type},0,#{des},#{peopleNumber},#{bedNumber},#{sumRoom},0,0)")
    void addRoomType(@Param("roomImage") String roomImage,@Param("price") String price,@Param("type") String type,@Param("des") String des,@Param("peopleNumber") String peopleNumber,@Param("bedNumber") String bedNumber,@Param("sumRoom") String sumRoom);


    /**
     * 管理员修改房间
     * @param id
     * @param roomImage
     * @param price
     * @param type
     * @param des
     * @param peopleNumber
     * @param bedNumber
     * @param sumRoom
     */
    @Update("update room set roomImage = #{roomImage},price = #{price},type = #{type},des = #{des},peopleNumber = #{peopleNumber},bedNumber = #{bedNumber},sumRoom = #{sumRoom} where id = #{id} ")
    void modificationRoom(@Param("id") int id,@Param("roomImage") String roomImage,@Param("price") String price,@Param("type") String type,@Param("des") String des,@Param("peopleNumber") String peopleNumber,@Param("bedNumber") String bedNumber,@Param("sumRoom") String sumRoom);

}
