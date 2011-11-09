package org.adligo.models.core.relations.client;

import java.util.Set;

import org.adligo.models.core.client.I_DomainName;
import org.adligo.models.core.client.I_EMailAddress;
import org.adligo.models.core.client.I_Organization;
import org.adligo.models.core.client.I_Person;
import org.adligo.models.core.client.I_StorageIdentifier;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.InvalidParameterException;


public class UserRelations implements I_UserRelations {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserRelationsMutant wrapped = new UserRelationsMutant();
	
	public UserRelations() {
	}

	public UserRelations(I_User user) throws InvalidParameterException {
		wrapped = new UserRelationsMutant(user);
	}
	
	public UserRelations(I_UserRelations p) throws InvalidParameterException {
		wrapped = new UserRelationsMutant(p);
	}


	public I_Person getPerson() {
		return wrapped.getPerson();
	}

	public I_Organization getOrg() {
		return wrapped.getOrg();
	}



	protected UserRelationsMutant getWrapped() {
		return wrapped;
	}

	public String getDn() {
		return wrapped.getDn();
	}

	public I_DomainName getDomain() {
		return wrapped.getDomain();
	}

	public I_EMailAddress getEmail() {
		return wrapped.getEmail();
	}

	public I_StorageIdentifier getId() {
		return wrapped.getId();
	}

	public String getName() {
		return wrapped.getName();
	}

	public String getPassword() {
		return wrapped.getPassword();
	}

	public String getUserName() {
		return wrapped.getUserName();
	}

	public boolean isUserInRole(String role) {
		return wrapped.isUserInRole(role);
	}

	public Set<String> getGroups() {
		return wrapped.getGroups();
	}


	public Set<String> getRoles() {
		return wrapped.getRoles();
	}

	public I_User getUser() {
		return wrapped.getUser();
	}
	
	
}
