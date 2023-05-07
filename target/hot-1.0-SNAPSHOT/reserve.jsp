<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/reserve.css">
    <script src="js/axios-0.18.0.js"></script>
    <script>
        window.onload = () => {
            let query = window.location.search.substring (4);
            let leftImg = document.querySelector(".left-img");
            let rightInput = document.querySelector(".right-input");
            axios({
                method: 'get',
                url: "http://localhost:8080/room/selectById?id="+query
            }).then(function (resp) {
                let room = resp.data;
                leftImg.children[1].src = '/imgs/'+room.roomImage;
                leftImg.children[2].innerHTML = room.type;
                leftImg.children[1].value = room.price;
                leftImg.children[4].innerHTML = '房价 : '+ room.price;
                leftImg.children[5].innerHTML = '床位数 : '+ room.bedNumber;
                leftImg.children[6].innerHTML = '可住 : ' + room.peopleNumber;
                leftImg.children[7].innerHTML = '其他 : '+ room.des;
            })


            let yd_btn1 = document.getElementById("yd_btn1");
            let yd_btn2 = document.getElementById("yd_btn2");
            yd_btn1.onclick = () => {
                let roomImg = leftImg.children[1].src;
                let type =  leftImg.children[2].innerHTML;
                let price = leftImg.children[1].value;
                let bookingTime = rightInput.children[0].children[1].children[0].value;
                let leaveTime = rightInput.children[0].children[1].children[1].value;
                let customerName = rightInput.children[1].children[1].children[0].value;
                let telephone = rightInput.children[1].children[2].children[0].value;
                let identity = rightInput.children[1].children[3].children[0].value;

                // 获取当前的时间
                function getNowTime () {
                    let now = new Date();
                    let year = now.getFullYear(); //获取完整的年份(4位,1970-????)
                    let month = now.getMonth() + 1; //获取当前月份(0-11,0代表1月)
                    let today = now.getDate(); //获取当前日(1-31)
                    let hour = now.getHours(); //获取当前小时数(0-23)
                    let minute = now.getMinutes(); //获取当前分钟数(0-59)
                    let second = now.getSeconds(); //获取当前秒数(0-59)
                    let nowTime = ''
                    nowTime = year + '-' + fillZero(month) + '-' + fillZero(today) + ' ' + fillZero(hour) + ':' +
                        fillZero(minute) + ':' + fillZero(second)
                    return nowTime
                };

                function fillZero (str) {
                    var realNum;
                    if (str < 10) {
                        realNum = '0' + str;
                    } else {
                        realNum = str;
                    }
                    return realNum;
                }
                let nowTime = getNowTime();
                console.log(nowTime)

                if(leaveTime <= bookingTime){
                    alert("您输入的时间有误，请重新输入")
                }else  if(nowTime != "" && roomImg != "" && price != "" && type != "" && bookingTime != "" && leaveTime != "" && customerName != "" && telephone != "" && identity != ""){
                    window.location.href = "http://localhost:8080/room/reserveRoom?id="+query+"&nowTime="+nowTime+"&roomImg="+roomImg+"&price="+price+"&type="+type+"&bookingTime="+bookingTime+"&leaveTime="+leaveTime+"&customerName="+customerName+"&telephone="+telephone+"&identity="+identity+"&userid="+${customer.id};
                    console.log(nowTime)
                    alert("预定成功~")
                }else {
                    alert("预定失败,请将信息填写完整")
                }
            }

            yd_btn2.onclick = () => {
                window.location.href="http://localhost:8080/room/customerRoomOperate";
            }

        }
    </script>
</head>

<body>
    <div class="left-box">
        <div class="left-img">
            <a href="#" class="come">${customer.username},你好</a>
            <img src="" alt="" width="200px" height="150px">
            <h2>单人间</h2>
            <p>预定数 : 1</p>
            <p style="color: #dd4c40">房价: </p>
            <p>床位数:</p>
            <p>可住:</p>
            <p>其他:</p>
        </div>


    </div>
    <div class="right-box">
        <div class="right-input">
            <div class="first">
                <h2>预定信息</h2>
                <p style="margin-top: 50px">入住时间 <input type="date" name="date" class="startTime"> &nbsp; &nbsp; &nbsp; 离店时间 <input  type="date" class="endTime"></p>
            </div>
            <div class="two">
                <h2>入住信息</h2>
                <p>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 名 <input type="text"></p>
                <p>电 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 话 <input type="text"></p>
                <p>身份证号 <input type="text"></p>
                <p style="color: red; margin-top: 40px;">预定须知 : 请携带好本人身份证，办理入住手续，本店办理入住需要在前台缴费现金 ￥100</p>
                <button id="yd_btn1" style="cursor: pointer">确定预定</button>
                <button id="yd_btn2" style="cursor: pointer">取消预定</button>
            </div>
        </div>
    </div>
</body>

</html>