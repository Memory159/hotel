<%--
  Created by IntelliJ IDEA.
  User: 霍晓龙
  Date: 2022/8/8
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/information.css">
    <script src="https://cdn.staticfile.org/axios/0.18.0/axios.min.js"></script>
    <script>
        window.onload = () => {
            let reserve = document.querySelector(".big-box");
            var name1,pasd1;
            axios({
                method: 'get',
                url: "http://localhost:8080/login/adminInformation?id=" +${admin.id}
            }).then(function (resp) {
                let information = resp.data;
                console.log(information);
                reserve.children[1].innerHTML = `用&nbsp;&nbsp;户&nbsp;&nbsp;名 : <input type="text" value="` + information.username + `"> `;
                reserve.children[2].innerHTML = `密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 : <input type="text" value="` + information.password + `">`;
                name1 = information.username;
                pasd1 = information.password;
            })

            let btn1 = document.getElementById("btn1");
            btn1.onclick = function () {
                let username = reserve.children[1].children[0].value;
                let password = reserve.children[2].children[0].value;
                if(username == name1 && password == pasd1){
                    alert("您未作出修改，修改失败")
                }else if(username != "" && password != ""){
                    window.location.href = "http://localhost:8080/login/adminRevise?username=" + username + "&password=" + password + "&id=" +${admin.id};
                    alert("修改成功");
                }else {
                    alert("修改失败,请将信息填写完整")
                }

            }
        }
    </script>
</head>

<body>
<div class="big-box">
    <h1>修改信息</h1>
    <p>用&nbsp;&nbsp;户&nbsp;&nbsp;名 : <input type="text"></p>
    <p>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 : <input type="password"></p>
    <button id="btn1">确认修改</button>
    <button class="btn"  onclick="javascript:history.back(-1);">取消修改</button>
</div>
</body>

</html>
