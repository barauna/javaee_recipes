package org.javaeerecipes.chapter01.recipe01_02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="SimpleServlet", urlPatterns={"/SimpleServlet", "/Barah"})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SimpleServlet() {
        super();
    }

	private void processRequest(HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		try {
			out.println("<html><body>Hello Servlet World</body></html>");
		} finally {
			out.close();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(response);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(resp);
	}
}
