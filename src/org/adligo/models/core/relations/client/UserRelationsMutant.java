package org.adligo.models.core.relations.client;

import java.util.Collection;
import java.util.Set;

import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMail;
import org.adligo.models.core.client.I_Org;
import org.adligo.models.core.client.I_Person;
import org.adligo.models.core.client.I_StorageIdentifier;
import org.adligo.models.core.client.I_Subject;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.OrganizationMutant;
import org.adligo.models.core.client.PersonMutant;
import org.adligo.models.core.client.UserMutant;


public class UserRelationsMutant implements I_Subject, I_UserRelations {

	private UserRelations wrapped = new UserRelations();
	private UserMutant user_mutant;
	private PersonMutant person_mutant;
	private OrganizationMutant org_mutant;
	
	public UserRelationsMutant() {
		user_mutant = new UserMutant();
	}

	public UserRelationsMutant(I_User user) throws InvalidParameterException {
		user_mutant = new UserMutant(user);
	}
	
	public UserRelationsMutant(I_UserRelations p) throws InvalidParameterException {
		user_mutant = new UserMutant(p.getUser());
		if (p.getPerson() != null) {
			person_mutant = new PersonMutant(p.getPerson());
		}
		if (p.getOrg() != null) {
			org_mutant = new OrganizationMutant(p.getOrg());
		}
	}

	public void addAllRoles(Collection<String> p_roles) throws InvalidParameterException {
		wrapped.addAllRolesP(p_roles);
	}
	
	public void addAllGroups(Collection<String> p_groups) throws InvalidParameterException  {
		wrapped.addAllGroupsP(p_groups);
	}
	
	public void addRole(String p_role) throws InvalidParameterException {
		wrapped.addRolesP(p_role);
	}
	
	public void addGroup(String p_group) throws InvalidParameterException  {
		wrapped.addGroupP(p_group);
	}
	
	/*
	 * provide delegate methods only for the main User object
	 */
	public void setId(I_StorageIdentifier id) throws InvalidParameterException {
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

	public I_Person getPerson() {
		return person_mutant;
	}

	public void setPerson(I_Person person) throws InvalidParameterException {
		person_mutant = new PersonMutant(person);
	}

	public I_Org getOrg() {
		return org_mutant;
	}

	public void setOrg(I_Org org) throws InvalidParameterException {
		org_mutant = new OrganizationMutant(org);
	}

	protected UserMutant getUserMutant() {
		return user_mutant;
	}

	protected UserRelations getWrapped() {
		return wrapped;
	}

	public String getDn() throws InvalidParameterException {
		return user_mutant.getDn();
	}

	public DomainName getDomain() {
		return user_mutant.getDomain();
	}

	public EMail getEmail() {
		return user_mutant.getEmail();
	}

	public I_StorageIdentifier getId() {
		return user_mutant.getId();
	}

	public String getName() {
		return user_mutant.getName();
	}

	public String getPassword() {
		return user_mutant.getPassword();
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

	public boolean isValid() {
		return wrapped.isValid();
	}

	public Set<String> getRoles() {
		return wrapped.getRoles();
	}

	public I_User getUser() {
		return user_mutant;
	}
	
	
}
