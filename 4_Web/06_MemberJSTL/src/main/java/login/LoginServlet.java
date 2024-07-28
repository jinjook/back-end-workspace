package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.dao.MemberDAO;
import model.vo.Member;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		Member m = null;
		
		try {
			m = dao.loginMember(id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Session 에 바인딩
		HttpSession session = request.getSession();
		session.setAttribute("login", m);
		
//		request.getRequestDispatcher("index.jsp").forward(request, response); session은 굳이 forward 할 필요가 없음 - 이미 client 쪽에서 갖고 있는 정보
		response.sendRedirect("/index.jsp");
		
	}

}
