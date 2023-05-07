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

    <script>
        window.onload = () => {
            let bor = document.getElementById("ListAll");
            bor.style.marginTop = "10px"
            axios({
                method: 'get',
                url: "http://localhost:8080/bookingList/selectProperty"
            }).then((resp) => {
                let information = resp.data;
                console.log(information)
                // 用来计算两个日期之间相差天数的函数
                function  getDaysBetween(date1,date2){
                    var  startDate = Date.parse(date1);
                    var  endDate = Date.parse(date2);
                    if (startDate>endDate){
                        return 0;
                    }
                    if (startDate==endDate){
                        return 1;
                    }
                    var days=(endDate - startDate)/(1*24*60*60*1000);
                    return  days;
                }

                //获取当前日期函数
                var date = new Date();
                // 获取当前月份
                var nowMonth = date.getMonth() + 1;
                // 获取当前是几号
                var strDate = date.getDate();
                // 添加分隔符“-”
                var seperator = "-";
                // 对月份进行处理，1-9月在前面添加一个“0”
                if (nowMonth >= 1 && nowMonth <= 9) {
                    nowMonth = "0" + nowMonth;
                }
                // 对月份进行处理，1-9号在前面添加一个“0”
                if (strDate >= 0 && strDate <= 9) {
                    strDate = "0" + strDate;
                }
                // 最后拼接字符串，得到一个格式为(yyyy-MM-dd)的日期
                var nowDate = date.getFullYear() + seperator + nowMonth + seperator + strDate;
                console.log(nowDate)

                var result = information.filter((item) => {
                    return item.nowTime.split(' ')[0] === nowDate
                });
                console.log(result)

                // 用来计算总的收入，变量需要定义到外面
                var finalProperty = 0;
                for(var j = 0; j < result.length; j++){
                    // 用来将预定时间与离店时间进行加工，去掉日时间
                    var date1 = result[j].bookingTime.split(' ')[0]
                    var date2 = result[j].leaveTime.split(' ')[0]

                    // 调用函数进行转换
                    var finalDate = getDaysBetween(date1,date2)

                    // 计算房间总价
                    var roomResultPrice = parseInt(result[j].price) * finalDate
                    // console.log(roomResultPrice)

                    // 计算总收入
                    finalProperty += roomResultPrice;
                }

                var finalVal = document.getElementById("text2");
                finalVal.innerText = "总收入:" + '\xa0' + finalProperty + ".00元"

                for(let i = 0; i < result.length; i++){
                    // 下面是判断一个数是几位数
                    var s = result[i].id;
                    var l=0;
                    while(s >= 1){
                        s=s/10;
                        l++;
                    }

                    // 下面根据不同的位数，进行不同的解决方法
                    var num;
                    if(l == 1){
                        num = Math.floor('8' + Math.random() * 10) + '0'
                    }else if(l == 2){
                        num = Math.floor('8' + Math.random() * 10)
                    }else if(l == 3){
                        num = '8'
                    }

                    // 用来将预定时间与离店时间进行加工，去掉日时间
                    var date1 = result[i].bookingTime.split(' ')[0]
                    var date2 = result[i].leaveTime.split(' ')[0]

                    // 调用函数进行转换
                    var finalDate = getDaysBetween(date1,date2)

                    // 计算房间总价
                    var roomResultPrice = parseInt(result[i].price) * finalDate
                    // console.log(roomResultPrice)

                    ListAll.innerHTML +=
                        `
                        <tr class="border-tr2" align="center">
                            <td> ` + num + result[i].id + ` </td>
                            <td> ` + result[i].customerName +` </td>
                            <td> ` + result[i].type +` </td>
                            <td> ` + result[i].price +` </td>
                            <td> ` + finalDate +` </td>
                            <td> ` + roomResultPrice + '&nbsp;元' +` </td>
                        </tr>
                        `
                }

                // 用来判断下拉框的值是什么，根据不同的值执行不同的回调
                let text1 = document.getElementById("text1");
                text1.onchange = function () {
                    var sid = text1.selectedIndex
                    console.log(text1[sid].value)
                    if(text1[sid].value === 'two'){
                        ListAll.innerHTML = '';
                        ListAll.innerHTML =
                            `
                        <tr class="border-tr1" id="text3">
                            <th>房号</th>
                            <th>顾客</th>
                            <th>房型</th>
                            <th>价格</th>
                            <th>共几晚</th>
                            <th>总价</th>
                        </tr>
                            `
                        // 用来计算总的收入，变量需要定义到外面
                        var finalProperty = 0;
                        for(var j = 0; j < information.length; j++){
                            // 用来将预定时间与离店时间进行加工，去掉日时间
                            var date1 = information[j].bookingTime.split(' ')[0]
                            var date2 = information[j].leaveTime.split(' ')[0]

                            // 调用函数进行转换
                            var finalDate = getDaysBetween(date1,date2)

                            // 计算房间总价
                            var roomResultPrice = parseInt(information[j].price) * finalDate
                            // console.log(roomResultPrice)

                            // 计算总收入
                            finalProperty += roomResultPrice;
                        }
                        var finalVal = document.getElementById("text2");
                        finalVal.innerText = "总收入:" + '\xa0' + finalProperty + ".00元"
                        for(let i = 0; i < information.length; i++){
                            // 下面是判断一个数是几位数
                            var s = information[i].id;
                            var l=0;
                            while(s >= 1){
                                s=s/10;
                                l++;
                            }

                            // 下面根据不同的位数，进行不同的解决方法
                            var num;
                            if(l == 1){
                                num = Math.floor('8' + Math.random() * 10) + '0'
                            }else if(l == 2){
                                num = Math.floor('8' + Math.random() * 10)
                            }else if(l == 3){
                                num = '8'
                            }

                            // 用来将预定时间与离店时间进行加工，去掉日时间
                            var date1 = information[i].bookingTime.split(' ')[0]
                            var date2 = information[i].leaveTime.split(' ')[0]

                            // 调用函数进行转换
                            var finalDate = getDaysBetween(date1,date2)

                            // 计算房间总价
                            var roomResultPrice = parseInt(information[i].price) * finalDate
                            // console.log(roomResultPrice)

                            ListAll.innerHTML +=
                                `
                        <tr class="border-tr2" align="center">
                            <td> ` + num + information[i].id + ` </td>
                            <td> ` + information[i].customerName +` </td>
                            <td> ` + information[i].type +` </td>
                            <td> ` + information[i].price +` </td>
                            <td> ` + finalDate +` </td>
                            <td> ` + roomResultPrice + '&nbsp;元' +` </td>
                        </tr>
                        `
                        }
                    }else if(text1[sid].value === 'one'){
                        ListAll.innerHTML = '';
                        ListAll.innerHTML =
                            `
                        <tr class="border-tr1" id="text3">
                            <th>房号</th>
                            <th>顾客</th>
                            <th>房型</th>
                            <th>价格</th>
                            <th>共几晚</th>
                            <th>总价</th>
                        </tr>
                            `
                        // 用来计算总的收入，变量需要定义到外面
                        var finalProperty = 0;
                        for(var j = 0; j < result.length; j++){
                            // 用来将预定时间与离店时间进行加工，去掉日时间
                            var date1 = result[j].bookingTime.split(' ')[0]
                            var date2 = result[j].leaveTime.split(' ')[0]

                            // 调用函数进行转换
                            var finalDate = getDaysBetween(date1,date2)

                            // 计算房间总价
                            var roomResultPrice = parseInt(result[j].price) * finalDate
                            // console.log(roomResultPrice)

                            // 计算总收入
                            finalProperty += roomResultPrice;
                        }
                        var finalVal = document.getElementById("text2");
                        finalVal.innerText = "总收入:" + '\xa0' + finalProperty + ".00元"
                        for(let i = 0; i < result.length; i++){
                            // 下面是判断一个数是几位数
                            var s = result[i].id;
                            var l=0;
                            while(s >= 1){
                                s=s/10;
                                l++;
                            }

                            // 下面根据不同的位数，进行不同的解决方法
                            var num;
                            if(l == 1){
                                num = Math.floor('8' + Math.random() * 10) + '0'
                            }else if(l == 2){
                                num = Math.floor('8' + Math.random() * 10)
                            }else if(l == 3){
                                num = '8'
                            }

                            // 用来将预定时间与离店时间进行加工，去掉日时间
                            var date1 = result[i].bookingTime.split(' ')[0]
                            var date2 = result[i].leaveTime.split(' ')[0]

                            // 调用函数进行转换
                            var finalDate = getDaysBetween(date1,date2)

                            // 计算房间总价
                            var roomResultPrice = parseInt(result[i].price) * finalDate
                            // console.log(roomResultPrice)

                            ListAll.innerHTML +=
                                `
                        <tr class="border-tr2" align="center">
                            <td> ` + num + result[i].id + ` </td>
                            <td> ` + result[i].customerName +` </td>
                            <td> ` + result[i].type +` </td>
                            <td> ` + result[i].price +` </td>
                            <td> ` + finalDate +` </td>
                            <td> ` + roomResultPrice + '&nbsp;元' +` </td>
                        </tr>
                        `
                        }
                    }
                }
            })



        }


    </script>
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
    <div style="position: relative;" >
        <select id="text1" style="font-family: 微软雅黑; margin: 45px 65px 0px 65px; background-color:#233645; width: 249px; height: 40px; font-size: 20px; font-weight: 800; color: #fff; text-align: center; border: 1px #1a1a1a solid; border-radius: 5px; ">
            <option value="one" style=" color: #fff; line-height: 20px;">今日财务收入</option>
            <option value="two" style=" color: #fff; line-height: 20px;">全部财务收入</option>
        </select>
        <div id="text2" style="position: absolute; top: 45px; right: 65px; width: 200px;height: 40px; line-height: 40px; text-align: center; background-color: #233645; color: #fff; font-size: 18px; font-weight: 800; margin-left: 700px; border-radius: 5px;">总收入:&nbsp;1024.00元</div>
    </div>
    <table border="1px" cellspacing="0" width="90%" id="ListAll" style="position: relative">
        <tr class="border-tr1" id="text3">
            <th>房号</th>
            <th>顾客</th>
            <th>房型</th>
            <th>价格</th>
            <th>共几晚</th>
            <th>总价</th>
        </tr>
    </table>
</div>
</body>
<script>
    let text1 = document.getElementById("text1");
    let text2 = document.getElementById("text2");
    let text3 = document.getElementById("text3");
    let property = document.querySelector(".list-box").children[0].children[4];
    let goods = document.querySelector(".list-box").children[0].children[5];
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
        ListAll.style.marginTop = "90px";
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
        // text3.style.display = "none";
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
        ListAll.style.marginTop = "90px";
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

</script>

</html>
