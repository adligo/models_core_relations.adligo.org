package org.adligo.models.core_relations.shared;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.i.util.shared.I_Immutable;
import org.adligo.models.core.shared.EMailAddress;
import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core.shared.I_StorageInfo;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ValidationException;

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
public class EMail implements I_EMail, I_Immutable {

	private EMailMutant mutant;
	private I_StorageIdentifier id;
	private I_StorageInfo storageInfo;
	private Set<I_StorageIdentifier> attachments;
	
	public EMail() {}
	
	public EMail(I_EMail other) throws InvalidParameterException {
		mutant = new EMailMutant(other);
		
		Set<I_StorageIdentifier> toRet = new HashSet<I_StorageIdentifier>();
		attachments = new HashSet<I_StorageIdentifier>();
		for (I_StorageIdentifier id: other.getAttachments()) {
			toRet.add(id);
		}
		attachments = Collections.unmodifiableSet(attachments);
		I_StorageIdentifier otherId = other.getId();
		if (id != null) {
			id = otherId;
		}
		I_StorageInfo info = other.getStorageInfo();
		if (info != null) {
			try {
				storageInfo = (I_StorageInfo) info.toImmutable();
			} catch (ValidationException e) {
				throw new InvalidParameterException(e);
			}
		}
	}
	@Override
	public I_StorageIdentifier getId() {
		I_StorageIdentifier id = mutant.getId();
		return id;
	}
	
	@Override
	public String getImmutableFieldName() {
		return "mutant";
	}
	
	@Override
	public EMailAddress getFrom() {
		return mutant.getFrom();
	}
	
	@Override
	public String getSubject() {
		return mutant.getSubject();
	}
	
	@Override
	public String getBody() {
		return mutant.getBody();
	}
	
	@Override
	public Set<EMailAddress> getToAddresses() {
		return Collections.unmodifiableSet(mutant.getToAddresses());
	}
	
	@Override
	public Set<EMailAddress> getCcAddresses() {
		return Collections.unmodifiableSet(mutant.getCcAddresses());
	}
	
	@Override
	public Set<EMailAddress> getBccAddresses() {
		return Collections.unmodifiableSet(mutant.getBccAddresses());
	}
	
	@Override
	public Set<I_StorageIdentifier> getAttachments() {
		return attachments;
	}

	public I_StorageInfo getStorageInfo() {
		return storageInfo;
	}

	@Override
	public boolean isStored() throws ValidationException {
		return mutant.isStored();
	}

}
