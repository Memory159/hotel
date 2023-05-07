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
    <link href="/css/goods.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/axios/0.18.0/axios.min.js"></script>
    <title>Document</title>

    <script>
        window.onload = () => {
            axios({
                method: 'get',
                url: "http://localhost:8080/goods/getGoodsList"
            }).then((resp) => {
                let information = resp.data;
                console.log(information);
                for(let i = 0; i < information.length; i++){
                    ListAll.innerHTML +=
                        `
                        <tr class="border-tr2" align="center">
                            <td><img src="/imgs/` + information[i].image + `" width="200px" height="150px"></td>
                            <td> ` + information[i].username + ` </td>
                            <td> ` + information[i].number +` </td>
                            <td> ` + information[i].price +` </td>
                        </tr>
                        `
                }
            })
        }




    </script>
</head>

<body>
<button onclick="javascript:history.back(-1);">返回</button>
<h2 style="width: 90%; height: 50px; background-color: #233645; margin: 5px auto; margin-top:90px; line-height: 50px; color: aliceblue;">&nbsp;&nbsp;&nbsp; 采&nbsp;购&nbsp;明&nbsp;细</h2>
<table border="1px" cellspacing="0" width="90%" id="ListAll" style="position: relative; margin: auto;">
    <tr class="border-tr1" align="center">
        <th>商品图片</th>
        <th>商品名称</th>
        <th>商品数量</th>
        <th>商品价格</th>
    </tr>
</table>
</body>
<script>

</script>

</html>