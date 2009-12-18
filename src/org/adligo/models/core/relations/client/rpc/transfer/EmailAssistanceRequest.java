package org.adligo.models.core.relations.client.rpc.transfer;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMail;

public class EmailAssistanceRequest implements I_Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected EMail email;
	protected DomainName domain;
	/**
	 * this is the client locale (en,fr)
	 * so that the email can go out in the correct language
	 */
	protected String clientLocale;
	
	public String getClientLocale() {
		return clientLocale;
	}
	public void setClientLocale(String clientLocale) {
		this.clientLocale = clientLocale;
	}
	public EMail getEmail() {
		return email;
	}
	public void setEmail(EMail email) {
		this.email = email;
	}
	
	public DomainName getDomain() {
		return domain;
	}
	public void setDomain(DomainName domain) {
		this.domain = domain;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(EmailAssistanceRequest.class));
		sb.append("[email=");
		sb.append(email);
		sb.append(",domain=");
		sb.append(domain);
		sb.append("]");
		return sb.toString();
	}
}
