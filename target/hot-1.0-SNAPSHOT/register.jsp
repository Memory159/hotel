<%--
  Created by IntelliJ IDEA.
  User: 霍晓龙
  Date: 2022/8/2
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="/css/register.css" rel="stylesheet">
</head>

<body>
<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="/userLogin.jsp" class="log">登录</a>
    </div>
    <form id="reg-form" action="/login/registerCustomer" method="post">

        <table>

            <tr>
                <td class="big">用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg">${register_msg}</span>

                </td>

            </tr>

            <tr>
                <td class="big">密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>

            <tr>
                <td class="big">电话号</td>
                <td class="inputs">
                    <input name="telephone" type="text" id="telephone">
                    <br>
                    <span id="telephone_err" class="err_msg" style="display: none">电话号格式有误</span>
                </td>
            </tr>


            <tr>
                <td class="big">身份证号</td>
                <td class="inputs">
                    <input name="identity" type="text" id="identity">
                    <br>
                    <span id="identity_err" class="err_msg" style="display: none">身份证号格式有误</span>
                </td>
            </tr>

            <tr>
                <td class="big">性别</td>
                <td class="gender">
                    <input type="radio" name="gender" id="nan" value="男"> <label for="nan" class="nan">男</label>
                    <input type="radio" name="gender" id="nv" value="女"> <label for="nv">女</label>
                </td>
            </tr>

            <tr>
                <td class="big">验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="/login/CheckCode">
                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>


<script>
    /**
     * 验证码功能
     */
    //  给看不清添加点击事件
    document.getElementById("changeImg").onclick = function(){
        document.getElementById("checkCodeImg").src = "/login/CheckCode?"+ new Date().getMilliseconds();
    }
    // 给图片添加点击事件
    document.getElementById("checkCodeImg").onclick = function(){
        this.src = "/login/CheckCode?"+new Date().getMilliseconds();
    }

</script>

</body>

</html>
