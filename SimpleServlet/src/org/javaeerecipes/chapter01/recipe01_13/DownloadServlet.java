package org.javaeerecipes.chapter01.recipe01_13;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileToDownload = request.getParameter("filename");
		System.out.println("Downloading file now...");
		doDownload(request, response, fileToDownload);
	}

	private void doDownload(HttpServletRequest request,
			HttpServletResponse response, String fileToDownload) throws IOException {
		
		final int BYTES = 1024;
		int length = 0;
		ServletOutputStream outStream = response.getOutputStream();
		ServletContext context = getServletConfig().getServletContext();
		response.setContentType((context.getMimeType(fileToDownload) != null) ? 
				context.getMimeType(fileToDownload) : "text/plain");
		response.setHeader("Content-disposition", "attachment; filename=\"" + fileToDownload + "\"");
		InputStream in = context.getResourceAsStream("/" + fileToDownload);
		byte[] bbuf = new byte[BYTES];
		
		while ((in != null) && ((length = in.read(bbuf)) != -1)) {
			outStream.write(bbuf,0,length);
		}
		
		outStream.flush();
		outStream.close();
	}
}
