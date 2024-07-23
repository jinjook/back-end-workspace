package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 2. DAO 호출 - DB 접근
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = null;
		
		try {
			list = dao.allMember();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 3. 바인딩 : 결과 페이지에 서버에서 받은 값 보낼 때 필요
		request.setAttribute ("list", list); // (키, 값)
		// 4. 네비게이션 : 결과 페이지 지정
		// 만약 결과 페이지로 서버에서 받은 값 보여주려면 -> RequestDispatcher.forward 방식으로 보내야 함
		request.getRequestDispatcher("view.jsp").forward(request, response);
		
	}

}
