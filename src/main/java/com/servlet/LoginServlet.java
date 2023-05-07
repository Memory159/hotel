package com.servlet;

import com.alibaba.fastjson.JSON;
import com.bean.Admin;
import com.bean.Customer;
import com.service.AdminService;
import com.service.CustomerService;
import com.util.CheckCodeUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/login/*")
public class LoginServlet extends BaseServlet {

    private CustomerService serviceCustomer = new CustomerService();
    private AdminService serviceAdmin = new AdminService();

    /**
     * 顾客/用户登录
     *
     * @param req
     * @param res
     * @throws Exception
     */
    public void logCustomer(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // 解决 get 中文乱码问题
        String username = req.getParameter("username");
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        // 获取用户名和密码
        String password = req.getParameter("password");
        // 调用 service 注册
        Customer customer = serviceCustomer.login(username, password);
        if (customer != null) {
            // 将登录成功后的user对象存储到session中
            HttpSession session = req.getSession();
            session.setAttribute("customer", customer);
            res.sendRedirect("/room/customerRoomOperate");
        } else {
            req.setAttribute("login_msg", "用户名或密码错误");
            req.getRequestDispatcher("/userLogin.jsp").forward(req, res);
        }


    }

    /**
     * 管理员登录
     *
     * @param req
     * @param res
     * @throws Exception
     */

    public void logAdmin(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // 获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 service 注册
        Admin admin = serviceAdmin.login(username, password);

        if (admin != null) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", admin);
            res.sendRedirect("/room/adminRoomOperate");
        } else {
            req.setAttribute("login_msg", "用户名或密码错误");
            req.getRequestDispatcher("/adminLogin.jsp").forward(req, res);
        }
    }

    /**
     * 顾客/用户注册
     *
     * @param req
     * @param res
     * @throws Exception
     */

    public void registerCustomer(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // 解决乱码问题: POST
        req.setCharacterEncoding("UTF-8"); // 设置字符输入流的编码
        // 解决乱码问题: GET
        // String username = req.getParameter("username");
        // new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        // 获取用户名、密码、性别、电话号、身份证号
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String telephone = req.getParameter("telephone");
        String identity = req.getParameter("identity");

        // 调用 service 注册
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setGender(gender);
        customer.setTelephone(telephone);
        customer.setIdentity(identity);

        // 获取用户输入的验证码
        String checkCode = req.getParameter("checkCode");

        // 获取程序生成的验证码，从 Session 中获取
        HttpSession session = req.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");

        // 比对客户输入的验证码和程序生成的验证码
        if (!checkCodeGen.equalsIgnoreCase(checkCode)) { // 不相等时，不允许注册，直接 return ，如果相等，向下执行、
            // 如果比对不成功，返回到注册页面
            req.setAttribute("register_msg", "验证码错误");
            req.getRequestDispatcher("/register.jsp").forward(req, res);
            // 不允许注册
            return;
        }
        boolean flag = serviceCustomer.register(customer);

        //  判断注册成功与否
        if (flag && username != "" && password != "" && telephone != "" && identity != "" && gender != "") {
            // 注册成功，跳转登录页面
            req.setAttribute("register_msg", "注册成功，请登录");
            req.getRequestDispatcher("/userLogin.jsp").forward(req, res);
        } else {
            // 注册失败，跳转注册页面
            req.setAttribute("register_msg", "用户名已存在或者信息没有全部填写");
            req.getRequestDispatcher("/register.jsp").forward(req, res);
        }
    }

    /**
     * 顾客/用户注册时生成验证码
     *
     * @param req
     * @param res
     * @throws Exception
     */

    public void CheckCode(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // 生成验证码
        ServletOutputStream os = res.getOutputStream(); // res 的字节输出流
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);

        // 存入 Session 中
        HttpSession session = req.getSession();
        session.setAttribute("checkCodeGen", checkCode);


    }


    /**
     * 查询顾客的个人信息
     *
     * @param req
     * @param res
     * @throws Exception
     */
    public void customerInformation(HttpServletRequest req, HttpServletResponse res) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = serviceCustomer.selectAll(id);
        res.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(customer);
        res.getWriter().write(jsonString);
    }

    /**
     * 查询管理员的个人信息
     *
     * @param req
     * @param res
     * @throws Exception
     */
    public void adminInformation(HttpServletRequest req, HttpServletResponse res) throws Exception {
        int id = Integer.parseInt(req.getParameter("id"));
        Admin admin = serviceAdmin.selectAll(id);
        res.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(admin);
        res.getWriter().write(jsonString);
    }



    /**
     * 修改顾客个人信息
     *
     * @param req
     * @param res
     * @throws Exception
     */
    public void customerRevise(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // 解决乱码问题: GET
        String gender = req.getParameter("gender");
        gender = new String(gender.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        String username = req.getParameter("username");
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = req.getParameter("password");
        String telephone = req.getParameter("telephone");
        String identity = req.getParameter("identity");
        int Id = Integer.parseInt(req.getParameter("id"));

        serviceCustomer.revise(username, password, telephone, identity, gender, Id);

        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write("修改成功~");
        res.sendRedirect("http://localhost:8080/userLogin.jsp");
    }


    /**
     * 修改顾客个人信息
     * @param req
     * @param res
     * @throws Exception
     */
    public void adminRevise(HttpServletRequest req, HttpServletResponse res) throws Exception {

        // 解决乱码问题: GET
        String username = req.getParameter("username");
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = req.getParameter("password");
        int Id = Integer.parseInt(req.getParameter("id"));

        serviceAdmin.revise(username,password,Id);

        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write("修改成功~");
        res.sendRedirect("http://localhost:8080/adminLogin.jsp");
    }


    /**
     * 管理员查询所有顾客信息
     * @param req
     * @param res
     * @throws Exception
     */
    public void selectAllCustomer(HttpServletRequest req, HttpServletResponse res) throws Exception {
        List<Customer> customers = serviceCustomer.selectAllCustomer();
        res.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(customers);
        res.getWriter().write(jsonString);
    }


    /**
     * 逻辑删除顾客全部信息
     * @param req
     * @param res
     * @throws Exception
     */
    public void deleteCustomerInformation(HttpServletRequest req, HttpServletResponse res) throws Exception{
        int id = Integer.parseInt(req.getParameter("id"));
        serviceCustomer.deleteCustomerInformation(id);
        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write("删除成功~");
    }


    /**
     * 顾客退出登录
     * @param req
     * @param res
     * @throws Exception
     */
    public void customerLogOut(HttpServletRequest req, HttpServletResponse res) throws Exception{
//        System.out.println(req.getSession().getAttribute("customer").toString());
        req.getSession().removeAttribute("customer");
        res.sendRedirect("/userLogin.jsp");
    }


    /**
     * 管理员退出登录
     * @param req
     * @param res
     * @throws Exception
     */
    public void adminLogOut(HttpServletRequest req, HttpServletResponse res) throws Exception{
//        System.out.println(req.getSession().getAttribute("admin").toString());
        req.getSession().removeAttribute("admin");
        res.sendRedirect("/adminLogin.jsp");
    }



}
