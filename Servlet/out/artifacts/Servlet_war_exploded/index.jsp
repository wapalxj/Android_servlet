<%--
  Created by IntelliJ IDEA.
  User: vero
  Date: 2015/12/3
  Time: 16:53
  To change this template use File | Settings | File Templates.
  此页面打开也需要打开服务器
  http://localhost:8080/vero/index.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <p>这是JJJJJJJSSSSSSSSPPPPPPPP1111111111111</p>
    <%--获取project中image下的图片--%>
    <img alt="xxx" src="${pageContext.request.contextPath}/image/i1.jpg" />
    <hr>
    <%--get请求 跳转到servlet----->GetImage.jpeg--%>
    <img alt="xxx" src="${pageContext.request.contextPath}/GetImage.jpeg?id=1" width="240px" height="240px"/>
    <hr>
    <img alt="xxx" src="${pageContext.request.contextPath}/GetImage.jpeg?id=2" />
    <%--<img alt="xxx" src="image/i1.jpg">--%>
  </body>
</html>
