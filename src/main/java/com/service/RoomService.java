package com.service;

import com.bean.Room;
import com.mapper.RoomMapper;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class RoomService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     * @return
     */

    public List<Room> selectAll(){

        SqlSession sqlSession = factory.openSession();

        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);

        List<Room> rooms = mapper.selectAll();

        sqlSession.close();

        return rooms;
    }

    /**
     * 根据id查询单个房间
     * @param roomId
     * @return
     */
    public Room selectById(int roomId){
        SqlSession sqlSession = factory.openSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        Room room = mapper.selectById(roomId);
        sqlSession.close();
        return room;
    }



    /**
     * 根据 id 修改房间预定的值，每次预定成功房间自增一
     * @param id
     */

    public void updateRoom(int id,SqlSession sqlSession){
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        mapper.updateRoom(id);
    }



    /**
     * 根据输入框搜索查询对应的房间
     * @param value
     */
    public List<Room> selectRoom(String value){
        SqlSession sqlSession = factory.openSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        List<Room> rooms = mapper.selectRoom(value);
        sqlSession.close();
        return rooms;
    }


    /**
     *管理员根据 id 增加房间
     * @param id
     */
    public void addRoom(int id){
        SqlSession sqlSession = factory.openSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        mapper.addRoom(id);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 管理员根据 id 删除房间
     * @param id
     */
    public void delRoom(int id){
        SqlSession sqlSession = factory.openSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        mapper.delRoom(id);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 管理员根据 id 逻辑删除整个房型
     * @param id
     */
    public void deleteRoomType(int id){
        SqlSession sqlSession = factory.openSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        mapper.deleteRoomType(id);
        sqlSession.commit();
        sqlSession.close();
    }


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
    public void addRoomType(String roomImage, String price, String type, String des,String peopleNumber, String bedNumber,String sumRoom){
        SqlSession sqlSession = factory.openSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        mapper.addRoomType(roomImage,price,type,des,peopleNumber,bedNumber,sumRoom);
        sqlSession.commit();
        sqlSession.close();
    }


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
    public void modificationRoom(int id,String roomImage,String price,String type,String des,String peopleNumber,String bedNumber,String sumRoom){
        SqlSession sqlSession = factory.openSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        mapper.modificationRoom(id,roomImage,price,type,des,peopleNumber,bedNumber,sumRoom);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 多条件查询搜索框
     * @param tValue
     * @param pValue
     * @param value1
     * @param value2
     * @return
     */
    public List<Room> moreSelectAll(@Param("tValue") String tValue,@Param("pValue")String pValue,@Param("value1")String value1,@Param("value2")String value2){
        SqlSession sqlSession = factory.openSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        List<Room> rooms = mapper.moreSelectAll(tValue, pValue, value1, value2);
        sqlSession.close();
        return rooms;
    }



}
