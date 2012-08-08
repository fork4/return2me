package com.fork4.return2me.em;

import java.util.HashMap;

import javax.servlet.ServletContext;

/**
 * An extension manager which uses the servlet context to store extensions.  
 * Useful for development and not much else.  
 * 
 * <br /><br />DO NOT USE FOR PRODUCTION!
 * @author Chris Foster - fork(4)
 */
public class ServletContextExtensionManager implements ExtensionManager {
	public static final String CTX_ATTR = "extensions";
	private ServletContext store;
	
	protected ServletContextExtensionManager(ServletContext context) {
		this.store = context;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, Extension> getAll() {
		Object exts = store.getAttribute(CTX_ATTR);
		if(exts != null && exts instanceof HashMap<?, ?>) {
			return (HashMap<String, Extension>)store.getAttribute(CTX_ATTR);
		}
		
		return new HashMap<String, Extension>();
	}

	public void store(Extension extension) {
		HashMap<String, Extension> exts = getAll();
		exts.put(extension.getExtension(), extension);
		
		store.setAttribute(CTX_ATTR, exts);
	}

	public Extension find(String extension) throws ExtensionNotFoundException {
		HashMap<String, Extension> exts = getAll();
		if(exts.containsKey(extension)) {
			return exts.get(extension);
		}
		
		throw new ExtensionNotFoundException(extension);
	}

	public void remove(Extension extension) {
		HashMap<String, Extension> exts = getAll();
		if(exts.containsKey(extension)) {
			exts.remove(extension);
		}		
	}

}
