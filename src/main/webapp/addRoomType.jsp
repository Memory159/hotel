<%--
  Created by IntelliJ IDEA.
  User: 霍晓龙
  Date: 2022/8/12
  Time: 21:26
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
    <link rel="stylesheet" href="css/addRoomType.css">
</head>

<body>
<div class="big-box">
    <h1>添加房型</h1>
    <p>房间图片 : <input type="text"></p>
    <p>房间价格 : <input type="text"></p>
    <p>房间类型 : <input type="text"></p>
    <p>房间描述 : <input type="text"></p>
    <p>可住人数 : <input type="text"></p>
    <p>床&nbsp; 位 &nbsp;数 : <input type="text"></p>
    <p>房间总数 : <input type="text"></p>
    <button class="btn1">确认添加</button><button class="btn2" >取消添加</button>
</div>
</body>
<script>
    let btn1 = document.querySelector(".btn1");
    let btn2 = document.querySelector(".btn2");
    let bigBox = document.querySelector(".big-box");
    btn1.onclick = function(){
        let roomImage = bigBox.children[1].children[0].value;
        let price = bigBox.children[2].children[0].value;
        let type = bigBox.children[3].children[0].value;
        let des = bigBox.children[4].children[0].value;
        let peopleNumber = bigBox.children[5].children[0].value;
        let bedNumber = bigBox.children[6].children[0].value;
        let sumRoom = bigBox.children[7].children[0].value;

        if(roomImage != "" && price != "" && type != "" && des != "" && peopleNumber != "" && bedNumber != "" && sumRoom != ""){
            window.location.href = "http://localhost:8080/room/addRoomType?roomImage="+roomImage+"&price="+price+"&type="+type+"&des="+des+"&peopleNumber="+peopleNumber+"&bedNumber="+bedNumber+"&sumRoom="+sumRoom;
            alert("添加成功")
        }else {
            alert("添加失败,请将信息填写完整")
        }

    }
    btn2.onclick = function(){
        window.location.href = "http://localhost:8080/room/adminRoomOperate";
    }


</script>

</html>