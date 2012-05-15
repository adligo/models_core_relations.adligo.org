package org.adligo.models.core.relations.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.i.util.client.I_Immutable;
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
public class EMail implements I_EMail, I_Immutable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EMailMutant mutant;
	private I_StorageIdentifier id;
	private Set<I_StorageIdentifier> attachments;
	
	public EMail() {}
	
	public EMail(I_EMail other) throws InvalidParameterException {
		mutant = new EMailMutant(other);
		
		Set<I_StorageIdentifier> toRet = new HashSet<I_StorageIdentifier>();
		attachments = new HashSet<I_StorageIdentifier>();
		for (I_StorageIdentifier id: other.getAttachments()) {
			toRet.add(id.toImmutable());
		}
		attachments = Collections.unmodifiableSet(attachments);
		I_StorageIdentifier otherId = other.getId();
		if (id != null) {
			id = otherId.toImmutable();
		}
	}
	@Override
	public I_StorageIdentifier getId() {
		I_StorageIdentifier id = mutant.getId();
		try {
			id.toImmutable();
		} catch (InvalidParameterException e) {
			throw new IllegalStateException("There was a problem turning the follwing object into a immutable " +id);
		}
		return null;
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

}
