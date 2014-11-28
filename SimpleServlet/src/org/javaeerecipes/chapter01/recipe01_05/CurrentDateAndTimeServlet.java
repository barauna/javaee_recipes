package org.javaeerecipes.chapter01.recipe01_05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrentDateAndTimeServlet
 */
@WebServlet("/CurrentDateAndTimeServlet")
public class CurrentDateAndTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Date initDateAndTime = new Date();
	private Date currDateAndTime;
       
    public CurrentDateAndTimeServlet() {
        super();
    }

    private void processRequest(HttpServletResponse response) throws IOException{
    	PrintWriter out = response.getWriter();
    	out.println("<html>");
    	out.println("<body>");
    	out.println("<h1>The init date is: " + initDateAndTime + "</h1>");
    	currDateAndTime = new Date();
    	out.println("<h1>The current date is: " + currDateAndTime + "</h1>");
    	out.println("</body>");
    	out.println("</html>");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	processRequest(response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(response);
	}

}
