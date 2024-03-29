/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-05-03 01:44:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class reserve_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/reserve.css\">\r\n");
      out.write("    <script src=\"js/axios-0.18.0.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        window.onload = () => {\r\n");
      out.write("            let query = window.location.search.substring (4);\r\n");
      out.write("            let leftImg = document.querySelector(\".left-img\");\r\n");
      out.write("            let rightInput = document.querySelector(\".right-input\");\r\n");
      out.write("            axios({\r\n");
      out.write("                method: 'get',\r\n");
      out.write("                url: \"http://localhost:8080/room/selectById?id=\"+query\r\n");
      out.write("            }).then(function (resp) {\r\n");
      out.write("                let room = resp.data;\r\n");
      out.write("                leftImg.children[1].src = '/imgs/'+room.roomImage;\r\n");
      out.write("                leftImg.children[2].innerHTML = room.type;\r\n");
      out.write("                leftImg.children[1].value = room.price;\r\n");
      out.write("                leftImg.children[4].innerHTML = '房价 : '+ room.price;\r\n");
      out.write("                leftImg.children[5].innerHTML = '床位数 : '+ room.bedNumber;\r\n");
      out.write("                leftImg.children[6].innerHTML = '可住 : ' + room.peopleNumber;\r\n");
      out.write("                leftImg.children[7].innerHTML = '其他 : '+ room.des;\r\n");
      out.write("            })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            let yd_btn1 = document.getElementById(\"yd_btn1\");\r\n");
      out.write("            let yd_btn2 = document.getElementById(\"yd_btn2\");\r\n");
      out.write("            yd_btn1.onclick = () => {\r\n");
      out.write("                let roomImg = leftImg.children[1].src;\r\n");
      out.write("                let type =  leftImg.children[2].innerHTML;\r\n");
      out.write("                let price = leftImg.children[1].value;\r\n");
      out.write("                let bookingTime = rightInput.children[0].children[1].children[0].value;\r\n");
      out.write("                let leaveTime = rightInput.children[0].children[1].children[1].value;\r\n");
      out.write("                let customerName = rightInput.children[1].children[1].children[0].value;\r\n");
      out.write("                let telephone = rightInput.children[1].children[2].children[0].value;\r\n");
      out.write("                let identity = rightInput.children[1].children[3].children[0].value;\r\n");
      out.write("\r\n");
      out.write("                // 获取当前的时间\r\n");
      out.write("                function getNowTime () {\r\n");
      out.write("                    let now = new Date();\r\n");
      out.write("                    let year = now.getFullYear(); //获取完整的年份(4位,1970-????)\r\n");
      out.write("                    let month = now.getMonth() + 1; //获取当前月份(0-11,0代表1月)\r\n");
      out.write("                    let today = now.getDate(); //获取当前日(1-31)\r\n");
      out.write("                    let hour = now.getHours(); //获取当前小时数(0-23)\r\n");
      out.write("                    let minute = now.getMinutes(); //获取当前分钟数(0-59)\r\n");
      out.write("                    let second = now.getSeconds(); //获取当前秒数(0-59)\r\n");
      out.write("                    let nowTime = ''\r\n");
      out.write("                    nowTime = year + '-' + fillZero(month) + '-' + fillZero(today) + ' ' + fillZero(hour) + ':' +\r\n");
      out.write("                        fillZero(minute) + ':' + fillZero(second)\r\n");
      out.write("                    return nowTime\r\n");
      out.write("                };\r\n");
      out.write("\r\n");
      out.write("                function fillZero (str) {\r\n");
      out.write("                    var realNum;\r\n");
      out.write("                    if (str < 10) {\r\n");
      out.write("                        realNum = '0' + str;\r\n");
      out.write("                    } else {\r\n");
      out.write("                        realNum = str;\r\n");
      out.write("                    }\r\n");
      out.write("                    return realNum;\r\n");
      out.write("                }\r\n");
      out.write("                let nowTime = getNowTime();\r\n");
      out.write("                console.log(nowTime)\r\n");
      out.write("\r\n");
      out.write("                if(leaveTime <= bookingTime){\r\n");
      out.write("                    alert(\"您输入的时间有误，请重新输入\")\r\n");
      out.write("                }else  if(nowTime != \"\" && roomImg != \"\" && price != \"\" && type != \"\" && bookingTime != \"\" && leaveTime != \"\" && customerName != \"\" && telephone != \"\" && identity != \"\"){\r\n");
      out.write("                    window.location.href = \"http://localhost:8080/room/reserveRoom?id=\"+query+\"&nowTime=\"+nowTime+\"&roomImg=\"+roomImg+\"&price=\"+price+\"&type=\"+type+\"&bookingTime=\"+bookingTime+\"&leaveTime=\"+leaveTime+\"&customerName=\"+customerName+\"&telephone=\"+telephone+\"&identity=\"+identity+\"&userid=\"+");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(";\r\n");
      out.write("                    console.log(nowTime)\r\n");
      out.write("                    alert(\"预定成功~\")\r\n");
      out.write("                }else {\r\n");
      out.write("                    alert(\"预定失败,请将信息填写完整\")\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            yd_btn2.onclick = () => {\r\n");
      out.write("                window.location.href=\"http://localhost:8080/room/customerRoomOperate\";\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"left-box\">\r\n");
      out.write("        <div class=\"left-img\">\r\n");
      out.write("            <a href=\"#\" class=\"come\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customer.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(",你好</a>\r\n");
      out.write("            <img src=\"\" alt=\"\" width=\"200px\" height=\"150px\">\r\n");
      out.write("            <h2>单人间</h2>\r\n");
      out.write("            <p>预定数 : 1</p>\r\n");
      out.write("            <p style=\"color: #dd4c40\">房价: </p>\r\n");
      out.write("            <p>床位数:</p>\r\n");
      out.write("            <p>可住:</p>\r\n");
      out.write("            <p>其他:</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"right-box\">\r\n");
      out.write("        <div class=\"right-input\">\r\n");
      out.write("            <div class=\"first\">\r\n");
      out.write("                <h2>预定信息</h2>\r\n");
      out.write("                <p style=\"margin-top: 50px\">入住时间 <input type=\"date\" name=\"date\" class=\"startTime\"> &nbsp; &nbsp; &nbsp; 离店时间 <input  type=\"date\" class=\"endTime\"></p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"two\">\r\n");
      out.write("                <h2>入住信息</h2>\r\n");
      out.write("                <p>姓 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 名 <input type=\"text\"></p>\r\n");
      out.write("                <p>电 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 话 <input type=\"text\"></p>\r\n");
      out.write("                <p>身份证号 <input type=\"text\"></p>\r\n");
      out.write("                <p style=\"color: red; margin-top: 40px;\">预定须知 : 请携带好本人身份证，办理入住手续，本店办理入住需要在前台缴费现金 ￥100</p>\r\n");
      out.write("                <button id=\"yd_btn1\" style=\"cursor: pointer\">确定预定</button>\r\n");
      out.write("                <button id=\"yd_btn2\" style=\"cursor: pointer\">取消预定</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
