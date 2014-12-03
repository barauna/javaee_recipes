package org.javaeerecipes.chapter01.recipe01_14;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MathDispatcher")
public class MathDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eval = request.getParameter("matheval");
		ServletContext context = request.getServletContext();
		RequestDispatcher dispatcher = null;
		
		int evaluate = 0;
		int add = 0;
		int subtract = 1;
		int multiply = 2;
		int divide = 3;
		
		if(eval.equals("add"))
			evaluate = add;
		
		if(eval.equals("subtract"))
			evaluate = subtract;

		if(eval.equals("multiply"))
			evaluate = multiply;

		if(eval.equals("divide"))
			evaluate = divide;
		
		switch(evaluate){
			case(0): dispatcher = context.getRequestDispatcher("/AddServlet");
					 dispatcher.forward(request, response);
					 break;
			case(1): dispatcher = context.getRequestDispatcher("/SubtractServlet");
					 dispatcher.forward(request, response);
					 break;
			case(2): dispatcher = context.getRequestDispatcher("/MultiplyServlet");
					 dispatcher.forward(request, response);
					 break;
			case(3): dispatcher = context.getRequestDispatcher("/DivideServlet");
				     dispatcher.forward(request, response);
					 break;
		}
	}
}
