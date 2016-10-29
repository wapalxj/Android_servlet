package C4_06_hm_logindemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/5/24.
 * http://localhost:8080/vero/LoginServlet?number=252198&pwd=123456
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet---doPost");
//        request.setCharacterEncoding("UTF-8");//编码方式1
        String number =request.getParameter("number");
        String pwd=request.getParameter("pwd");
        number=new String (number.getBytes("iso8859-1"),"UTF-8");//编码方式2
        System.out.println("number:"+number+",pwd:"+pwd);
        if ("252198".equals(number)&&"123456".equals(pwd)){
            response.getWriter().print("login success");
        }else {
            response.getWriter().print("login failed");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");//编码方式1
        System.out.println("LoginServlet---doGet");
        String number =request.getParameter("number");
        String pwd=request.getParameter("pwd");
        number=new String (number.getBytes("iso8859-1"),"UTF-8");//编码方式2
        System.out.println("number:"+number+",pwd:"+pwd);
        if ("252198".equals(number)&&"123456".equals(pwd)){
            response.getWriter().print("login success");
        }else {
            response.getWriter().print("login failed");
        }
    }
}
