<%--
  Created by IntelliJ IDEA.
  User: 霍晓龙
  Date: 2022/8/1
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="/css/index.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/axios/0.18.0/axios.min.js"></script>

</head>

<body class="big-box">
<div class="left-box">
    <div class="customer-box">
        <p class="identity">(管理员)</p>
        <a href="#">${admin.username},欢迎你</a><br>
    </div>
    <div class="list-box">
        <ul>
            <li class="li"><a href="#">首页</a></li>
            <li class="li"><a href="#">个人信息</a></li>
            <li class="li"><a href="#">顾客信息</a></li>
            <li class="li"><a href="#">预定信息</a></li>
            <li class="li"><a href="/indexProperty.jsp">财务统计</a></li>
            <li class="li"><a href="/indexGoods.jsp">商品采购</a></li>
            <li class="li"><a href="#">退出登录</a></li>
        </ul>
    </div>

</div>
<div class="right-bigBox">
    <div class="right-box1">
        <div class="border" id="information">
            <div class="search-box" >
                <input type="text" class="search" placeholder="请输入关键字">
                <button class="valueBox">搜索</button>
            </div>
            <div class="select-opt1">
                <select class="oneValue">
                    <option value="type">房间类型</option>
                    <option value="price">房间价格</option>
                </select>
                <input type="text" class="valueOne" placeholder="请输入关键字">
            </div>
            <div class="select-opt2">
                <select class="twoValue">
                    <option value="peopleNumber">可住人数</option>
                    <option value="bedNumber">床位数</option>
                </select>
                <input type="text" class="valueTwo" placeholder="请输入关键字">
            </div>
            <div class="select-but">
                <button class="valueBox2">搜索</button>
            </div>
            <div class="addNewRoom">
                <a href="/addRoomType.jsp">
                    <button class="addNew">添加新房型</button>
                </a>
            </div>
            <table border="1px" cellspacing="0" width="90%" id="ListAll" style="position: relative">
                <tr class="border-tr1">
                    <th>客房</th>
                    <th>房型</th>
                    <th>可住人数</th>
                    <th>床位数</th>
                    <th>房价</th>
                    <th>剩余</th>
                    <th>增房</th>
                    <th>删房</th>
                    <th>改房</th>
                </tr>

                <c:forEach items="${rooms}" var="room">
                    <tr align="center" class="border-tr2">
                        <td><img src="/imgs/${room.roomImage}" width="200px" height="150px"></td>
                        <td>${room.type}</td>
                        <td>${room.peopleNumber}</td>
                        <td>${room.bedNumber}</td>
                        <td>${room.price}</td>
                        <td>${room.sumRoom - room.reserveRoom} 间</td>
                        <td><button class="add" onclick = "addRoom(${room.id})">增加</button></td>
                        <c:if test="${room.sumRoom - room.reserveRoom == 0}">
                            <td><button class="del" onclick = "delRoom(${room.id})" disabled style="background-color:#aaaaaa;">删除</button></td>
                        </c:if>
                        <c:if test="${room.sumRoom - room.reserveRoom > 0}">
                            <td><button class="del" onclick = "delRoom(${room.id})">删除</button></td>
                        </c:if>
                        <td>
                            <a href="/modificationRoom.jsp?id=${room.id}">
                                <button class="del">修改</button>
                            </a>
                            <button class="cuo" onclick = "cuo(${room.id})">×</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
