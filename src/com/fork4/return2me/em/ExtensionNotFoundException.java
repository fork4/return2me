package com.fork4.return2me.em;

/**
 * Checked exception for when an extension is not found.
 * 
 * @author Chris Foster - fork(4)
 */
public class ExtensionNotFoundException extends Exception {
	public ExtensionNotFoundException(String extension) {
		super("Extension '" + extension + "' not found.");
	}

	private static final long serialVersionUID = -2053291831988538892L;

}
