/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-03 01:41:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class indexProperty_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link href=\"/css/index.css\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"/css/indexGoods.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://cdn.staticfile.org/axios/0.18.0/axios.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        window.onload = () => {\r\n");
      out.write("            let bor = document.getElementById(\"ListAll\");\r\n");
      out.write("            bor.style.marginTop = \"10px\"\r\n");
      out.write("            axios({\r\n");
      out.write("                method: 'get',\r\n");
      out.write("                url: \"http://localhost:8080/bookingList/selectProperty\"\r\n");
      out.write("            }).then((resp) => {\r\n");
      out.write("                let information = resp.data;\r\n");
      out.write("                console.log(information)\r\n");
      out.write("                // 用来计算两个日期之间相差天数的函数\r\n");
      out.write("                function  getDaysBetween(date1,date2){\r\n");
      out.write("                    var  startDate = Date.parse(date1);\r\n");
      out.write("                    var  endDate = Date.parse(date2);\r\n");
      out.write("                    if (startDate>endDate){\r\n");
      out.write("                        return 0;\r\n");
      out.write("                    }\r\n");
      out.write("                    if (startDate==endDate){\r\n");
      out.write("                        return 1;\r\n");
      out.write("                    }\r\n");
      out.write("                    var days=(endDate - startDate)/(1*24*60*60*1000);\r\n");
      out.write("                    return  days;\r\n");
      out.write("                }\r\n");
      out.write("                // 获取到预定房间日期\r\n");
      out.write("                var d1 = information[23].nowTime.split(' ')[0]\r\n");
      out.write("                console.log(d1)\r\n");
      out.write("                //获取当前日期函数\r\n");
      out.write("                var date = new Date();\r\n");
      out.write("                // 获取当前月份\r\n");
      out.write("                var nowMonth = date.getMonth() + 1;\r\n");
      out.write("                // 获取当前是几号\r\n");
      out.write("                var strDate = date.getDate();\r\n");
      out.write("                // 添加分隔符“-”\r\n");
      out.write("                var seperator = \"-\";\r\n");
      out.write("                // 对月份进行处理，1-9月在前面添加一个“0”\r\n");
      out.write("                if (nowMonth >= 1 && nowMonth <= 9) {\r\n");
      out.write("                    nowMonth = \"0\" + nowMonth;\r\n");
      out.write("                }\r\n");
      out.write("                // 对月份进行处理，1-9号在前面添加一个“0”\r\n");
      out.write("                if (strDate >= 0 && strDate <= 9) {\r\n");
      out.write("                    strDate = \"0\" + strDate;\r\n");
      out.write("                }\r\n");
      out.write("                // 最后拼接字符串，得到一个格式为(yyyy-MM-dd)的日期\r\n");
      out.write("                var nowDate = date.getFullYear() + seperator + nowMonth + seperator + strDate;\r\n");
      out.write("                console.log(nowDate)\r\n");
      out.write("\r\n");
      out.write("                if(d1 === nowDate){\r\n");
      out.write("                    console.log(111)\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                var result = information.filter((item) => {\r\n");
      out.write("                    return item.nowTime.split(' ')[0] === nowDate\r\n");
      out.write("                });\r\n");
      out.write("                console.log(result)\r\n");
      out.write("                // console.log(information[1].nowTime,new Date())\r\n");
      out.write("                // console.log(getDaysBetween(information[1].nowTime,new Date()))\r\n");
      out.write("\r\n");
      out.write("                // 用来计算总的收入，变量需要定义到外面\r\n");
      out.write("                var finalProperty = 0;\r\n");
      out.write("                for(var j = 0; j < result.length; j++){\r\n");
      out.write("                    // 用来将预定时间与离店时间进行加工，去掉日时间\r\n");
      out.write("                    var date1 = result[j].bookingTime.split(' ')[0]\r\n");
      out.write("                    var date2 = result[j].leaveTime.split(' ')[0]\r\n");
      out.write("\r\n");
      out.write("                    // 调用函数进行转换\r\n");
      out.write("                    var finalDate = getDaysBetween(date1,date2)\r\n");
      out.write("\r\n");
      out.write("                    // 计算房间总价\r\n");
      out.write("                    var roomResultPrice = parseInt(result[j].price) * finalDate\r\n");
      out.write("                    // console.log(roomResultPrice)\r\n");
      out.write("\r\n");
      out.write("                    // 计算总收入\r\n");
      out.write("                    finalProperty += roomResultPrice;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                var finalVal = document.getElementById(\"text2\");\r\n");
      out.write("                finalVal.innerText = \"总收入:\" + '\\xa0' + finalProperty + \".00元\"\r\n");
      out.write("\r\n");
      out.write("                for(let i = 0; i < result.length; i++){\r\n");
      out.write("                    // 下面是判断一个数是几位数\r\n");
      out.write("                    var s = result[i].id;\r\n");
      out.write("                    var l=0;\r\n");
      out.write("                    while(s >= 1){\r\n");
      out.write("                        s=s/10;\r\n");
      out.write("                        l++;\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    // 下面根据不同的位数，进行不同的解决方法\r\n");
      out.write("                    var num;\r\n");
      out.write("                    if(l == 1){\r\n");
      out.write("                        num = Math.floor('8' + Math.random() * 10) + '0'\r\n");
      out.write("                    }else if(l == 2){\r\n");
      out.write("                        num = Math.floor('8' + Math.random() * 10)\r\n");
      out.write("                    }else if(l == 3){\r\n");
      out.write("                        num = '8'\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                    // 用来将预定时间与离店时间进行加工，去掉日时间\r\n");
      out.write("                    var date1 = result[i].bookingTime.split(' ')[0]\r\n");
      out.write("                    var date2 = result[i].leaveTime.split(' ')[0]\r\n");
      out.write("\r\n");
      out.write("                    // 调用函数进行转换\r\n");
      out.write("                    var finalDate = getDaysBetween(date1,date2)\r\n");
      out.write("\r\n");
      out.write("                    // 计算房间总价\r\n");
      out.write("                    var roomResultPrice = parseInt(result[i].price) * finalDate\r\n");
      out.write("                    // console.log(roomResultPrice)\r\n");
      out.write("\r\n");
      out.write("                    ListAll.innerHTML +=\r\n");
      out.write("                        `\r\n");
      out.write("                        <tr class=\"border-tr2\" align=\"center\">\r\n");
      out.write("                            <td> ` + num + result[i].id + ` </td>\r\n");
      out.write("                            <td> ` + result[i].customerName +` </td>\r\n");
      out.write("                            <td> ` + result[i].type +` </td>\r\n");
      out.write("                            <td> ` + result[i].price +` </td>\r\n");
      out.write("                            <td> ` + finalDate +` </td>\r\n");
      out.write("                            <td> ` + roomResultPrice + '&nbsp;元' +` </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        `\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                let text1 = document.getElementById(\"text1\");\r\n");
      out.write("                text1.onchange = function () {\r\n");
      out.write("                    var sid = text1.selectedIndex\r\n");
      out.write("                    console.log(text1[sid].value)\r\n");
      out.write("                    if(text1[sid].value === 'two'){\r\n");
      out.write("                        ListAll.innerHTML = '';\r\n");
      out.write("                        ListAll.innerHTML =\r\n");
      out.write("                            `\r\n");
      out.write("                        <tr class=\"border-tr1\" id=\"text3\">\r\n");
      out.write("                            <th>房号</th>\r\n");
      out.write("                            <th>顾客</th>\r\n");
      out.write("                            <th>房型</th>\r\n");
      out.write("                            <th>价格</th>\r\n");
      out.write("                            <th>共几晚</th>\r\n");
      out.write("                            <th>总价</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                            `\r\n");
      out.write("                        // 用来计算总的收入，变量需要定义到外面\r\n");
      out.write("                        var finalProperty = 0;\r\n");
      out.write("                        for(var j = 0; j < information.length; j++){\r\n");
      out.write("                            // 用来将预定时间与离店时间进行加工，去掉日时间\r\n");
      out.write("                            var date1 = information[j].bookingTime.split(' ')[0]\r\n");
      out.write("                            var date2 = information[j].leaveTime.split(' ')[0]\r\n");
      out.write("\r\n");
      out.write("                            // 调用函数进行转换\r\n");
      out.write("                            var finalDate = getDaysBetween(date1,date2)\r\n");
      out.write("\r\n");
      out.write("                            // 计算房间总价\r\n");
      out.write("                            var roomResultPrice = parseInt(information[j].price) * finalDate\r\n");
      out.write("                            // console.log(roomResultPrice)\r\n");
      out.write("\r\n");
      out.write("                            // 计算总收入\r\n");
      out.write("                            finalProperty += roomResultPrice;\r\n");
      out.write("                        }\r\n");
      out.write("                        var finalVal = document.getElementById(\"text2\");\r\n");
      out.write("                        finalVal.innerText = \"总收入:\" + '\\xa0' + finalProperty + \".00元\"\r\n");
      out.write("                        for(let i = 0; i < information.length; i++){\r\n");
      out.write("                            // 下面是判断一个数是几位数\r\n");
      out.write("                            var s = information[i].id;\r\n");
      out.write("                            var l=0;\r\n");
      out.write("                            while(s >= 1){\r\n");
      out.write("                                s=s/10;\r\n");
      out.write("                                l++;\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                            // 下面根据不同的位数，进行不同的解决方法\r\n");
      out.write("                            var num;\r\n");
      out.write("                            if(l == 1){\r\n");
      out.write("                                num = Math.floor('8' + Math.random() * 10) + '0'\r\n");
      out.write("                            }else if(l == 2){\r\n");
      out.write("                                num = Math.floor('8' + Math.random() * 10)\r\n");
      out.write("                            }else if(l == 3){\r\n");
      out.write("                                num = '8'\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                            // 用来将预定时间与离店时间进行加工，去掉日时间\r\n");
      out.write("                            var date1 = information[i].bookingTime.split(' ')[0]\r\n");
      out.write("                            var date2 = information[i].leaveTime.split(' ')[0]\r\n");
      out.write("\r\n");
      out.write("                            // 调用函数进行转换\r\n");
      out.write("                            var finalDate = getDaysBetween(date1,date2)\r\n");
      out.write("\r\n");
      out.write("                            // 计算房间总价\r\n");
      out.write("                            var roomResultPrice = parseInt(information[i].price) * finalDate\r\n");
      out.write("                            // console.log(roomResultPrice)\r\n");
      out.write("\r\n");
      out.write("                            ListAll.innerHTML +=\r\n");
      out.write("                                `\r\n");
      out.write("                        <tr class=\"border-tr2\" align=\"center\">\r\n");
      out.write("                            <td> ` + num + information[i].id + ` </td>\r\n");
      out.write("                            <td> ` + information[i].customerName +` </td>\r\n");
      out.write("                            <td> ` + information[i].type +` </td>\r\n");
      out.write("                            <td> ` + information[i].price +` </td>\r\n");
      out.write("                            <td> ` + finalDate +` </td>\r\n");
      out.write("                            <td> ` + roomResultPrice + '&nbsp;元' +` </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        `\r\n");
      out.write("                        }\r\n");
      out.write("                    }else if(text1[sid].value === 'one'){\r\n");
      out.write("                        ListAll.innerHTML = '';\r\n");
      out.write("                        ListAll.innerHTML =\r\n");
      out.write("                            `\r\n");
      out.write("                        <tr class=\"border-tr1\" id=\"text3\">\r\n");
      out.write("                            <th>房号</th>\r\n");
      out.write("                            <th>顾客</th>\r\n");
      out.write("                            <th>房型</th>\r\n");
      out.write("                            <th>价格</th>\r\n");
      out.write("                            <th>共几晚</th>\r\n");
      out.write("                            <th>总价</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                            `\r\n");
      out.write("                        // 用来计算总的收入，变量需要定义到外面\r\n");
      out.write("                        var finalProperty = 0;\r\n");
      out.write("                        for(var j = 0; j < result.length; j++){\r\n");
      out.write("                            // 用来将预定时间与离店时间进行加工，去掉日时间\r\n");
      out.write("                            var date1 = result[j].bookingTime.split(' ')[0]\r\n");
      out.write("                            var date2 = result[j].leaveTime.split(' ')[0]\r\n");
      out.write("\r\n");
      out.write("                            // 调用函数进行转换\r\n");
      out.write("                            var finalDate = getDaysBetween(date1,date2)\r\n");
      out.write("\r\n");
      out.write("                            // 计算房间总价\r\n");
      out.write("                            var roomResultPrice = parseInt(result[j].price) * finalDate\r\n");
      out.write("                            // console.log(roomResultPrice)\r\n");
      out.write("\r\n");
      out.write("                            // 计算总收入\r\n");
      out.write("                            finalProperty += roomResultPrice;\r\n");
      out.write("                        }\r\n");
      out.write("                        var finalVal = document.getElementById(\"text2\");\r\n");
      out.write("                        finalVal.innerText = \"总收入:\" + '\\xa0' + finalProperty + \".00元\"\r\n");
      out.write("                        for(let i = 0; i < result.length; i++){\r\n");
      out.write("                            // 下面是判断一个数是几位数\r\n");
      out.write("                            var s = result[i].id;\r\n");
      out.write("                            var l=0;\r\n");
      out.write("                            while(s >= 1){\r\n");
      out.write("                                s=s/10;\r\n");
      out.write("                                l++;\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                            // 下面根据不同的位数，进行不同的解决方法\r\n");
      out.write("                            var num;\r\n");
      out.write("                            if(l == 1){\r\n");
      out.write("                                num = Math.floor('8' + Math.random() * 10) + '0'\r\n");
      out.write("                            }else if(l == 2){\r\n");
      out.write("                                num = Math.floor('8' + Math.random() * 10)\r\n");
      out.write("                            }else if(l == 3){\r\n");
      out.write("                                num = '8'\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                            // 用来将预定时间与离店时间进行加工，去掉日时间\r\n");
      out.write("                            var date1 = result[i].bookingTime.split(' ')[0]\r\n");
      out.write("                            var date2 = result[i].leaveTime.split(' ')[0]\r\n");
      out.write("\r\n");
      out.write("                            // 调用函数进行转换\r\n");
      out.write("                            var finalDate = getDaysBetween(date1,date2)\r\n");
      out.write("\r\n");
      out.write("                            // 计算房间总价\r\n");
      out.write("                            var roomResultPrice = parseInt(result[i].price) * finalDate\r\n");
      out.write("                            // console.log(roomResultPrice)\r\n");
      out.write("\r\n");
      out.write("                            ListAll.innerHTML +=\r\n");
      out.write("                                `\r\n");
      out.write("                        <tr class=\"border-tr2\" align=\"center\">\r\n");
      out.write("                            <td> ` + num + result[i].id + ` </td>\r\n");
      out.write("                            <td> ` + result[i].customerName +` </td>\r\n");
      out.write("                            <td> ` + result[i].type +` </td>\r\n");
      out.write("                            <td> ` + result[i].price +` </td>\r\n");
      out.write("                            <td> ` + finalDate +` </td>\r\n");
      out.write("                            <td> ` + roomResultPrice + '&nbsp;元' +` </td>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        `\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"big-box\">\r\n");
      out.write("<div class=\"left-box\">\r\n");
      out.write("    <div class=\"customer-box\">\r\n");
      out.write("        <p class=\"identity\">(管理员)</p>\r\n");
      out.write("        <a href=\"#\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",欢迎你</a><br>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"list-box\">\r\n");
      out.write("        <ul>\r\n");
      out.write("            <li class=\"li\"><a href=\"#\">首页</a></li>\r\n");
      out.write("            <li class=\"li\"><a href=\"#\">个人信息</a></li>\r\n");
      out.write("            <li class=\"li\"><a href=\"#\">顾客信息</a></li>\r\n");
      out.write("            <li class=\"li\"><a href=\"#\">预定信息</a></li>\r\n");
      out.write("            <li class=\"li\"><a href=\"/indexProperty.jsp\">财务统计</a></li>\r\n");
      out.write("            <li class=\"li\"><a href=\"/indexGoods.jsp\">商品采购</a></li>\r\n");
      out.write("            <li class=\"li\"><a href=\"#\">退出登录</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<div style=\"width: 87.5%; height: 751px;\" class=\"border\">\r\n");
      out.write("    <div style=\"position: relative;\" >\r\n");
      out.write("        <select id=\"text1\" style=\"font-family: 微软雅黑; margin: 45px 65px 0px 65px; background-color:#233645; width: 249px; height: 40px; font-size: 20px; font-weight: 800; color: #fff; text-align: center; border: 1px #1a1a1a solid; border-radius: 5px; \">\r\n");
      out.write("            <option value=\"one\" style=\" color: #fff; line-height: 20px;\">今日财务收入</option>\r\n");
      out.write("            <option value=\"two\" style=\" color: #fff; line-height: 20px;\">全部财务收入</option>\r\n");
      out.write("        </select>\r\n");
      out.write("        <div id=\"text2\" style=\"position: absolute; top: 45px; right: 65px; width: 200px;height: 40px; line-height: 40px; text-align: center; background-color: #233645; color: #fff; font-size: 18px; font-weight: 800; margin-left: 700px; border-radius: 5px;\">总收入:&nbsp;1024.00元</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <table border=\"1px\" cellspacing=\"0\" width=\"90%\" id=\"ListAll\" style=\"position: relative\">\r\n");
      out.write("        <tr class=\"border-tr1\" id=\"text3\">\r\n");
      out.write("            <th>房号</th>\r\n");
      out.write("            <th>顾客</th>\r\n");
      out.write("            <th>房型</th>\r\n");
      out.write("            <th>价格</th>\r\n");
      out.write("            <th>共几晚</th>\r\n");
      out.write("            <th>总价</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("    let text1 = document.getElementById(\"text1\");\r\n");
      out.write("    let text2 = document.getElementById(\"text2\");\r\n");
      out.write("    let text3 = document.getElementById(\"text3\");\r\n");
      out.write("    let property = document.querySelector(\".list-box\").children[0].children[4];\r\n");
      out.write("    let goods = document.querySelector(\".list-box\").children[0].children[5];\r\n");
      out.write("    let exit = document.querySelector(\".list-box\").children[0].children[6];\r\n");
      out.write("    let index = document.querySelector(\".list-box\").children[0].children[0];\r\n");
      out.write("    let person = document.querySelector(\".list-box\").children[0].children[1];\r\n");
      out.write("    let customerInformation = document.querySelector(\".list-box\").children[0].children[2];\r\n");
      out.write("    let reserve = document.querySelector(\".list-box\").children[0].children[3];\r\n");
      out.write("    // 首页小li\r\n");
      out.write("    index.onclick = function () {\r\n");
      out.write("        window.location.href = \"http://localhost:8080/room/adminRoomOperate\";\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // 个人信息小li\r\n");
      out.write("    person.onclick = function () {\r\n");
      out.write("        text1.style.display = \"none\";\r\n");
      out.write("        text2.style.display = \"none\";\r\n");
      out.write("        text3.style.display = \"none\";\r\n");
      out.write("        ListAll.style.border = \"none\";\r\n");
      out.write("        axios({\r\n");
      out.write("            method: \"get\",\r\n");
      out.write("            url: \"http://localhost:8080/login/adminInformation?id=\" +");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${admin.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("        }).then(function (resp) {\r\n");
      out.write("            let adm = resp.data\r\n");
      out.write("            console.log(adm);\r\n");
      out.write("            ListAll.innerHTML =\r\n");
      out.write("                `\r\n");
      out.write("                <h1>个人信息</h1>\r\n");
      out.write("                <a href=\"/adminInformation.jsp\"><button class=\"revise\">修改</button></a>\r\n");
      out.write("                <p>用&nbsp;&nbsp;户&nbsp;&nbsp;名 : ` + adm.username + `</p>\r\n");
      out.write("                <p>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码 : ` + adm.password + `</p>\r\n");
      out.write("                `\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // 顾客信息小li\r\n");
      out.write("    customerInformation.onclick = function(){\r\n");
      out.write("        text1.style.display = \"none\";\r\n");
      out.write("        text2.style.display = \"none\";\r\n");
      out.write("        text3.style.display = \"none\";\r\n");
      out.write("        ListAll.style.border = \"2px solid black\";\r\n");
      out.write("        ListAll.style.marginTop = \"90px\";\r\n");
      out.write("        axios({\r\n");
      out.write("            method:\"get\",\r\n");
      out.write("            url:\"http://localhost:8080/login/selectAllCustomer\"\r\n");
      out.write("        }).then(function(resp){\r\n");
      out.write("            let customers = resp.data;\r\n");
      out.write("            console.log(customers);\r\n");
      out.write("            ListAll.innerHTML =\r\n");
      out.write("                `\r\n");
      out.write("                <tr class=\"tr1\" style=\"background-color: #2f4050\">\r\n");
      out.write("                    <th>姓名</th>\r\n");
      out.write("                    <th>密码</th>\r\n");
      out.write("                    <th>性别</th>\r\n");
      out.write("                    <th>电话号</th>\r\n");
      out.write("                    <th>身份证号</th>\r\n");
      out.write("                    <th>删除</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                `\r\n");
      out.write("            for (let i = 0; i < customers.length; i++) {\r\n");
      out.write("                ListAll.innerHTML +=\r\n");
      out.write("                    `\r\n");
      out.write("                    <tr align=\"center\" class=\"tr2\" style=\"color: black\">\r\n");
      out.write("                        <td>` + customers[i].username+ `</td>\r\n");
      out.write("                        <td>` + customers[i].password + `</td>\r\n");
      out.write("                        <td>` + customers[i].gender + `</td>\r\n");
      out.write("                        <td>` + customers[i].telephone + `</td>\r\n");
      out.write("                        <td>` + customers[i].identity + `</td>\r\n");
      out.write("                        <td><button class=\"btn\" style=\"width: 70px;height: 30px\" onclick=\"deleteCustomerInformation(` + customers[i].id + `)\">删除</button></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    `\r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // 删除顾客信息小li\r\n");
      out.write("    function deleteCustomerInformation(customerId){\r\n");
      out.write("        axios({\r\n");
      out.write("            method:\"get\",\r\n");
      out.write("            url:\"http://localhost:8080/login/deleteCustomerInformation?id=\"+customerId\r\n");
      out.write("        }).then(function(resp){\r\n");
      out.write("            redraw_information();\r\n");
      out.write("            alert(resp.data);\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // 删除之后对顾客信息页面进行重绘\r\n");
      out.write("    function redraw_information(){\r\n");
      out.write("        text1.style.display = \"none\";\r\n");
      out.write("        text2.style.display = \"none\";\r\n");
      out.write("        // text3.style.display = \"none\";\r\n");
      out.write("        axios({\r\n");
      out.write("            method:\"get\",\r\n");
      out.write("            url:\"http://localhost:8080/login/selectAllCustomer\"\r\n");
      out.write("        }).then(function(resp){\r\n");
      out.write("            let customers = resp.data;\r\n");
      out.write("            console.log(customers);\r\n");
      out.write("            ListAll.innerHTML =\r\n");
      out.write("                `\r\n");
      out.write("                <tr class=\"border-tr1\">\r\n");
      out.write("                    <th>姓名</th>\r\n");
      out.write("                    <th>密码</th>\r\n");
      out.write("                    <th>性别</th>\r\n");
      out.write("                    <th>电话号</th>\r\n");
      out.write("                    <th>身份证号</th>\r\n");
      out.write("                    <th>删除</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                `\r\n");
      out.write("            for (let i = 0; i < customers.length; i++) {\r\n");
      out.write("                ListAll.innerHTML +=\r\n");
      out.write("                    `\r\n");
      out.write("                    <tr align=\"center\" class=\"border-tr2\">\r\n");
      out.write("                        <td>` + customers[i].username+ `</td>\r\n");
      out.write("                        <td>` + customers[i].password + `</td>\r\n");
      out.write("                        <td>` + customers[i].gender + `</td>\r\n");
      out.write("                        <td>` + customers[i].telephone + `</td>\r\n");
      out.write("                        <td>` + customers[i].identity + `</td>\r\n");
      out.write("                        <td><button class=\"btn\" style=\"width: 70px;height: 30px\" onclick=\"deleteCustomerInformation(` + customers[i].id + `)\">删除</button></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    `\r\n");
      out.write("            }\r\n");
      out.write("            ListAll.innerHTML += `<hr/>`\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    // 预定信息小li\r\n");
      out.write("    reserve.onclick = function(){\r\n");
      out.write("        text1.style.display = \"none\";\r\n");
      out.write("        text2.style.display = \"none\";\r\n");
      out.write("        text3.style.display = \"none\";\r\n");
      out.write("        ListAll.style.border = \"1px solid black\";\r\n");
      out.write("        ListAll.style.marginTop = \"90px\";\r\n");
      out.write("        axios({\r\n");
      out.write("            method:\"get\",\r\n");
      out.write("            url:\"http://localhost:8080/bookingList/selectAllReserve\"\r\n");
      out.write("        }).then(function(resp){\r\n");
      out.write("            let bookingLists = resp.data;\r\n");
      out.write("            ListAll.innerHTML =\r\n");
      out.write("                `\r\n");
      out.write("                <tr class=\"border-tr1\">\r\n");
      out.write("                    <th>用户名</th>\r\n");
      out.write("                    <th>预定时间</th>\r\n");
      out.write("                    <th>离店时间</th>\r\n");
      out.write("                    <th>顾客名</th>\r\n");
      out.write("                    <th>电话号</th>\r\n");
      out.write("                    <th>身份证号</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("                `\r\n");
      out.write("            for (let i = 0; i < bookingLists.length; i++) {\r\n");
      out.write("                ListAll.innerHTML +=\r\n");
      out.write("                    `\r\n");
      out.write("                    <tr align=\"center\" class=\"border-tr2\">\r\n");
      out.write("                        <td>` + bookingLists[i].username + `</td>\r\n");
      out.write("                        <td>` + bookingLists[i].bookingTime + `</td>\r\n");
      out.write("                        <td>` + bookingLists[i].leaveTime + `</td>\r\n");
      out.write("                        <td>` + bookingLists[i].customerName + `</td>\r\n");
      out.write("                        <td>` + bookingLists[i].telephone + `</td>\r\n");
      out.write("                        <td>` + bookingLists[i].identity + `</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    `\r\n");
      out.write("            }\r\n");
      out.write("            ListAll.innerHTML += `<hr/>`\r\n");
      out.write("        })\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // 退出登录小li\r\n");
      out.write("    exit.onclick = function(){\r\n");
      out.write("        var result = confirm(\"确定要退出吗\")\r\n");
      out.write("        if(result){\r\n");
      out.write("            window.location.href = \"http://localhost:8080/login/adminLogOut\"\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}