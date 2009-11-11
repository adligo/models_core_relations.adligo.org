package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collection;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMail;
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
	UserMutant user_mutant;
	PersonMutant person_mutant;
	OrganizationMutant org_mutant;

	private void init() {
		user = user_mutant;
		person = person_mutant;
		org = org_mutant;
	}
	
	public UserRelationsMutant() {
		user_mutant = new UserMutant();
		person_mutant = new PersonMutant();
		org_mutant = new OrganizationMutant();
		init();
	}

	public UserRelationsMutant(UserRelations p) throws InvalidParameterException {
		super(p);
		init();
		user_mutant = new UserMutant(p.getUser());
		person_mutant = new PersonMutant(p.getPerson());
		org_mutant = new OrganizationMutant(p.getOrg());
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

	public void setEmail(EMail email) throws InvalidParameterException {
		user_mutant.setEmail(email);
	}
	
	public void setEmail(String email) throws InvalidParameterException {
		user_mutant.setEmail(email);
	}
	
	public void setDomain(DomainName domain) throws InvalidParameterException  {
		user_mutant.setDomain(domain);
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
	
	public StorageIdentifier getId() {
		return user_mutant.getId();
	}
	
	public DomainName getDomain() {
		return user_mutant.getDomain();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ClassUtils.getClassShortName(UserRelations.class));
		appendFields(sb);
		return sb.toString();
	}
}
