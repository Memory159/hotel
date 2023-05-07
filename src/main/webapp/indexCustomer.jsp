<%@ page import="org.w3c.dom.Element" %><%--
  Created by IntelliJ IDEA.
  User: 霍晓龙
  Date: 2022/7/31
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
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
        <a href="#">${customer.username},欢迎你</a><br>
    </div>
    <div class="list-box">
        <ul>
            <li class="li"><a href="#">首页</a></li>
            <li class="li"><a href="#">我的订单</a></li>
            <li class="li"><a href="#">个人信息</a></li>
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
            <table border="1px" cellspacing="0" width="90%" id="ListAll">
                <tr class="border-tr1">
                    <th>客房</th>
                    <th>房型</th>
                    <th>可住人数</th>
                    <th>床位数</th>
                    <th>房价</th>
                    <th>剩余</th>
                    <th>预定</th>
                </tr>

                <c:forEach items="${rooms}" var="room">
                    <tr align="center" class="border-tr2">
                        <td><img src="/imgs/${room.roomImage}" width="200px" height="150px"></td>
                        <td>${room.type}</td>
                        <td>${room.peopleNumber}</td>
                        <td>${room.bedNumber}</td>
                        <td>${room.price}</td>
                        <td>${room.sumRoom - room.reserveRoom} 间</td>
                        <c:if test="${room.sumRoom - room.reserveRoom == 0}">
                            <td><a href="/reserve.jsp?id=${room.id}">
                                <button class="btn" style="background-color:#ccc; cursor: pointer" disabled>已满房</button>
                            </a></td>
                        </c:if>
                        <c:if test="${room.sumRoom - room.reserveRoom != 0}">
                            <td><a href="/reserve.jsp?id=${room.id}">
                                <button class="btn" style="cursor: pointer">预定</button>
                            </a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>

