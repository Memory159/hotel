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
            let nan = document.getElementById("nan");
            let nv = document.getElementById("nv");
            let name1,pawd1,tele1,iden1,sex1;
            axios({
                method: 'get',
                url: "http://localhost:8080/login/customerInformation?id=" +${customer.id}
            }).then(function (resp) {
                let information = resp.data;
                if (information.gender == nan.value) {
                    nan.checked = "checked";
                } else if (information.gender == nv.value) {
                    nv.checked = "checked";
                }
                console.log(information);
                reserve.children[1].innerHTML = `用&nbsp;&nbsp;户&nbsp;&nbsp;名 : <input type="text" value="` + information.username + `"> `;
                reserve.children[2].innerHTML = `密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 : <input type="text" value="` + information.password + `">`;
                reserve.children[3].innerHTML = `电&nbsp;&nbsp;话&nbsp;&nbsp;号 : <input type="text" value="` + information.telephone + `">`;
                reserve.children[4].innerHTML = `身份证号 : <input type="text" value="` + information.identity + `">`;
                name1 = information.username;
                pawd1 = information.password;
                tele1 = information.telephone;
                iden1 = information.identity;
                sex1= information.gender;

            })

            let btn1 = document.getElementById("btn1");
            let btn2 = document.getElementById("btn2");
            btn1.onclick = function () {
                let username = reserve.children[1].children[0].value;
                let password = reserve.children[2].children[0].value;
                let telephone = reserve.children[3].children[0].value;
                let identity = reserve.children[4].children[0].value;
                let gender = nan.checked ? reserve.children[5].children[0].value : reserve.children[5].children[2].value;
                if(username == name1 && password == pawd1 && telephone == tele1 && identity == iden1 && gender == sex1){
                    alert("您未作出修改，修改失败")
                }else if(username != "" && password != "" && telephone != "" && identity != "" && gender != ""){
                    window.location.href = "http://localhost:8080/login/customerRevise?username=" + username + "&password=" + password + "&telephone=" + telephone + "&identity=" + identity + "&gender=" + gender + "&id=" +${customer.id};
                    alert("修改成功");
                }else {
                    alert("修改失败,请将信息填写完整")
                }



            }

            btn2.onclick = function () {
                window.location.href = "http://localhost:8080/room/customerRoomOperate"
            }
        }
    </script>
</head>

<body>
<div class="big-box">
    <h1>修改信息</h1>

    <p>用&nbsp;&nbsp;户&nbsp;&nbsp;名 : <input type="text"></p>
    <p>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 : <input type="password"></p>
    <p>电&nbsp;&nbsp;话&nbsp;&nbsp;号 : <input type="text"></p>
    <p>身份证号 : <input type="text"></p>
    <p>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别 : <input type="radio" name="gender" id="nan" value="男"> <label
            for="nan" class="nan">男</label>
        <input type="radio" name="gender" id="nv" value="女"> <label for="nv">女</label>
    </p>
    <div id = "errorMsg">${register_msg}</div>
    <button id="btn1">确认修改</button>
    <button class="btn" id="btn2">取消修改</button>
</div>
</body>

</html>
