package login.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.Controller;
import login.ModelAndView;
import model.dao.MemberDAO;
import model.vo.Member;

public class SearchController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		Member m = dao.searchMember(id);
				
		if(m != null) {
			request.setAttribute("search", m);
			return new ModelAndView("/views/search_ok.jsp");
		} 
		return new ModelAndView("/views/search_fail.jsp", true);
	}

}
