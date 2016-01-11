package c3_5_01_web_Vero_Server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by vero on 2015/12/3.
 * http://localhost:8080/vero/Servlet_login?loginName=vero&loginPassword=123456
 */
@WebServlet("/Servlet_login")
public class Servlet_login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        try {
//            Thread.sleep(6000);//测试响应超时
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("----运行了doPost");
        request.setCharacterEncoding("UTF-8");
        String loginName=request.getParameter("loginName");
        String loginPassword=request.getParameter("loginPassword");

        System.out.println("用户名:"+loginName);
        System.out.println("密码:"+loginPassword);



        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out =null;

        try {
            out =response.getWriter();

            if (loginName.equals("vero")&&loginPassword.equals("123456")){
                out.print("vero_success");
            }else{
                out.print("vero_failed");
            }
        }finally {
            if (out!=null)
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----运行了doGet");
        this.doPost(request,response);
    }
}