<script>
    let li = document.querySelectorAll(".li");
    for (var i = 0; i < li.length; i++) {
        li[i].onmouseover = function () {
            for (var i = 0; i < li.length; i++) {
                li[i].style.backgroundColor = '';
            }
            this.style.backgroundColor = "#2f4050";
        }
    }

    /**
     * 我的订单
     * @type {Element}
     */
    let index = document.querySelector(".list-box").children[0].children[0];
    let buy = document.querySelector(".list-box").children[0].children[1];
    let person = document.querySelector(".list-box").children[0].children[2];
    let exit = document.querySelector(".list-box").children[0].children[3];
    let ListAll = document.getElementById("ListAll");
    let information = document.getElementById("information")
    let search = document.querySelector(".search");
    let valueBox = document.querySelector(".valueBox");
    let searchBox = document.querySelector(".search-box");
    let selectOpt1 = document.querySelector(".select-opt1");
    let selectOpt2= document.querySelector(".select-opt2");
    let selectBut = document.querySelector(".select-but");
    let valueBox2 = document.querySelector(".valueBox2");
    let valueOne = document.querySelector(".valueOne");
    let valueTwo = document.querySelector(".valueTwo");
    let oneValue = document.querySelector(".oneValue");
    let twoValue = document.querySelector(".twoValue")

    // 我的订单小li
    buy.onclick = function () {
        searchBox.style.display = "none";
        selectOpt1.style.display = "none";
        selectOpt2.style.display = "none";
        selectBut.style.display = "none";
        ListAll.innerHTML = ''
        axios({
            method: "get",
            url: "http://localhost:8080/bookingList/myOrder?userid=" +${customer.id}
        }).then(function (resp) {
            let bookingLists = resp.data
            console.log(bookingLists);
            ListAll.innerHTML =
                `
                <tr class="border-tr1">
                    <th>房型图片</th>
                    <th>房型</th>
                    <th>入住人</th>
                    <th>手机号</th>
                    <th>身份证号</th>
                    <th>预定时间</th>
                    <th>离开时间</th>
                    <th>取消预订</th>
                </tr>
                `
            for (let i = 0; i < bookingLists.length; i++) {
                let state = new Date().getTime() > new Date(bookingLists[i].leaveTime).getTime() ? `<td><button class="btn"  style="cursor: pointer;background-color: #ddd" onclick="alert('下次注意！')">已超时</button></td>` : `<td><button class="btn" style="cursor: pointer" onclick="log_delete(` + bookingLists[i].id + `)">取消预定</button></td>`
                ListAll.innerHTML +=
                    `
                    <tr align="center" class="border-tr2">
                        <td><img src="` + bookingLists[i].roomImg + `" width="200px" height="150px"></td>
                        <td>` + bookingLists[i].type + `</td>
                        <td>` + bookingLists[i].customerName + `</td>
                        <td>` + bookingLists[i].telephone + `</td>
                        <td>` + bookingLists[i].identity + `</td>
                        <td>` + bookingLists[i].bookingTime + `</td>
                        <td>` + bookingLists[i].leaveTime + `</td>
                        `+state+`
                    </tr>
                    `
            }
            ListAll.innerHTML += `<hr/>`
        })
    }


    //逻辑删除预定记录
    function log_delete(roomId) {
        axios({
            method: 'get',
            url: 'http://localhost:8080/bookingList/delete?id=' + roomId
        }).then(function (resp) {
            redraw_order();
            alert(resp.data);
        })
    }


    //逻辑删除之后进行页面重绘
    function redraw_order() {
        ListAll.innerHTML = ''
        axios({
            method: "get",
            url: "http://localhost:8080/bookingList/myOrder?userid=" +${customer.id}
        }).then(function (resp) {
            let bookingLists = resp.data
            console.log(bookingLists);
            ListAll.innerHTML =
                `
                <tr class="border-tr1">
                    <th>房型图片</th>
                    <th>房型</th>
                    <th>入住人</th>
                    <th>手机号</th>
                    <th>身份证号</th>
                    <th>预定时间</th>
                    <th>离开时间</th>
                    <th>取消预订</th>
                </tr>
                `
            for (let i = 0; i < bookingLists.length; i++) {
                let state = new Date().getTime() > new Date(bookingLists[i].leaveTime).getTime() ? `<td><button class="btn"  style="cursor: pointer;background-color: #ddd" onclick="alert('下次注意！')">已超时</button></td>` : `<td><button class="btn" style="cursor: pointer" onclick="log_delete(` + bookingLists[i].id + `)">取消预定</button></td>`
                ListAll.innerHTML +=
                    `
                    <tr align="center" class="border-tr2">
                        <td><img src="` + bookingLists[i].roomImg + `" width="200px" height="150px"></td>
                        <td>` + bookingLists[i].type + `</td>
                        <td>` + bookingLists[i].username + `</td>
                        <td>` + bookingLists[i].telephone + `</td>
                        <td>` + bookingLists[i].identity + `</td>
                        <td>` + bookingLists[i].bookingTime + `</td>
                        <td>` + bookingLists[i].leaveTime + `</td>
                        `+state+`
                    </tr>
                    `
            }
            ListAll.innerHTML += `<hr/>`
        })
    }


    // 个人信息小li
    person.onclick = function () {
        this.style.backgroundColor = "#2f4050";
        ListAll.style.border = "none";
        searchBox.style.display = "none";
        selectOpt1.style.display = "none";
        selectOpt2.style.display = "none";
        selectBut.style.display = "none";
        ListAll.innerHTML = "";
        axios({
            method: "get",
            url: "http://localhost:8080/login/customerInformation?id=" +${customer.id}
        }).then(function (resp) {
            let cust = resp.data
            console.log(cust);
            ListAll.innerHTML =
                `
                <h1>个人信息</h1>
                <a href="/customerInformation.jsp"><button class="revise">修改</button></a>
                <p>用&nbsp;&nbsp;户&nbsp;&nbsp;名 : ` + cust.username + `</p>
                <p>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 : ` + cust.password + `</p>
                <p>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别 : ` + cust.gender + `</p>
                <p>电&nbsp;&nbsp;话&nbsp;&nbsp;号 : ` + cust.telephone + `</p>
                <p>身份证号 : ` + cust.identity + `</p>

                `
        })
    }

    // 首页小li
    index.onclick = function () {
        window.location.href = "http://localhost:8080/room/customerRoomOperate";
    }



    // 模糊查询搜索功能
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
    exit.onclick = function () {
        var result = confirm("确定要退出吗");
        if(result){
            window.location.href = "http://localhost:8080/login/customerLogOut";
        }
    }

</script>

</html>
