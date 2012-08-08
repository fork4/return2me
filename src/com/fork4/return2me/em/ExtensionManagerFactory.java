package com.fork4.return2me.em;

import javax.servlet.ServletContext;

public class ExtensionManagerFactory {
	public static ExtensionManager newInstance(Object store) {
		if(store == null) {
			throw new RuntimeException("Extension store cannot be null.");
		}

		if(store instanceof ServletContext) {
			return new ServletContextExtensionManager((ServletContext)store);
		}
		
		throw new RuntimeException("There is no extension store of type " + 
				store.getClass().getName() + ".");
	}
}
