package Cbyd_life;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getAssessment
 * http://127.0.0.1:8080/MyJava/getAssessmentRecords
 * http://127.0.0.1:8080/vero/getAssessmentRecords
 */
@WebServlet("/getAssessmentRecords")
public class getAssessmentRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("getAssessment\n");
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;

		try {
			User user = new User();
			out = response.getWriter();
			StringBuilder sb = new StringBuilder();
			Date date = new Date();
			sb.append("[{\"assessTime\":\""+new Date(date.getTime()+100000)+ "\",\"tip\":\"干果可以美肤，健脑，保护心脑血管健康，抗衰老。\",\"score\":81},"
					+ "{\"assessTime\":\""+ new Date(date.getTime()+200000)+ "\",\"tip\":\"良好的教育可以让你获得更多的健康和知识。\",\"score\":79},"
					+ "{\"assessTime\":\""+ new Date(date.getTime()+300000)+ "\",\"tip\":\"18岁以上定期测血压，30岁以上定期测血脂，40岁以上男性每年都应该测血糖。\",\"score\":83},"
					+ "{\"assessTime\":\""+ new Date(date.getTime()+500000)+ "\",\"tip\":\"干果可以美肤，健脑，保护心脑血管健康，抗衰老。\",\"score\":89},"
					+ "{\"assessTime\":\""+ new Date(date.getTime()+600000)+ "\",\"tip\":\"良好的教育可以让你获得更多的健康和知识。\",\"score\":75},"
					+ "{\"assessTime\":\""+ new Date(date.getTime()+700000)+ "\",\"tip\":\"18岁以上定期测血压，30岁以上定期测血脂，40岁以上男性每年都应该测血糖。\",\"score\":\"123\"}"
					//+ "{\"assessTime\":\"verovero\",\"tip\":\"\",\"score\":100}"
					+ "]");
			// javabean-->使用json-lib封装成为JSON对象
			JSONArray array = JSONArray.fromObject(sb.toString());
			// send to client
			out.print(sb.toString());

		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
