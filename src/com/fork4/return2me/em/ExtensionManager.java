package com.fork4.return2me.em;

import java.util.HashMap;

/**
 * Provides a mechanism for storing and retrieving extension mappings
 * from persisted storage.
 * 
 * @author Chris Foster - fork(4)
 */
public interface ExtensionManager {
	/**
	 * Gets a listing of all mapped extensions.
	 * @return <code>java.util.HashMap<String, com.fork4.return2me.em.Extension></code>
	 */
	public HashMap<String, Extension> getAll();

	/**
	 * Stores a mapped extension
	 * @param extension <code>com.fork4.return2me.em.Extension</code>
	 */
	public void store(Extension extension);

	/**
	 * Removes a mapped extension
	 * @param extension <code>com.fork4.return2me.em.Extension</code>
	 */
	public void remove(Extension extension);

	/**
	 * Finds a number based on the given extension.
	 * @param extension <code>String</code>
	 * @return <code>com.fork4.return2me.em.Extension</code>
	 */
	public Extension find(String extension) throws ExtensionNotFoundException;
	
}
