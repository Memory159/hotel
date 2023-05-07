package com.servlet;

import com.alibaba.fastjson.JSON;
import com.bean.Room;
import com.service.BookingListService;
import com.service.RoomService;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.List;


@WebServlet("/room/*")
public class RoomServlet extends BaseServlet{

    private RoomService serviceRoom = new RoomService();
    private BookingListService bookingListService = new BookingListService();

    /**
     * 房间查询
     * @param req
     * @param res
     * @throws Exception
     */

    public void customerRoomOperate(HttpServletRequest req, HttpServletResponse res) throws Exception{

        // 1、调用serviceRoom完成查询
        List<Room> rooms = serviceRoom.selectAll();
        // 2、传入request域中
        req.setAttribute("rooms",rooms);
        // 3、转发到indexCustomer.jsp中
        req.getRequestDispatcher("/indexCustomer.jsp").forward(req,res);
    }

    /**
     * 房间查询
     * @param req
     * @param res
     * @throws Exception
     */

    public void adminRoomOperate(HttpServletRequest req, HttpServletResponse res) throws Exception{

        // 1、调用serviceRoom完成查询
        List<Room> rooms = serviceRoom.selectAll();
        // 2、传入request域中
        req.setAttribute("rooms",rooms);
        // 3、转发到indexCustomer.jsp中
        req.getRequestDispatcher("/indexAdmin.jsp").forward(req,res);
    }


    /**
     * 根据id查询单个房间
     * @param req
     * @param res
     * @throws Exception
     */
    public void selectById (HttpServletRequest req, HttpServletResponse res) throws Exception{
        int id = Integer.parseInt(req.getParameter("id"));
        Room room = serviceRoom.selectById(id);
        res.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(room);
        res.getWriter().write(jsonString);

    }

    /**
     * 根据 id 修改房间预定的值，每次预定成功房间自增一
     * @param req
     * @param res
     * @throws Exception
     */
    public void reserveRoom(HttpServletRequest req, HttpServletResponse res) throws Exception{

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        // 解决中文乱码问题
        String type = req.getParameter("type");
        type = new String(type.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String customerName = req.getParameter("customerName");
        customerName = new String(customerName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        int id = Integer.parseInt(req.getParameter("id"));
        int userid = Integer.parseInt(req.getParameter("userid"));
        String roomImg = req.getParameter("roomImg");
        String price = req.getParameter("price");
        String telephone = req.getParameter("telephone");
        String identity = req.getParameter("identity");
        String nowTime = req.getParameter("nowTime");
        String leaveTime = req.getParameter("leaveTime");
        String bookingTime = req.getParameter("bookingTime");

        System.out.println(id);
        System.out.println("type = " + type);

        SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();

        System.out.println("获取参数完成");
        System.out.println(id+"房型");
        serviceRoom.updateRoom(id,sqlSession);
        System.out.println("serviceRoot 完成");

        bookingListService.addInPeople(bookingTime,leaveTime,nowTime,roomImg,price,type,customerName,telephone,identity,userid,sqlSession);
        System.out.println("addInPeople 完成");

        res.sendRedirect("http://localhost:8080/room/customerRoomOperate");

    }


    /**
     * 根据输入框搜索查询对应的房间
     * @param req
     * @param res
     * @throws Exception
     */
    public void selectRoom(HttpServletRequest req, HttpServletResponse res) throws Exception{
        // 解决乱码问题: GET
        String value = req.getParameter("value");
        value = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        System.out.println(value);
        List<Room> rooms = serviceRoom.selectRoom(value);
        res.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(rooms);
        res.getWriter().write(jsonString);
    }


    /**
     * 管理员根据 id 增加房间
     * @param req
     * @param res
     * @throws Exception
     */
    public void addRoom(HttpServletRequest req, HttpServletResponse res) throws Exception{
        int id = Integer.parseInt(req.getParameter("id"));
        serviceRoom.addRoom(id);
        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write("增加房间成功");
    }


    /**
     * 管理员根据 id 删除房间
     * @param req
     * @param res
     * @throws Exception
     */
    public void delRoom(HttpServletRequest req, HttpServletResponse res) throws Exception{
        int id = Integer.parseInt(req.getParameter("id"));
        serviceRoom.delRoom(id);
        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write("删除房间成功");
    }

    /**
     * 管理员根据 id 逻辑删除整个房型
     * @param req
     * @param res
     * @throws Exception
     */
    public void deleteRoomType(HttpServletRequest req, HttpServletResponse res) throws Exception{
        int id = Integer.parseInt(req.getParameter("id"));
        serviceRoom.deleteRoomType(id);
        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write("删除成功");
    }


    /**
     * 管理员添加新房型
     * @param req
     * @param res
     * @throws Exception
     */
    public void addRoomType(HttpServletRequest req, HttpServletResponse res) throws Exception{
        // 解决乱码问题 GET
        String type = req.getParameter("type");
        type = new String(type.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String des = req.getParameter("des");
        des = new String(des.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String roomImage = req.getParameter("roomImage");
        String price = req.getParameter("price");
        String peopleNumber = req.getParameter("peopleNumber");
        String bedNumber = req.getParameter("bedNumber");
        String sumRoom = req.getParameter("sumRoom");

        serviceRoom.addRoomType(roomImage,price,type,des,peopleNumber,bedNumber,sumRoom);

        res.sendRedirect("http://localhost:8080/room/adminRoomOperate");
    }

    public void modificationRoom(HttpServletRequest req, HttpServletResponse res) throws Exception{
        // 解决中文乱码问题
        int id = Integer.parseInt(req.getParameter("id"));
        String type = req.getParameter("type");
        type = new String(type.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String des = req.getParameter("des");
        des = new String(des.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String roomImage = req.getParameter("roomImage");
        String price = req.getParameter("price");
        String peopleNumber = req.getParameter("peopleNumber");
        String bedNumber = req.getParameter("bedNumber");
        String sumRoom = req.getParameter("sumRoom");

        serviceRoom.modificationRoom(id,roomImage,price,type,des,peopleNumber,bedNumber,sumRoom);
        res.sendRedirect("http://localhost:8080/room/adminRoomOperate");
    }


    public void moreSelectAll(HttpServletRequest req, HttpServletResponse res) throws Exception{
        String tValue = req.getParameter("tValue");
        tValue = new String(tValue.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String pValue = req.getParameter("pValue");
        pValue = new String(pValue.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String value1 = req.getParameter("value1");
        value1 = new String(value1.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String value2 = req.getParameter("value2");

        List<Room> rooms = serviceRoom.moreSelectAll(tValue, pValue, value1, value2);

        res.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(rooms);
        System.out.println(jsonString);
        res.getWriter().write(jsonString);

    }


}
