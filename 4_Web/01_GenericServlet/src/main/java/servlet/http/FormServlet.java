package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/fm")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("userId");
		String pwd = request.getParameter("userPwd");
		String gender = request.getParameter("gender");	
		String[] menuList = request.getParameterValues("menu");
		
//		System.out.println(Arrays.toString(menuList)); 리스트확인
						
		// 받는건 JSP 사용
		PrintWriter pw = response.getWriter();
		pw.println("<html><body>");
		
		pw.println("<h1>정보를 출력합니다..</h1>");
		pw.println("<p>당신의 아이디는 "+id+"</p>");
		pw.println("<p>당신의 비밀번호는 "+pwd+"</p>");
		String genderResult = gender.equals("F")? "여자" : "남자";
		pw.println("<p>당신의 성별은 "+ genderResult + "</p>");
		pw.println("<ul>");
		for(String m : menuList) {
			pw.println("<li>"+m+"</li>");
		}
		pw.println("</ul>");
		pw.println("</body></html>");
		
		pw.close();
	}

}
