<%--
  Created by IntelliJ IDEA.
  User: 霍晓龙
  Date: 2022/8/1
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="/css/adminLogin.css" rel="stylesheet">
</head>

<body>

<div id="loginDiv">
    <form action="/login/logAdmin" id="form">
        <h1 id="loginMsg">管理员登录</h1>
        <div class="mag" style="display:inline-block;"><a href="/userLogin.jsp">用户登录</a></div>
        <div id = "errorMsg">${login_msg}</div>
        <p>Username:<input id="username" name="username" type="text"></p>

        <p>Password: <input id="password" name="password" type="password"></p>

        <div id="subDiv">
            <input type="reset" class="button" value="reset">
            <input type="submit" class="button" value="login up">&nbsp;&nbsp;&nbsp;
        </div>
    </form>
</div>

</body>

</html>
