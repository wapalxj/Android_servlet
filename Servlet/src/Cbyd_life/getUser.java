package Cbyd_life;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class MyServlet 
 * http://127.0.0.1:8080/MyJava/getUser
 * http://127.0.0.1:8080/vero/getUser
 */
@WebServlet("/getUser")
public class getUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("hhhhhhhhhhhhhhhxxxxxxx111111111111111\n");
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		InputStream is = request.getInputStream();
		BufferedReader bw = new BufferedReader(new InputStreamReader(is));
		char[] s = new char[1024];
		bw.read(s);
		System.out.println("客户端发来data:" + new String(s));
		bw.close();
		
		//延迟2秒
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		/**
		 * JSON
		 */
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;

		try {

			out = response.getWriter();
			JSONObject jsonObject = JSONObject.fromObject(new String(s));
			System.out.println("客户端发来jsonObject:" + jsonObject.toString());
			// javabean-->使用json-lib封装成为JSON对象
			User user = new User();
			user.setUsername(jsonObject.getString("username"));

			if (jsonObject.getString("gender").equals("FEMALE")) {
				user.setGender(User.Gender.FEMALE);
			} else if (jsonObject.getString("gender").equals("MALE")) {
				user.setGender(User.Gender.MALE);
			}
			user.setExistence(true);
			user.setHasRecords(true);
//			JSONObject jsonRes = JSONObject.fromObject(user);
//			out.print(jsonRes.toString());
			String reString="{\"username\":\"erdsx\",\"gender\":\"MALE\",\"hasRecords\":"+true+",\"existence\":\"\"}";
			out.print(reString);
			

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
