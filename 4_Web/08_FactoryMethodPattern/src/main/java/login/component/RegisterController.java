package login.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.Controller;
import login.ModelAndView;
import model.dao.MemberDAO;
import model.vo.Member;

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * */
public class RegisterController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		Member m = new Member(id, pwd, name);
		
		MemberDAO dao = new MemberDAO();
		dao.registerMember(m);
		
		return new ModelAndView("index.jsp", true);
	}
	
}
