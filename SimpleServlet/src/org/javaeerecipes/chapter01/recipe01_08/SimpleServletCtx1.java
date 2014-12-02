package org.javaeerecipes.chapter01.recipe01_08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SimpleServletCtx1
 */
@WebServlet(
		urlPatterns = { "/SimpleServletCtx1" }, 
		initParams = { 
				@WebInitParam(name = "nome", value = "Barah")
		})
public class SimpleServletCtx1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SimpleServletCtx1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<p>Este é um exemplo de utilização do Contexto da Aplicação! Olá " + getServletConfig().getInitParameter("nome") + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
