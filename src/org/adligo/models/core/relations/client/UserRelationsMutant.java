package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.OrganizationMutant;
import org.adligo.models.core.client.PersonMutant;
import org.adligo.models.core.client.StorageIdentifier;
import org.adligo.models.core.client.UserMutant;

public class UserRelationsMutant extends UserRelations implements I_User, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserMutant user_mutant = new UserMutant();
	PersonMutant person_mutant = new PersonMutant();
	OrganizationMutant org_mutant = new OrganizationMutant();

	private void init() {
		roles = new HashSet<String>();
		groups = new HashSet<String>();
		user = user_mutant;
		person = person_mutant;
		org = org_mutant;
	}
	
	public UserRelationsMutant() {
		init();
	}

	public UserRelationsMutant(UserRelations p) throws InvalidParameterException {
		super(p);
		init();
	}
	
	public void setUserId(StorageIdentifier id) throws InvalidParameterException {
		user_mutant.setId(id);
	}
	
	public void setPersonId(StorageIdentifier id) throws InvalidParameterException {
		person_mutant.setId(id);
	}
	
	public void addAllRoles(Collection<String> p_roles) throws InvalidParameterException {
		if (p_roles.contains("")) {
			throw new InvalidParameterException("Can't add a empty role to UserRelationsMutant.", "addAllRoles");
		} else if (p_roles.contains(null)) {
			throw new InvalidParameterException("Can't add a null role to UserRelationsMutant.", "addAllRoles");
		}
		roles.addAll(p_roles);
	}
	
	public void addAllGroups(Collection<String> p_groups) throws InvalidParameterException  {
		if (p_groups.contains("")) {
			throw new InvalidParameterException("Can't add a empty group to UserRelationsMutant.", "addAllGroups");
		} else if (p_groups.contains(null)) {
			throw new InvalidParameterException("Can't add a null group to UserRelationsMutant.", "addAllGroups");
		}
		groups.addAll(p_groups);
	}

	public void setFirst_name(String firstName) {
		person_mutant.setFirst_name(firstName);
	}

	public void setLast_name(String lastName) {
		person_mutant.setLast_name(lastName);
	}

	public void setMiddle_name(String middleName) {
		person_mutant.setMiddle_name(middleName);
	}

	public void setDomain(String domain) throws InvalidParameterException {
		user_mutant.setDomain(domain);
	}

	public void setName(String name) throws InvalidParameterException {
		user_mutant.setName(name);
	}

	public void setPassword(String password) throws InvalidParameterException {
		user_mutant.setPassword(password);
	}
	
	public void setOrganizationName(String name) throws InvalidParameterException {
		org_mutant.setName(name);
	}
	
	public void setOrganizationId(StorageIdentifier id) throws InvalidParameterException {
		org_mutant.setId(id);
	}
	
	public StorageIdentifier getUserId() {
		return user_mutant.getId();
	}
}
