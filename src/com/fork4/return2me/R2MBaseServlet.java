package com.fork4.return2me;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.fork4.return2me.em.ExtensionManager;
import com.fork4.return2me.em.ExtensionManagerFactory;
import com.fork4.return2me.twilio.TwilioAccount;

/**
 * Servlet implementation class Return2MeInitializer
 */
public class R2MBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static final String EM = "extension-manager";
	protected static final String ACCT = "account";
	
	private static ExtensionManager manager;
	private static TwilioAccount    account;
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public R2MBaseServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ServletContext ctx = config.getServletContext();
		
		if(ctx.getAttribute(EM) == null) {
			System.out.println("Creating extension manager");
			// Create the extension manager
			manager = ExtensionManagerFactory.newInstance(ctx);
			ctx.setAttribute(EM, manager);
		}
		
		if(ctx.getAttribute(ACCT) == null) {
			account = new TwilioAccount(
					ctx.getInitParameter("twilio.from"), 
					ctx.getInitParameter("twilio.sid"), 
					ctx.getInitParameter("twilio.token"));
			ctx.setAttribute(ACCT, account);
		}
	}
	
	public ExtensionManager getManager() {
		return manager;
	}
	
	public TwilioAccount getAccount() {
		return account;
	}

}
