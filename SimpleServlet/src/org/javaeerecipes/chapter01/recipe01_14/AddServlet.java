package org.javaeerecipes.chapter01.recipe01_14;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,	HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String numA = request.getParameter("numA");
		String numB = request.getParameter("numB");
		int soma = Integer.parseInt(numA) + Integer.parseInt(numB);

		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Soma: " +  soma + "</h1>");
		out.println("<br>");
		out.println("<a href='recipe01_14.html'>Tente novamente</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
}
