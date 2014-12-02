package org.javaeerecipes.chapter01.recipe01_11;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    private int numberOfSessions;
	
	public SessionListener() {
    }

    public void sessionCreated(HttpSessionEvent event) {
    	HttpSession session = event.getSession();
    	session.setMaxInactiveInterval(60);
    	session.setAttribute("teste", "testando...");
    	synchronized(this){
    		numberOfSessions++;
    	}
    	System.out.println("Sessão criada, quantidade atual: " + numberOfSessions);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
    	HttpSession session = event.getSession();
    	synchronized(this){
    		numberOfSessions--;
    	}
    	System.out.println("Sessão destruída, quantidade atual: " + numberOfSessions);
    	System.out.println("Valor do atributo: " + session.getAttribute("teste"));
    }
	
}
