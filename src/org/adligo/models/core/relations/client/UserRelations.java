package org.adligo.models.core.relations.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.i.util.client.I_Immutable;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMailAddress;
import org.adligo.models.core.client.I_Organization;
import org.adligo.models.core.client.I_Person;
import org.adligo.models.core.client.I_Storable;
import org.adligo.models.core.client.I_StorageInfo;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.I_UserMutant;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.User;
import org.adligo.models.core.client.ValidationException;
import org.adligo.models.core.client.ids.I_StorageIdentifier;


public class UserRelations implements I_UserRelations, I_Immutable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserRelationsMutant wrapped;
	@SuppressWarnings("unchecked")
	private Set<String> roles = Collections.EMPTY_SET;
	/**
	 * the list of groups that the user belongs to
	 */
	@SuppressWarnings("unchecked")
	private Set<String> groups = Collections.EMPTY_SET;
	
	/**
	 * the user could pertain to either a user or a organization
	 */
	private I_User user;
	private I_Person person;
	private I_Organization org;
	
	public UserRelations() {
		wrapped = new UserRelationsMutant();
	}

	public UserRelations(I_User user) throws InvalidParameterException {
		wrapped = new UserRelationsMutant(user);
		user = new User(user);
	}
	
	public UserRelations(I_UserRelations p) throws InvalidParameterException {
		wrapped = new UserRelationsMutant(p);
		user = new User(p.getUser());
		I_Person psn = p.getPerson();
		if (psn != null) {
			person = new Person(psn);
		}
		I_Organization org = p.getOrg();
		if (org != null) {
			org = new Organization(org);
		}
		roles = new HashSet<String>(p.getRoles());
		groups = new HashSet<String>(p.getGroups());
	}


	public I_Person getPerson() {
		return person;
	}

	public I_Organization getOrg() {
		return org;
	}



	protected UserRelationsMutant getWrapped() {
		return wrapped;
	}

	public String getDn() {
		return wrapped.getDn();
	}

	public DomainName getDomain() {
		return wrapped.getDomain();
	}

	public EMailAddress getEmail() {
		return wrapped.getEmail();
	}

	public I_StorageIdentifier getId() {
		return user.getId();
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
		return groups;
	}


	public Set<String> getRoles() {
		return roles;
	}

	public I_User getUser() {
		return user;
	}

	@Override
	public String getImmutableFieldName() {
		return "wrapped";
	}

	@Override
	public I_StorageInfo getStorageInfo() {
		return user.getStorageInfo();
	}

	@Override
	public I_User toImmutable() throws ValidationException {
		return user.toImmutable();
	}

	@Override
	public I_UserMutant toMutant() throws ValidationException {
		return user.toMutant();
	}

	@Override
	public boolean isStored() throws ValidationException {
		return wrapped.isStored();
	}
	
	
}
