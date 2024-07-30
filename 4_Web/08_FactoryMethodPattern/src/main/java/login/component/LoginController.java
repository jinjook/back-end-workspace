package login.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import login.Controller;
import login.ModelAndView;
import model.dao.MemberDAO;
import model.vo.Member;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		Member m = dao.loginMember(id, pwd);
		
		// Session 에 바인딩
		HttpSession session = request.getSession();
		session.setAttribute("login", m);
		
		return new ModelAndView("index.jsp", true);
	}

}
