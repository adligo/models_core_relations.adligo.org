package org.adligo.models.core.relations.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.models.core.client.CommonModel;
import org.adligo.models.core.client.EMailAddress;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreConstantsObtainer;
import org.adligo.models.core.client.ids.I_StorageIdentifier;

/**
 * represents a email message,
 * this is a simplified form of a javax.mail.internet.MimeMessage
 * which assumes UTF-8 encoding of content
 * (Mutant) does not require constructor arguments
 * and uses common terms for the parts of a mail message 
 * for instance addAttachemnt
 * setFrom
 * addTo
 * exc
 * 
 * Also this class helps in stubbing for unit testing.
 * 
 * @author scott
 *
 */
public class EMail implements I_EMail {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ADD_ATTACHMENT = "addAttachment";
	public static final String E_MAIL = "EMail";
	public static final String ADD_BCC = "addBCC";
	public static final String ADD_CC = "addCC";
	public static final String ADD_TO = "addTo";

	public static final String SET_FROM = "setFrom";
	protected I_StorageIdentifier id;
	protected EMailAddress from;
	protected String subject;
	protected String body;
	protected Set<EMailAddress> toAddresses = new HashSet<EMailAddress>();
	protected Set<EMailAddress> ccAddresses = new HashSet<EMailAddress>();
	protected Set<EMailAddress> bccAddresses = new HashSet<EMailAddress>();
	protected Set<I_StorageIdentifier> attachments = new HashSet<I_StorageIdentifier>();
	
	public EMail () {}
	
	public EMail(I_EMail other) throws InvalidParameterException {
		try {
			if (other.getId() != null) {
				setIdP(other.getId());
			}
			setFromP(other.getFrom());
			subject = other.getSubject();
			body = other.getBody();
			toAddresses.addAll(other.getTOs());
			ccAddresses.addAll(other.getCCs());
			bccAddresses.addAll(other.getBCCs());
			attachments.addAll(other.getAttachments());
		} catch (InvalidParameterException e) {
			throw new InvalidParameterException(e.getMessage(), E_MAIL, e);
		}
		if (toAddresses.size() == 0) {
			if (ccAddresses.size() == 0) {
				if (bccAddresses.size() == 0) {
					throw new InvalidParameterException(
							ModelsCoreConstantsObtainer.getConstants().getEMailRequiresADestAddress(), E_MAIL);
				}
			}
		}
		
	}
	
	public EMailAddress getFrom() {
		return from;
	}
	public String getSubject() {
		return subject;
	}
	public String getBody() {
		return body;
	}
	
	protected void setFromP(EMailAddress from) throws InvalidParameterException {
		if (from == null) {
			throw new InvalidParameterException(
					ModelsCoreConstantsObtainer.getConstants().getEMailRequiresAFromAddress(), SET_FROM);
		}
		if (!from.isValid()) {
			throw new InvalidParameterException(
					ModelsCoreConstantsObtainer.getConstants().getEMailRequiresAValidFromAddress(), SET_FROM);
		}
		this.from = from;
	}
	protected void setSubject(String subject) {
		this.subject = subject;
	}
	protected void setBody(String body) {
		this.body = body;
	}
	
	public Set<I_StorageIdentifier> getAttachments() {
		return Collections.unmodifiableSet(attachments);
	}
	
	public Set<EMailAddress> getBCCs() {
		return Collections.unmodifiableSet(bccAddresses);
	}
	
	public Set<EMailAddress> getCCs() {
		return Collections.unmodifiableSet(ccAddresses);
	}
	
	public Set<EMailAddress> getTOs() {
		return Collections.unmodifiableSet(toAddresses);
	}
	
	private void validateAddr(EMailAddress to, String method) throws InvalidParameterException {
		if (to == null) {
			throw new InvalidParameterException(
					ModelsCoreConstantsObtainer.getConstants().getEMailRequiresAValidAddress(), method);
		}
		if (!to.isValid()) {
			throw new InvalidParameterException(
					ModelsCoreConstantsObtainer.getConstants().getEMailRequiresAValidAddress(), method);
		}
	}
	
	protected synchronized boolean addToP(EMailAddress to) throws InvalidParameterException {
		validateAddr(to, ADD_TO);
		return toAddresses.add(to);
	}
	
	protected synchronized boolean removeToP(EMailAddress to) {
		return toAddresses.remove(to);
	}
	
	protected synchronized boolean addAllToP(Set<EMailAddress> tos) throws InvalidParameterException {
		for (EMailAddress ea: tos) {
			validateAddr(ea, ADD_TO);
			toAddresses.add(ea);
		}
		return true;
	}
	
	protected synchronized boolean removeAllToP(Set<EMailAddress> tos) {
		return toAddresses.removeAll(tos);
	}
	
	protected synchronized boolean addCcP(EMailAddress to) throws InvalidParameterException {
		validateAddr(to, ADD_CC);
		return ccAddresses.add(to);
	}
	
	protected synchronized boolean removeCcP(EMailAddress to) {
		return ccAddresses.remove(to);
	}
	
	protected synchronized boolean addAllCcP(Set<EMailAddress> tos) throws InvalidParameterException {
		for (EMailAddress ea: tos) {
			validateAddr(ea, ADD_CC);
			ccAddresses.add(ea);
		}
		return true;
	}
	
	protected synchronized boolean removeAllCcP(Set<EMailAddress> tos) {
		return ccAddresses.removeAll(tos);
	}
	
	protected synchronized boolean addBccP(EMailAddress to) throws InvalidParameterException {
		validateAddr(to, ADD_BCC);
		return bccAddresses.add(to);
	}
	
	protected synchronized boolean removeBccP(EMailAddress to) {
		return bccAddresses.remove(to);
	}	
	
	protected synchronized boolean addAllBccP(Set<EMailAddress> tos) throws InvalidParameterException {
		for (EMailAddress ea: tos) {
			validateAddr(ea, ADD_BCC);
			bccAddresses.add(ea);
		}
		return true;
	}
	
	protected synchronized boolean removeAllBccP(Set<EMailAddress> tos) {
		return bccAddresses.removeAll(tos);
	}
	
	protected synchronized boolean addAttachmentP(I_StorageIdentifier id) throws InvalidParameterException {
		validateAttachemt(id);
		return attachments.add(id);
	}

	private void validateAttachemt(I_StorageIdentifier id)
			throws InvalidParameterException {
		if (id == null) {
			throw new InvalidParameterException(
					ModelsCoreConstantsObtainer.getConstants().getEMailRequiresANonNullAttachemt(), ADD_ATTACHMENT);
		}
		if (!id.hasValue()) {
			throw new InvalidParameterException(
					ModelsCoreConstantsObtainer.getConstants().getEMailRequiresAValidAttachemt(), ADD_ATTACHMENT);
		}
	}

	protected synchronized boolean removeAttachmentP(I_StorageIdentifier id) {
		return attachments.remove(id);
	}	
	
	protected synchronized boolean addAllAttachmentsP(Set<I_StorageIdentifier> tos) throws InvalidParameterException {
		for (I_StorageIdentifier ea: tos) {
			validateAttachemt(ea);
			attachments.add(ea);
		}
		return true;
	}

	protected synchronized boolean removeAllAttachmentsP(Set<I_StorageIdentifier> tos) {
		return attachments.removeAll(tos);
	}

	public I_StorageIdentifier getId() {
		return id;
	}

	protected void setIdP(I_StorageIdentifier id) throws InvalidParameterException {
		this.id = CommonModel.getIdClone(id);
	}
}
