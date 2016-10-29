package C3_5_04_upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by vero on 2015/12/11.
 * http://192.168.56.1:8080/vero/Upload
 * http://localhost:8080/vero/GetImage.jpeg
 * 类似源码：http://www.educity.cn/wenda/579555.html
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("upload---post");
        request.setCharacterEncoding("UTF-8");

//        String name=request.getParameter("Name");
//        String gender=request.getParameter("Gender");
//        System.out.println(name+"------>"+gender);

        //第三方库
        // 判断enctype是什么类型的
        boolean isMultipart= ServletFileUpload.isMultipartContent(request);
        if (isMultipart){
            //接收上传数据的准备工作
            //设置一个上传缓冲区
            DiskFileItemFactory factory =new DiskFileItemFactory();
            factory.setSizeThreshold(1024*1024*2);//缓冲区大小字节
            File temp=new File("d:temp");
            if (!temp.exists()){
                temp.mkdir();
            }
            factory.setRepository(temp);//缓冲区位置

            ServletFileUpload upload= new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            //设置上传文件/整个请求文件的最大值
            upload.setFileSizeMax(1024*1024*5);
            upload.setSizeMax(1024*1024*6);

            try {
                //
                List<FileItem> items=upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
