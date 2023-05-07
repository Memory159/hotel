package com.servlet;
import com.alibaba.fastjson.JSON;
import com.bean.BookingList;
import com.service.BookingListService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@WebServlet("/bookingList/*")
public class BookingListServlet extends BaseServlet{
    private BookingListService bookingListService = new BookingListService();
    /**
     * 添加预约信息到我的订单
     * @param req
     * @param res
     * @throws Exception
     */
    public void addInPeople (HttpServletRequest req, HttpServletResponse res) throws Exception{

//        String roomImg = req.getParameter("roomImg");
//        String type = req.getParameter("type");
//        type = new String(type.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
//        String username = req.getParameter("username");
//        username = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
//        String telephone = req.getParameter("telephone");
//        String identity = req.getParameter("identity");
//        String leaveTime = req.getParameter("leaveTime");
//        String bookingTime = req.getParameter("bookingTime");
//        int userId = Integer.parseInt(req.getParameter("userid"));

//        System.out.println(userId);

//        bookingListService.addInPeople(bookingTime,leaveTime,roomImg,type,username,telephone,identity,userId);

//        res.sendRedirect("http://localhost:8080/room/roomOperate");

    }


    /**
     * 查询所有我的订单
     * @param req
     * @param res
     * @throws Exception
     */

    public void myOrder (HttpServletRequest req, HttpServletResponse res) throws Exception{
        int userId = Integer.parseInt(req.getParameter("userid"));
        List<BookingList> bookingLists = bookingListService.selectAll(userId);
        res.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(bookingLists);
        res.getWriter().write(jsonString);
    }


    /**
     * 顾客取消预定
     * @param req
     * @param res
     * @throws Exception
     */
    public void delete (HttpServletRequest req, HttpServletResponse res) throws Exception{
        int id = Integer.parseInt(req.getParameter("id"));
        bookingListService.deleteReserve(id);
        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write("取消预定成功~");
    }


    /**
     * 管理员查询所有顾客的预定信息
     * @param req
     * @param res
     * @throws Exception
     */
    public void selectAllReserve(HttpServletRequest req, HttpServletResponse res) throws Exception{
        List<BookingList> bookingLists = bookingListService.selectAllReserve();
        res.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(bookingLists);
        System.out.println(jsonString);
        res.getWriter().write(jsonString);
    }

    /**
     * 查询相应字段到财务统计
     * @return
     */
    public void selectProperty(HttpServletRequest req, HttpServletResponse res) throws Exception{
        List<BookingList> bookingLists = bookingListService.selectProperty();
        res.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(bookingLists);
        System.out.println(jsonString);
        res.getWriter().write(jsonString);
    }



}
