package org.javaeerecipes.chapter01.recipe01_10;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttributeListener implements ServletContextListener, HttpSessionAttributeListener {
	
	public ServletContext context;
	
    public AttributeListener() {
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
    	String name = event.getName();
    	if(name == null){
    		name = "Desconhecido";
    	}
    	
    	String value = (String) event.getValue();
    	String message = new StringBuffer("O Atributo foi removido: \n").
    			append("Nome do atributo: ").
    			append(name).
    			append("\n").
    			append("Valor do atributo: ").
    			append(value).
    			toString();
    	log(message);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        String value = (String) event.getValue();
        String message = new StringBuffer("Novo atributo adicionado à sessão: \n").
        		append("Nome do Atributo: ").
        		append(name).
        		append("\n").
        		append("Valor do Atributo: ").
        		append(value).toString();
        log(message);
    }

	private void log(String message) {
		if (context != null){
			context.log("SessionListener: " + message);
		} else {
			System.out.println("SessionListener: " + message);
		}
	}

    @Override
	public void contextInitialized(ServletContextEvent context) {
    	context.getServletContext().setAttribute("nome", "Barah");
    	log("contextInitialized()");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        String name = event.getName();
        if(name == null){
        	name = "Desconhecido";
        }
        String value = (String) event.getValue();
        String novo = (String) event.getSession().getAttribute("numA");
        String message = new StringBuffer("Atributo foi alterado: \n").
        		append(name).
        		append("\n").
        		append("Valor do atributo: ").
        		append(value).
        		append("\n").
        		append("Novo Valor do atributo: ").
        		append(novo).
        		toString();
        log(message);
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        log("contextDestroyed()");
    }
	
}
