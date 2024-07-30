package login.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import login.Controller;
import login.ModelAndView;
import model.vo.Member;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("login");
		
		if(m != null) {
			session.invalidate();
		}
		
		return new ModelAndView("/index.jsp",true);
	}

}
