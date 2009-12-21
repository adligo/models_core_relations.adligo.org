package org.adligo.models.core.relations.client;

import java.util.Set;

import org.adligo.models.core.client.EMailAddress;
import org.adligo.models.core.client.I_SerializableStorageIdentifier;
import org.adligo.models.core.client.I_StorageIdentifier;

public interface I_EMail {
	public EMailAddress getFrom();
	public String getSubject();
	public String getBody();
	
	/**
	 * returns the number of to email addresses
	 * @return
	 */
	public Set<EMailAddress> getTOs();
	/**
	 * returns the number of cc email addresses
	 * @return
	 */
	public Set<EMailAddress> getCCs();
	
	/**
	 * returns the number of bcc email addresses
	 * @return
	 */
	public Set<EMailAddress> getBCCs();
	
	/**
	 * returns the storage identifier for the attachment
	 * the key could contain the local file system path (ie C:\foo\myfile.txt)
	 * in a jse app or gwt app
	 * on the server the key could be a pointer to a Cache entry
	 * or stored on the servers file system or in a database
	 * it really depends on how your using 
	 * the email model, and what your trying to accomplish.
	 */
	public Set<I_SerializableStorageIdentifier> getAttachments();
	
}
