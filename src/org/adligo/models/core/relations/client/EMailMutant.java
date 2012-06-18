package org.adligo.models.core.relations.client;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.models.core.client.EMailAddress;
import org.adligo.models.core.client.I_Storable;
import org.adligo.models.core.client.I_StorageInfo;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreConstantsObtainer;
import org.adligo.models.core.client.StorableValidator;
import org.adligo.models.core.client.ValidationException;
import org.adligo.models.core.client.ids.I_StorageIdentifier;
import org.adligo.models.core.client.ids.StorageIdentifierValidator;

public class EMailMutant implements I_EMail {
	private static final long serialVersionUID = 1L;
	public static final String SET_ID = "setId";
	public static final String ADD_ATTACHMENT = "addAttachment";
	public static final String E_MAIL = "EMail";
	public static final String ADD_BCC = "addBCC";
	public static final String ADD_CC = "addCC";
	public static final String ADD_TO = "addTo";

	public static final String SET_FROM = "setFrom";
	private I_StorageIdentifier id;
	private I_StorageInfo storageInfo;
	private EMailAddress from;
	private String subject;
	private String body;
	private Set<EMailAddress> toAddresses = new HashSet<EMailAddress>();
	private Set<EMailAddress> ccAddresses = new HashSet<EMailAddress>();
	private Set<EMailAddress> bccAddresses = new HashSet<EMailAddress>();
	private Set<I_StorageIdentifier> attachments = new HashSet<I_StorageIdentifier>();
	
	public EMailMutant() {}
	
	public EMailMutant(I_EMail other) throws InvalidParameterException {
		try {
			if (other.getId() != null) {
				setId(other.getId());
			}
			setFrom(other.getFrom());
			subject = other.getSubject();
			body = other.getBody();
			toAddresses.addAll(other.getToAddresses());
			ccAddresses.addAll(other.getCcAddresses());
			bccAddresses.addAll(other.getBccAddresses());
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
	
	public void setFrom(EMailAddress from) throws InvalidParameterException {
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
	public void setSubject(String subject) throws InvalidParameterException {
		this.subject = subject;
	}
	public void setBody(String body) throws InvalidParameterException {
		this.body = body;
	}
	
	public Set<I_StorageIdentifier> getAttachments() {
		return Collections.unmodifiableSet(attachments);
	}
	
	public Set<EMailAddress> getBccAddresses() {
		return Collections.unmodifiableSet(bccAddresses);
	}
	
	public Set<EMailAddress> getCcAddresses() {
		return Collections.unmodifiableSet(ccAddresses);
	}
	
	public Set<EMailAddress> getToAddresses() {
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

	public boolean addTo(EMailAddress to) throws InvalidParameterException {
		validateAddr(to, ADD_TO);
		return toAddresses.add(to);
	}
	
	public boolean removeTo(EMailAddress to) {
		return toAddresses.remove(to);
	}
	
	public boolean setToAddresses(Collection<EMailAddress> tos) throws InvalidParameterException {
		toAddresses.clear();
		for (EMailAddress ea: tos) {
			validateAddr(ea, ADD_TO);
			toAddresses.add(ea);
		}
		return true;
	}
	
	public boolean removeAllTo(Collection<EMailAddress> tos) {
		return toAddresses.removeAll(tos);
	}
	
	public boolean addCcAddresses(EMailAddress to) throws InvalidParameterException {
		validateAddr(to, ADD_CC);
		return ccAddresses.add(to);
	}
	
	public boolean removeCc(EMailAddress to) {
		return ccAddresses.remove(to);
	}
	
	public boolean setCcAddresses(Collection<EMailAddress> tos) throws InvalidParameterException {
		if (tos == null) {
			throw new InvalidParameterException(
					ModelsCoreConstantsObtainer.getConstants().getEMailRequiresAValidAddress(), ADD_CC);
		}
		ccAddresses.clear();
		for (EMailAddress ea: tos) {
			validateAddr(ea, ADD_CC);
			ccAddresses.add(ea);
		}
		return true;
	}
	
	public boolean removeAllCc(Collection<EMailAddress> tos) {
		return ccAddresses.removeAll(tos);
	}
	
	public boolean addBcc(EMailAddress to) throws InvalidParameterException {
		validateAddr(to, ADD_BCC);
		return bccAddresses.add(to);
	}
	
	public boolean removeBcc(EMailAddress to) {
		return bccAddresses.remove(to);
	}	
	
	public boolean setBccAddresses(Collection<EMailAddress> tos) throws InvalidParameterException {
		bccAddresses.clear();
		for (EMailAddress ea: tos) {
			validateAddr(ea, ADD_BCC);
			bccAddresses.add(ea);
		}
		return true;
	}
	
	public boolean removeAllBcc(Collection<EMailAddress> tos) {
		return bccAddresses.removeAll(tos);
	}
	
	public boolean addAttachment(I_StorageIdentifier id) throws InvalidParameterException {
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
	
	public boolean removeAttachment(I_StorageIdentifier id) {
		return attachments.remove(id);
	}	
	
	public boolean setAttachments(Collection<I_StorageIdentifier> tos) throws InvalidParameterException {
		attachments.clear();
		for (I_StorageIdentifier ea: tos) {
			validateAttachemt(ea);
			attachments.add(ea);
		}
		return true;
	}

	public boolean removeAllAttachments(Set<I_StorageIdentifier> tos) {
		return attachments.removeAll(tos);
	}

	public I_StorageIdentifier getId() {
		return id;
	}

	public void setId(I_StorageIdentifier p) throws InvalidParameterException {
		StorageIdentifierValidator.validateId(p, this.getClass(), SET_ID);
		id = p;
	}

	@Override
	public I_StorageInfo getStorageInfo() {
		return storageInfo;
	}
	
	public void setStorageInfo(I_StorageInfo info) throws InvalidParameterException {
		storageInfo = info;
	}

	public boolean isStored() throws ValidationException {
		return StorableValidator.validate(this, I_Storable.IS_STORED);
	}
}
