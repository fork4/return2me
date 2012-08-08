package com.fork4.return2me;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fork4.return2me.em.Extension;
import com.fork4.return2me.em.ExtensionManager;
import com.fork4.return2me.em.ExtensionNotFoundException;
import com.fork4.return2me.twilio.IvrResponse;

/**
 * Servlet implementation class FetchNumber
 */
public class FetchNumber extends R2MBaseServlet {
	private static final long serialVersionUID = -5622885266841171588L;

	private static final String NOT_FOUND_MSG = "Extension not found.";
	
	static Logger log = Logger.getLogger("FetchNumber");
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processCall(request.getParameter("Digits"), response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processCall(request.getParameter("Digits"), response);
	}
	
	protected void processCall(String extension, HttpServletResponse response) throws IOException {
		response.setContentType("text/xml");
		String number = fetchNumber(extension);
		String action;
		
		if(!number.equals(NOT_FOUND_MSG)) {
			action = IvrResponse.callRedirect(number);
		} else {
			action = IvrResponse.badExtension();
		}

		response.getWriter().write(action);
		response.getWriter().flush();
	}
	
	protected String fetchNumber(String extension) {
		String number = NOT_FOUND_MSG;
		log.fine("Extension: " + extension);
		if(extension != null) {
			ExtensionManager manager = getManager();

			try {
				Extension ext = manager.find(extension);
				log.fine("Send caller to " + ext.getRepPhone());
				
				number = ext.getRepPhone();
				if(ext.isOneTimeUse()) {
					manager.remove(ext);
				}
			} catch (ExtensionNotFoundException e) {
				log.fine("Unable to find extension: " + e.toString());
			}
			
		}
		
		return number;
	}
	
}
