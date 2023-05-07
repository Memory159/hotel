<%--
  Created by IntelliJ IDEA.
  User: 霍晓龙
  Date: 2022/8/13
  Time: 14:30
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
    <link rel="stylesheet" href="css/modificationRoom.css">
    <script src="js/axios-0.18.0.js"></script>
    <script>
        window.onload = function(){
            let modificationRoomId = window.location.search.substring(4);
            let bigBox = document.querySelector(".big-box");
            axios({
                method:"get",
                url:"http://localhost:8080/room/selectById?id=" + modificationRoomId
            }).then(function(resp){
                let room = resp.data;
                bigBox.children[1].innerHTML = `房间图片 : <input type="text" value="`+ room.roomImage +`">`;
                bigBox.children[2].innerHTML = `房间类型 : <input type="text" value="`+ room.type +`">`;
                bigBox.children[3].innerHTML = `房间价格 : <input type="text" value="`+ room.price +`">`;
                bigBox.children[4].innerHTML = `房间描述 : <input type="text" value="`+ room.des +`">`;
                bigBox.children[5].innerHTML = `可住人数 : <input type="text" value="`+ room.peopleNumber +`">`;
                bigBox.children[6].innerHTML = `床&nbsp; 位 &nbsp;数 : <input type="text" value="`+ room.bedNumber +`">`;
                bigBox.children[7].innerHTML = `房间总数 : <input type="text" value="`+ room.sumRoom +`">`;
            })

            let btn1 = document.querySelector(".btn1");
            let btn2 = document.querySelector(".btn2");
            btn1.onclick = function(){
                let roomImage = bigBox.children[1].children[0].value;
                let type = bigBox.children[2].children[0].value;
                let price = bigBox.children[3].children[0].value;
                let des = bigBox.children[4].children[0].value;
                let peopleNumber = bigBox.children[5].children[0].value;
                let bedNumber = bigBox.children[6].children[0].value;
                let sumRoom = bigBox.children[7].children[0].value;

                if(roomImage != "" && type != "" && price != "" && des != "" && peopleNumber != "" && bedNumber != "" && sumRoom != ""){
                    window.location.href = "http://localhost:8080/room/modificationRoom?roomImage="+roomImage+"&type="+type+"&price="+price+"&des="+des+"&peopleNumber="+peopleNumber+"&bedNumber="+bedNumber+"&sumRoom="+sumRoom+"&id="+modificationRoomId;
                    alert("修改成功");
                }else {
                    alert("修改失败,请将信息填写完整")
                }

            }

            btn2.onclick = function(){
                window.location.href = "http://localhost:8080/room/adminRoomOperate"
            }

        }

    </script>
</head>

<body>
<div class="big-box">
    <h1>修改房间</h1>
    <p>房间图片 : <input type="text"></p>
    <p>房间类型 : <input type="text"></p>
    <p>房间价格 : <input type="text"></p>
    <p>房间描述 : <input type="text"></p>
    <p>可住人数 : <input type="text"></p>
    <p>床&nbsp; 位 &nbsp;数 : <input type="text"></p>
    <p>房间总数 : <input type="text"></p>
    <button class="btn1">确认修改</button><button class="btn2">取消修改</button>
</div>
</body>

</html>
