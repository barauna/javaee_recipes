package org.javaeerecipes.chapter01.recipe01_06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MathServlet
 */
@WebServlet("/MathServlet")
public class MathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MathServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String numA = request.getParameter("numa");
		String numB = request.getParameter("numb");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		int solution;
		try {
			solution = Integer.valueOf(numA) + Integer.valueOf(numB);
			out.println("Resultado: " + numA + " + " + numB + " = " + solution);
		} catch (NumberFormatException e) {
			out.println("<p>Favor utilizar apenas números...</p>");
		}
		out.println("<br><br>");
		out.println("<a href='recipe01_06.html'>Entre novos números</a>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
