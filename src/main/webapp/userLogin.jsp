<%--
  Created by IntelliJ IDEA.
  User: 霍晓龙
  Date: 2022/7/31
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% request.setCharacterEncoding("GBK");%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link rel="stylesheet" href="/css/userLogin.css">
</head>

<body>
<div id="loginDiv">
    <form action="/login/logCustomer" id="form">
        <h1 id="loginMsg">用户登录</h1>
        <div class="mag" style="display:inline-block;"><a href="/adminLogin.jsp">管理员登录</a></div>
        <div id = "errorMsg">${login_msg} ${register_msg}</div>

        <p>Username:<input id="username" name="username" type="text"></p>

        <p>Password: <input id="password" name="password" type="password"></p>

        <div id="subDiv">
            <input type="reset" class="button" value="reset">
            <input type="submit" class="button" value="login up">&nbsp;&nbsp;&nbsp;
            <a href="/register.jsp">没有账号？点击注册</a>
        </div>
    </form>

</div>


</body>

<script>

</script>

</html>