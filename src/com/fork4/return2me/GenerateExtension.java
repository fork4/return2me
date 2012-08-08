package com.fork4.return2me;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fork4.return2me.em.Extension;
import com.fork4.return2me.em.ExtensionManager;
import com.fork4.return2me.twilio.SendExtension;
import com.fork4.return2me.twilio.TwilioAccount;

/**
 * Servlet to generate a new Return2Me number/extension mapping.
 * 
 * @author Chris Foster - fork(4)
 */ 
public class GenerateExtension extends R2MBaseServlet {
	private static final long serialVersionUID = 3825167205915084731L;

	private static Logger log = Logger.getLogger("GenerateExtension");
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	/*
	public GenerateExtension() {
        super();
    }

	@Override
	public void init() throws ServletException {
		super.init();
        account = new TwilioAccount("", "", "");
        extManager = null;
	}
	*/
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		generateExtension(request.getParameter("repPhone"), request.getParameter("custPhone"), 
				"true".equals(request.getParameter("oneTimeUse")));
		
		response.sendRedirect("index.jsp");
	}
	
	protected void generateExtension(String repPhone, String customerPhone, boolean oneTimeUse) {
		log.fine("Generating extension for " + repPhone);
		if(repPhone != null) {
			SecureRandom rand = new SecureRandom();
			
			String extension = String.valueOf(rand.nextInt(99999));
			
			// Add the extension
			Extension ext = new Extension(repPhone, extension, customerPhone, oneTimeUse);
			
			// Send it to the customer
			if(ext.hasCustomerPhone()) {
				SendExtension.send(getAccount(), extension, customerPhone);
			}

			getManager().store(ext);
		}		
	}
	
}
