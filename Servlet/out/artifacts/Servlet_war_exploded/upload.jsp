<%--
  Created by IntelliJ IDEA.
  User: vero
  Date: 2015/12/11
  Time: 16:22
  To change this template use File | Settings | File Templates.
  http://localhost:8080/vero/upload.jsp
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <center>
        <form action="${pageContext.request.contextPath}/Upload"
              method="post" >
                <table>
                    <tr>
                        <td>
                            Name
                        </td>
                        <td>
                            <input type="text" name="Name">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Gender
                        </td>
                        <td>
                            <input type="radio" name="Gender" value="男">男
                            <input type="radio" name="Gender" value="女">女
                        </td>
                    </tr>
                    <tr>
                        <td>
                            请选择一个上传文件
                        </td>
                        <td>
                            <input type="file" name="Image">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="上传">
                        </td>
                        <td>
                            <input type="reset" value="重置">
                        </td>
                    </tr>
                </table>
        </form>
    </center>
</body>
</html>
