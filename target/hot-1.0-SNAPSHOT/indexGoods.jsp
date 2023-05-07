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
    <link href="/css/indexGoods.css" rel="stylesheet">
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
<div style="width: 87.5%; height: 751px;" class="border">
    <table border="1px" cellspacing="0" width="90%" id="ListAll" style="position: relative">
        <h2 id="text1" style="width: 90.4%; height: 50px; background-color: #233645; margin: 5px auto; line-height: 50px; margin-top: 70px; color: aliceblue;">&nbsp;&nbsp;&nbsp; 日&nbsp;用&nbsp;品&nbsp;采&nbsp;购</h2>
        <div id="text2" style="width: 90%; height: 430px; border: 2px solid #ccc; margin: auto; margin-bottom: 50px;">
            <div style="font-weight: 800; color: black;  font-size: 22px; margin-left: 135px; padding-top: 100px; float: left; ">
                商&nbsp;品&nbsp;名&nbsp;称&nbsp;: &nbsp;&nbsp;
                <input class="input1" type="text" style="width: 150px; height: 20px;">
            </div>

            <div style="font-weight: 800; color: black; font-size: 22px; margin-left: 780px; padding-top: 100px;  ">
                商&nbsp;品&nbsp;数&nbsp;量&nbsp;: &nbsp;&nbsp;
                <input class="input2" type="number" style="width: 150px; height: 20px;">
            </div>

            <div style="font-weight: 800; color: black; font-size: 22px; margin-left: 135px; padding-top: 100px; float: left;">
                商&nbsp;品&nbsp;价&nbsp;格&nbsp;: &nbsp;&nbsp;
                <input class="input3" type="number" style="width: 150px; height: 20px;">
            </div>

            <div style="font-weight: 800; color: black; font-size: 22px; margin-left: 780px; padding-top: 100px; ">
                商&nbsp;品&nbsp;图&nbsp;片&nbsp;: &nbsp;&nbsp;
                <input class="input4" type="file">
            </div>

            <button class="btn1" style="width: 100px; border: none; margin-left: 45px; margin-top: 60px; background-color: #ea5e5e; color: aliceblue; font-size: 18px;">取消</button>
            <button class="btn2" style="width: 100px; border: none; margin-left: 50px; margin-top: 60px; background-color: #ea5e5e; color: aliceblue; font-size: 18px;" class="yes">确定</button>

        </div>
        <a id="text3" href="/goods.jsp"><button class="revise" style="width: 200px; height:50px; background-color: #233645; color: #ffffff; font-size: 21px; font-weight: 800; margin-left: 1065px; margin-top: 48px">采&nbsp;购&nbsp;记&nbsp;录&nbsp;></button></a>
    </table>
</div>
</body>
<script>
    let text1 = document.getElementById("text1");
    let text2 = document.getElementById("text2");
    let text3 = document.getElementById("text3");
    let input1 = document.querySelector(".input1");
    let input2 = document.querySelector(".input2");
    let input3 = document.querySelector(".input3");
    let input4 = document.querySelector(".input4");
    let btn1 = document.querySelector(".btn1");
    let btn2 = document.querySelector(".btn2");
    // let goods = document.querySelector(".list-box").children[0].children[5];
    let exit = document.querySelector(".list-box").children[0].children[6];
    let index = document.querySelector(".list-box").children[0].children[0];
    let person = document.querySelector(".list-box").children[0].children[1];
    let customerInformation = document.querySelector(".list-box").children[0].children[2];
    let reserve = document.querySelector(".list-box").children[0].children[3];
    // 首页小li
    index.onclick = function () {
        window.location.href = "http://localhost:8080/room/adminRoomOperate";
    }

    // 个人信息小li
    person.onclick = function () {
        text1.style.display = "none";
        text2.style.display = "none";
        text3.style.display = "none";
        ListAll.style.border = "none";
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
        text1.style.display = "none";
        text2.style.display = "none";
        text3.style.display = "none";
        ListAll.style.border = "2px solid black";
        axios({
            method:"get",
            url:"http://localhost:8080/login/selectAllCustomer"
        }).then(function(resp){
            let customers = resp.data;
            console.log(customers);
            ListAll.innerHTML =
                `
                <tr class="tr1" style="background-color: #2f4050">
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
                    <tr align="center" class="tr2" style="color: black">
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
        text1.style.display = "none";
        text2.style.display = "none";
        text3.style.display = "none";
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
        text1.style.display = "none";
        text2.style.display = "none";
        text3.style.display = "none";
        ListAll.style.border = "1px solid black";
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

    // 退出登录小li
    exit.onclick = function(){
        var result = confirm("确定要退出吗")
        if(result){
            window.location.href = "http://localhost:8080/login/adminLogOut"
        }
    }

    // 商品采购小li
    // goods.onclick = function(){
    //     window.location.href = "http://localhost:8080/indexGoods.jsp"
    // }

    // 确认日用品采购
    btn2.onclick = function () {
        let username = input1.value;
        let number = input2.value;
        let price = input3.value;
        let image = input4.value.split('\\');
        let valueLength = image.length;
        let finalValue = image[valueLength - 1];

        console.log(finalValue)
        if(username != "" && number != "" && price != "" && image != ""){
            axios({
                method:"get",
                url:"http://localhost:8080/goods/addGoods?username=" + username + "&number=" + number + "&image=" + finalValue + "&price=" + price
            }).then(function(resp){
                alert("购买商品成功");
                input1.value = '';
                input2.value = '';
                input3.value = '';
                input4.value = '';
            })
        }else{
            alert("请将信息填写完整")
        }
    }

    // 取消日用品采购
    btn1.onclick = function () {
        input1.value = '';
        input2.value = '';
        input3.value = '';
        input4.value = '';
    }




</script>

</html>
