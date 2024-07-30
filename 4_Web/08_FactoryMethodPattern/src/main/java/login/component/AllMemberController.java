package login.component;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.Controller;
import login.ModelAndView;
import model.dao.MemberDAO;
import model.vo.Member;

public class AllMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = new MemberDAO();
		ArrayList<Member> list = dao.searchAllMember();	
		request.setAttribute("list", list);
		
		return new ModelAndView("/views/allMember.jsp");
	}

}
