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

import net.sf.json.JSONArray;

/**
 * Servlet implementation class getQuestions
 * http://127.0.0.1:8080/MyJava/getQuestions
 * http://127.0.0.1:8080/vero/getQuestions
 */
@WebServlet("/getQuestions")
public class getQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("链接到doGet---getQuestions\n");
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
			sb.append("[{\"questionId\":20,\"title\":\"做好认真贵在?\",\"options\":[{\"item\":\"道德\",\"value\":0},{\"item\":\"态度\",\"value\":1}]},"
					+ "{\"questionId\":10,\"title\":\"与“认真”相同或相近的词语有\",\"options\":[{\"item\":\"固执\",\"value\":0},{\"item\":\"仔细\",\"value\":1},{\"item\":\"middle\",\"value\":2}]},"
					+ "{\"questionId\":16,\"title\":\"实现精益所必须做的工作有?\",\"options\":[{\"item\":\"惩前毖后\",\"value\":0},{\"item\":\"大事不放\",\"value\":1}]},"
					+ "{\"questionId\":11,\"title\":\"在执行认真度过程中，应坚持\",\"options\":[{\"item\":\"惩前毖后\",\"value\":0},{\"item\":\"大事不放\",\"value\":1}]},"
					+ "{\"questionId\":51,\"title\":\"丰田生产方式的开发者是\",\"options\":[{\"item\":\"松下幸之助\",\"value\":0},{\"item\":\"大野耐一\",\"value\":1}]},"
					+ "{\"questionId\":61,\"title\":\"下面属于“认真”的反义词的是\",\"options\":[{\"item\":\"疏忽\",\"value\":0},{\"item\":\"严谨\",\"value\":1}]},"
					+ "{\"questionId\":91,\"title\":\"实现精益所必须做的工作有?\",\"options\":[{\"item\":\"惩前毖后\",\"value\":0},{\"item\":\"大事不放\",\"value\":1}]},"
					+ "{\"questionId\":1000,\"title\":\"实现精益所必须做的工作有?\",\"options\":[{\"item\":\"惩前毖后\",\"value\":0},{\"item\":\"大事不放\"}]}"
					+ "]");
			// javabean-->使用json-lib封装成为JSON对象
//			JSONArray array = JSONArray.fromObject(sb.toString());
			// send to client
//			out.print(array.toString());
			out.print(sb.toString());
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
