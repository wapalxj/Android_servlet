package c3_5_01_web_Vero_Server;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by vero on 2015/12/7.
 * http://localhost:8080/vero/Servlet_register?data={"name":"vero","age":20,"hobbies":["ball","LOL","coding"]}
 * http://localhost:8080/vero/Servlet_register?registerName=vero&password=123456
 */
@WebServlet("/Servlet_register")
public class Servlet_register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----运行了doPost");
        request.setCharacterEncoding("UTF-8");

        String data=request.getParameter("data");
        System.out.println("data:"+data);

        /**
         * json-lib-解析JSON
         */
        JSONObject jsonObject=JSONObject.fromObject(data);
        String name=jsonObject.getString("name");
        String age=jsonObject.getString("age");
        JSONArray hobbies=jsonObject.getJSONArray("hobbies");
        System.out.println("name:"+name);
        System.out.println("age:"+age);
        System.out.println("hobbies:");
        if (hobbies!=null){
            for(Object obj:hobbies){
                System.out.println(obj.toString());
            }
        }




//通过输入流接收:
//        InputStream is = request.getInputStream();
//接收字符1,2

//        BufferedReader bw=new BufferedReader(new InputStreamReader(is));
//        char [] s=new char[1024];
//        bw.read(s);
//        System.out.println("data:"+new String(s));
//        bw.close();
//接受字节流
//        BufferedInputStream bis=new BufferedInputStream(is);
//        byte[] b=new byte[1024];
//        bis.read(b);
//        System.out.println("data:"+new String(b));
//        bis.close();
//
//
//        is.close();


//        响应
        /**
         * 响应：封装JSON
         */
        response.setContentType("text/html;charset=UTF-8");
//        response.setContentType("application/x-java-serialized-object");
        PrintWriter out =null;

        try {
            out =response.getWriter();
            //封装成javabean-->再调用json-lib包装成JSON
            ResultJSONBean jsonBean=new ResultJSONBean();
            //OK
//            jsonBean.setResult("success");
//            jsonBean.setErrorMsg("");
            //error
            jsonBean.setResult("failed");
            jsonBean.setErrorMsg("注册失败");

            JSONObject obj=JSONObject.fromObject(jsonBean);
            System.out.println("result:"+obj);
            //send to client
            out.print(obj.toString());
        }finally {
            if (out!=null) {
                out.close();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----运行了doGet");
        this.doPost(request,response);

    }
}
