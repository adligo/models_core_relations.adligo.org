package org.adligo.models.core.relations.shared;

import java.util.Collection;
import java.util.Set;

import org.adligo.models.core.shared.EMailAddress;
import org.adligo.models.core.shared.I_Storable;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ids.I_StorageIdentifier;

public interface I_EMailMutant extends I_Storable {
	public void setFrom(EMailAddress address) throws InvalidParameterException;
	public void setSubject(String subject);
	public void setBody(String body);
	
	/**
	 * returns the number of to email addresses
	 * @return
	 */
	public void setToAddresses(Collection<EMailAddress> addresses) throws InvalidParameterException;
	/**
	 * returns the number of cc email addresses
	 * @return
	 */
	public void setCcAddresses(Collection<EMailAddress> addresses) throws InvalidParameterException;
	
	/**
	 * returns the number of bcc email addresses
	 * @return
	 */
	public void setBccAddresses(Collection<EMailAddress> addresses) throws InvalidParameterException;
	
	/**
	 * returns the storage identifier for the attachment
	 * the key could contain the local file system path (ie C:\foo\myfile.txt)
	 * in a jse app or gwt app
	 * on the server the key could be a pointer to a Cache entry
	 * or stored on the servers file system or in a database
	 * it really depends on how your using 
	 * the email model, and what your trying to accomplish.
	 */
	public void setAttachments(Collection<I_StorageIdentifier> ids) throws InvalidParameterException;
	

}
