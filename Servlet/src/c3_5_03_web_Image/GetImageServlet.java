package c3_5_03_web_Image;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by vero on 2015/12/10.
 * http://localhost:8080/vero/GetImage.jpeg
 *
 * PC端测试：
 * 例如：在D下存放一张图片i1.jpg
 * 然后浏览器输入：
 * http://localhost:8080/vero/GetImage.jpeg?id=1
 */
@WebServlet("/GetImage.jpeg")
public class GetImageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---get---");
        String id=request.getParameter("id");
        InputStream is=null;
        OutputStream out=null;
        //设置响应头的 MIME
        response.setContentType("image/jpeg");
        try{
            //文件输入流
            is=new FileInputStream(new File("d:/i"+id+".jpg"));
            //设置响应头，设置总输出长度
//        response.setContentLength(is.available());
            //响应输出流
            out=response.getOutputStream();
            byte [] data =new byte[1024];//1KB
            int len;
            while (-1!=(len=(is.read(data)))) {
                out.write(data,0,len);
            }
            out.flush();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (is!=null){
                is.close();
            }
            if (out!=null){
                out.close();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---POST---");
        doGet(req,resp);

    }
}
