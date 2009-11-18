package org.adligo.models.core.relations.client;

import java.util.Collection;

import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMail;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.OrganizationMutant;
import org.adligo.models.core.client.PersonMutant;
import org.adligo.models.core.client.StorageIdentifier;
import org.adligo.models.core.client.User;
import org.adligo.models.core.client.UserMutant;


public class UserRelationsMutant extends UserRelations implements I_User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserMutant user_mutant;
	PersonMutant person_mutant;
	OrganizationMutant org_mutant;
	
	public UserRelationsMutant() {
		user_mutant = new UserMutant();
		//copy to super for gwt serialization
		user = user_mutant;
	}

	public UserRelationsMutant(User user) throws InvalidParameterException {
		user_mutant = new UserMutant(user);
		//copy to super for gwt serialization
		user = user_mutant;
	}
	
	public UserRelationsMutant(UserRelations p) throws InvalidParameterException {
		super(p);
		user = user_mutant;
		user_mutant = new UserMutant(p.getUser());
		if (p.getPerson() != null) {
			person_mutant = new PersonMutant(p.getPerson());
			//copy to super for gwt serialization
			person = person_mutant;
		}
		if (p.getOrg() != null) {
			org_mutant = new OrganizationMutant(p.getOrg());
			//copy to super for gwt serialization
			org = org_mutant;
		}
	}
	
	public void addAllRoles(Collection<String> p_roles) throws InvalidParameterException {
		super.addAllRolesP(p_roles);
	}
	
	public void addAllGroups(Collection<String> p_groups) throws InvalidParameterException  {
		super.addAllGroupsP(p_groups);
	}
	
	public void addRoles(String p_role) throws InvalidParameterException {
		super.addRolesP(p_role);
	}
	
	public void addGroup(String p_group) throws InvalidParameterException  {
		super.addGroupP(p_group);
	}
	
	/*
	 * provide delegate methods only for the main User object
	 */
	public void setUserId(StorageIdentifier id) throws InvalidParameterException {
		user_mutant.setId(id);
	}
	
	public void setDomain(String domain) throws InvalidParameterException {
		user_mutant.setDomain(domain);
	}
	
	public void setDomain(DomainName domain) throws InvalidParameterException {
		user_mutant.setDomain(domain);
	}
	
	public void setEmail(EMail email) throws InvalidParameterException {
		user_mutant.setEmail(email);
	}

	public void setEmail(String email) throws InvalidParameterException {
		user_mutant.setEmail(email);
	}
	
	public void setName(String name) throws InvalidParameterException {
		user_mutant.setName(name);
	}

	public void setPassword(String password) throws InvalidParameterException {
		user_mutant.setPassword(password);
	}

	public PersonMutant getPerson_mutant() {
		return person_mutant;
	}

	public void setPerson_mutant(PersonMutant personMutant) {
		person_mutant = personMutant;
		//copy to super for gwt serialization
		person = person_mutant;
	}

	public OrganizationMutant getOrg_mutant() {
		return org_mutant;
	}

	public void setOrg_mutant(OrganizationMutant orgMutant) {
		org_mutant = orgMutant;
		//copy to super for gwt serialization
		org = org_mutant;
	}
}
