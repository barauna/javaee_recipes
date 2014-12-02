package org.javaeerecipes.chapter01.recipe01_12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionServlet() {
        super();
    }

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("session.email");
		if (email == null){
			email = request.getParameter("email");
			session.setAttribute("session.email", email);
		}
		String sessionId = session.getId();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Session Test</h1>");
		out.println("Seu email é: " + email + "<br><br>");
		out.println("Seu id de sessão é: " + sessionId);
		out.println("</body>");
		out.println("</html>");
	}

}