<script>
    let property = document.querySelector(".list-box").children[0].children[4];
    let goods = document.querySelector(".list-box").children[0].children[5];
    let exit = document.querySelector(".list-box").children[0].children[6];
    let index = document.querySelector(".list-box").children[0].children[0];
    let person = document.querySelector(".list-box").children[0].children[1];
    let customerInformation = document.querySelector(".list-box").children[0].children[2];
    let reserve = document.querySelector(".list-box").children[0].children[3];
    let valueBox = document.querySelector(".valueBox");
    let searchBox = document.querySelector(".search-box");
    let selectOpt1 = document.querySelector(".select-opt1");
    let selectOpt2= document.querySelector(".select-opt2");
    let selectBut = document.querySelector(".select-but");
    let search = document.querySelector(".search");
    let addNewRoom = document.querySelector(".addNewRoom");
    let valueBox2 = document.querySelector(".valueBox2");
    let valueOne = document.querySelector(".valueOne");
    let valueTwo = document.querySelector(".valueTwo");
    let oneValue = document.querySelector(".oneValue");
    let twoValue = document.querySelector(".twoValue")

    // 首页小li
    index.onclick = function () {
        window.location.href = "http://localhost:8080/room/adminRoomOperate";
    }

    // 首页增加房间
    function addRoom(addId){
        axios({
            method:"get",
            url:"http://localhost:8080/room/addRoom?id=" + addId
        }).then(function(resp){
            window.location.href = "http://localhost:8080/room/adminRoomOperate";
            alert(resp.data);
        })
    }

    // 首页删除房间
    function delRoom(delId){
        axios({
            method:"get",
            url:"http://localhost:8080/room/delRoom?id=" + delId
        }).then(function(resp){
            window.location.href = "http://localhost:8080/room/adminRoomOperate";
            alert(resp.data);
        })
    }

    // 首页删除整个房型
    function cuo(deleteRoomTypeId){
        axios({
            method:"get",
            url:"http://localhost:8080/room/deleteRoomType?id=" + deleteRoomTypeId
        }).then(function(resp){
            window.location.href = "http://localhost:8080/room/adminRoomOperate";
            alert(resp.data);
        })
    }


    // 个人信息小li
    person.onclick = function () {
        ListAll.style.border = "none";
        searchBox.style.display = "none";
        selectOpt1.style.display = "none";
        selectOpt2.style.display = "none";
        selectBut.style.display = "none";
        addNewRoom.style.display = "none";
        ListAll.innerHTML = "";
        axios({
            method: "get",
            url: "http://localhost:8080/login/adminInformation?id=" +${admin.id}
        }).then(function (resp) {
            let adm = resp.data
            console.log(adm);
            ListAll.innerHTML =
                `
                <h1>个人信息</h1>
                <a href="/adminInformation.jsp"><button class="revise">修改</button></a>
                <p>用&nbsp;&nbsp;户&nbsp;&nbsp;名 : ` + adm.username + `</p>
                <p>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 : ` + adm.password + `</p>
                `
        })
    }

    // 顾客信息小li
    customerInformation.onclick = function(){
        searchBox.style.display = "none";
        selectOpt1.style.display = "none";
        selectOpt2.style.display = "none";
        selectBut.style.display = "none";
        addNewRoom.style.display = "none";
        ListAll.innerHTML = "";
        axios({
            method:"get",
            url:"http://localhost:8080/login/selectAllCustomer"
        }).then(function(resp){
            let customers = resp.data;
            console.log(customers);
            ListAll.innerHTML =
                `
                <tr class="border-tr1">
                    <th>姓名</th>
                    <th>密码</th>
                    <th>性别</th>
                    <th>电话号</th>
                    <th>身份证号</th>
                    <th>删除</th>
                </tr>
                `
            for (let i = 0; i < customers.length; i++) {
                ListAll.innerHTML +=
                    `
                    <tr align="center" class="border-tr2">
                        <td>` + customers[i].username+ `</td>
                        <td>` + customers[i].password + `</td>
                        <td>` + customers[i].gender + `</td>
                        <td>` + customers[i].telephone + `</td>
                        <td>` + customers[i].identity + `</td>
                        <td><button class="btn" style="width: 70px;height: 30px" onclick="deleteCustomerInformation(` + customers[i].id + `)">删除</button></td>
                    </tr>
                    `
            }
        })
    }

    // 删除顾客信息小li
    function deleteCustomerInformation(customerId){
        axios({
            method:"get",
            url:"http://localhost:8080/login/deleteCustomerInformation?id="+customerId
        }).then(function(resp){
            redraw_information();
            alert(resp.data);
        })
    }

    // 删除之后对顾客信息页面进行重绘
    function redraw_information(){
        ListAll.innerHTML = "";
        axios({
            method:"get",
            url:"http://localhost:8080/login/selectAllCustomer"
        }).then(function(resp){
            let customers = resp.data;
            console.log(customers);
            ListAll.innerHTML =
                `
                <tr class="border-tr1">
                    <th>姓名</th>
                    <th>密码</th>
                    <th>性别</th>
                    <th>电话号</th>
                    <th>身份证号</th>
                    <th>删除</th>
                </tr>
                `
            for (let i = 0; i < customers.length; i++) {
                ListAll.innerHTML +=
                    `
                    <tr align="center" class="border-tr2">
                        <td>` + customers[i].username+ `</td>
                        <td>` + customers[i].password + `</td>
                        <td>` + customers[i].gender + `</td>
                        <td>` + customers[i].telephone + `</td>
                        <td>` + customers[i].identity + `</td>
                        <td><button class="btn" style="width: 70px;height: 30px" onclick="deleteCustomerInformation(` + customers[i].id + `)">删除</button></td>
                    </tr>
                    `
            }
            ListAll.innerHTML += `<hr/>`
        })
    }


    // 预定信息小li
    reserve.onclick = function(){
        searchBox.style.display = "none";
        selectOpt1.style.display = "none";
        selectOpt2.style.display = "none";
        selectBut.style.display = "none";
        addNewRoom.style.display = "none";
        ListAll.innerHTML = "";
        axios({
            method:"get",
            url:"http://localhost:8080/bookingList/selectAllReserve"
        }).then(function(resp){
            let bookingLists = resp.data;
            ListAll.innerHTML =
                `
                <tr class="border-tr1">
                    <th>用户名</th>
                    <th>预定时间</th>
                    <th>离店时间</th>
                    <th>顾客名</th>
                    <th>电话号</th>
                    <th>身份证号</th>
                </tr>
                `
            for (let i = 0; i < bookingLists.length; i++) {
                ListAll.innerHTML +=
                    `
                    <tr align="center" class="border-tr2">
                        <td>` + bookingLists[i].username + `</td>
                        <td>` + bookingLists[i].bookingTime + `</td>
                        <td>` + bookingLists[i].leaveTime + `</td>
                        <td>` + bookingLists[i].customerName + `</td>
                        <td>` + bookingLists[i].telephone + `</td>
                        <td>` + bookingLists[i].identity + `</td>
                    </tr>
                    `
            }
            ListAll.innerHTML += `<hr/>`
        })

    }


    // 搜索房间功能
    valueBox.onclick = function () {
        console.log("获取到了")
        let value = search.value
        ListAll.innerHTML = "";
        axios({
            method: 'get',
            url: "http://localhost:8080/room/selectRoom?value=" + value
        }).then(function (resp) {
            let rooms = resp.data;
            console.log(rooms);
            ListAll.innerHTML =
                `
                <tr class="border-tr1">
                    <th>客房</th>
                    <th>房型</th>
                    <th>可住人数</th>
                    <th>床位数</th>
                    <th>房价</th>
                    <th>剩余</th>
                    <th>预定</th>
                </tr>
                `
            for (let i = 0; i < rooms.length; i++) {
                let state = (rooms[i].sumRoom - rooms[i].reserveRoom) == 0 ? `<td><button class="btn" style="background-color: #cccccc; cursor: pointer" disabled>`+"已满房"+`</button></td>` : `<td><a href="/reserve.jsp?id=`+rooms[i].id+`"><button class="btn" style="cursor: pointer">`+'预定'+`</button></a></td>`
                ListAll.innerHTML +=
                    `
                    <tr align="center" class="border-tr2">
                    <td><img src="/imgs/` + rooms[i].roomImage + `" width="200px" height="150px"></td>
                    <td>` + rooms[i].type + `</td>
                    <td>` + rooms[i].peopleNumber + `</td>
                    <td>` + rooms[i].bedNumber + `</td>
                    <td>` + rooms[i].price + `</td>
                    <td>` + (rooms[i].sumRoom - rooms[i].reserveRoom)+ `</td>
                    `+state+`
                    </tr>
                    `
            }
            ListAll.innerHTML += `<hr/>`

        })
    }

    // 多条件查询搜索功能
    valueBox2.onclick = function () {
        console.log("获取到了")
        let tValue = oneValue.value;
        let pValue = twoValue.value;
        let value1 = valueOne.value;
        let value2 = valueTwo.value;
        ListAll.innerHTML = "";
        axios({
            method: 'get',
            url: "http://localhost:8080/room/moreSelectAll?tValue="+tValue+"&pValue="+pValue+"&value1="+value1+"&value2="+value2
        }).then(function (resp) {
            let rooms = resp.data;
            console.log(rooms);
            ListAll.innerHTML =
                `
                <tr class="border-tr1">
                    <th>客房</th>
                    <th>房型</th>
                    <th>可住人数</th>
                    <th>床位数</th>
                    <th>房价</th>
                    <th>剩余</th>
                    <th>预定</th>
                </tr>
                `
            for (let i = 0; i < rooms.length; i++) {
                let state = (rooms[i].sumRoom - rooms[i].reserveRoom) == 0 ? `<td><button class="btn" style="background-color: #cccccc; cursor: pointer" disabled>`+"已满房"+`</button></td>` : `<td><a href="/reserve.jsp?id=`+rooms[i].id+`"><button class="btn" style="cursor: pointer">`+'预定'+`</button></a></td>`
                ListAll.innerHTML +=
                    `
                    <tr align="center" class="border-tr2">
                    <td><img src="/imgs/` + rooms[i].roomImage + `" width="200px" height="150px"></td>
                    <td>` + rooms[i].type + `</td>
                    <td>` + rooms[i].peopleNumber + `</td>
                    <td>` + rooms[i].bedNumber + `</td>
                    <td>` + rooms[i].price + `</td>
                    <td>` + (rooms[i].sumRoom - rooms[i].reserveRoom)+ `</td>
                    `+state+`
                    </tr>
                    `
            }
            ListAll.innerHTML += `<hr/>`

        })
    }

    // 退出登录小li
    exit.onclick = function(){
        var result = confirm("确定要退出吗")
        if(result){
            window.location.href = "http://localhost:8080/login/adminLogOut"
        }
    }
</script>

</html>
