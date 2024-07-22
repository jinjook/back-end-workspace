package servlet.generic;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GenericServletTest extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override //toGet toPost 사용하지 않고 오버라이드로 사용
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		// /generic 통해 요청 받았다 치고 -> 클라이언트 브라우저로 바로 응답
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Hello, GenericServletTest!</h1>");
		out.println("</body></html>");

		out.close();
		
	}

}
