package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;



@WebServlet ("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		/* Controller - 비즈니스 로직 작성 공간*/
		// index.jsp에서 /register 로 요청 -> 요청 받은 아이디, 비밀번호, 이름 받기
		
		// 1. form 값 받아오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		// 2. DAO 호출 - DB 접근
		MemberDAO dao = new MemberDAO();
		
		boolean check = false;
		
		try {
			dao.registerMember(id, pwd, name);
			check = true;
		} catch (SQLException e) {
			
		}
		
		
		
/*		
 		// 중복 여부 판단 후 결과페이지 2개 (회원가입 성공/실패) 
		if(check) {
			// 3. 바인딩 : 결과 페이지에 서버에서 받은 값 보낼 때 필요
			request.setAttribute("name", name); // (키, 값)
			// 4. 네비게이션 : 결과 페이지 지정- result.jsp
			// 만약 결과 페이지로 서버에서 받은 값 보여주려면 -> RequestDispatcher.forward 방식으로 보내야 함
			request.getRequestDispatcher("result.jsp").forward(request, response);
		} else {
			// 4. 네비게이션 : 결과 페이지 지정- result.jsp
			 response.sendRedirect("result2.jsp");
		}
*/				
		// 결과 페이지 1개
		request.setAttribute("check", check);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		
	}

}
