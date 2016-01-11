package c3_5_02_web_Student_Server;

import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * http://localhost:8080/vero/GetStudents
 * Created by vero on 2015/12/9.
 */
@WebServlet("/GetStudents")
public class GetStudents extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("----运行了doPost");
        request.setCharacterEncoding("UTF-8");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 响应：封装JSON
         */
        response.setContentType("text/html;charset=UTF-8");
//        response.setContentType("application/x-java-serialized-object");
        PrintWriter out =null;

        try {
            List<Student> students =new ArrayList<>();
                Student vero=new Student("10","veroSSS",20);
                Student vnix=new Student("20","vnixSSS",20);
                Student Alicc=new Student("30","AliccSSS",20);
                students.add(vero);
                students.add(vnix);
                students.add(Alicc);
            out =response.getWriter();
            //封装成javabean(Student)-->再调用json-lib包装成JSON
            JSONArray array=JSONArray.fromObject(students);
            System.out.println("result:"+array);
            //send to client
            out.print(array.toString());
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
