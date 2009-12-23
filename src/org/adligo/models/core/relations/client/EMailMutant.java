package org.adligo.models.core.relations.client;

import java.util.Set;

import org.adligo.models.core.client.EMailAddress;
import org.adligo.models.core.client.I_SerializableStorageIdentifier;
import org.adligo.models.core.client.InvalidParameterException;

public class EMailMutant implements I_EMail {
	private EMail delegate;
	
	public EMailMutant() {
		delegate = new EMail();
	}
	
	public EMailMutant(I_EMail other) throws InvalidParameterException {
		delegate = new EMail(other);
	}

	public Set<I_SerializableStorageIdentifier> getAttachments() {
		return delegate.getAttachments();
	}

	public Set<EMailAddress> getBCCs() {
		return delegate.getBCCs();
	}

	public String getBody() {
		return delegate.getBody();
	}

	public Set<EMailAddress> getCCs() {
		return delegate.getCCs();
	}

	public EMailAddress getFrom() {
		return delegate.getFrom();
	}

	public String getSubject() {
		return delegate.getSubject();
	}

	public Set<EMailAddress> getTOs() {
		return delegate.getTOs();
	}
	
	public void setFrom(EMailAddress from) throws InvalidParameterException {
		delegate.setFromP(from);
	}
	
	public void setSubject(String subject) {
		delegate.setSubject(subject);
	}
	
	public void setBody(String body) {
		delegate.setBody(body);
	}
	
	public synchronized boolean addTo(EMailAddress to) throws InvalidParameterException {
		return delegate.addToP(to);
	}
	
	public synchronized boolean removeTo(EMailAddress to) {
		return delegate.removeToP(to);
	}
	
	public synchronized boolean addAllTo(Set<EMailAddress> tos) throws InvalidParameterException {
		return delegate.addAllToP(tos);
	}
	
	public synchronized boolean removeAllTo(Set<EMailAddress> tos) {
		return delegate.removeAllToP(tos);
	}
	
	public synchronized boolean addCc(EMailAddress to) throws InvalidParameterException {
		return delegate.addCcP(to);
	}
	
	public synchronized boolean removeCc(EMailAddress to) {
		return delegate.removeCcP(to);
	}
	
	public synchronized boolean addAllCc(Set<EMailAddress> tos) throws InvalidParameterException {
		return delegate.addAllCcP(tos);
	}
	
	public synchronized boolean removeAllCc(Set<EMailAddress> tos) {
		return delegate.removeAllCcP(tos);
	}
	
	public synchronized boolean addBcc(EMailAddress to) throws InvalidParameterException {
		return delegate.addBccP(to);
	}
	
	public synchronized boolean removeBcc(EMailAddress to) {
		return delegate.removeBccP(to);
	}	
	
	public synchronized boolean addAllBcc(Set<EMailAddress> tos) throws InvalidParameterException {
		return delegate.addAllBccP(tos);
	}
	
	public synchronized boolean removeAllBcc(Set<EMailAddress> tos) {
		return delegate.removeAllBccP(tos);
	}
	
	public synchronized boolean addAttachment(I_SerializableStorageIdentifier id) throws InvalidParameterException {
		return delegate.addAttachmentP(id);
	}

	public synchronized boolean removeAttachment(I_SerializableStorageIdentifier id) {
		return delegate.removeAttachmentP(id);
	}	
	
	public synchronized boolean addAllAttachments(Set<I_SerializableStorageIdentifier> tos) throws InvalidParameterException {
		return delegate.addAllAttachmentsP(tos);
	}
	
	public synchronized boolean removeAllAttachments(Set<I_SerializableStorageIdentifier> tos) {
		return delegate.removeAllAttachmentsP(tos);
	}

	public I_SerializableStorageIdentifier getId() {
		return delegate.getId();
	}
}
