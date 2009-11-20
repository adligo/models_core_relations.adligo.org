package org.adligo.models.core.relations.client;

import java.util.Collection;
import java.util.Set;

import org.adligo.models.core.client.I_NamedId;
import org.adligo.models.core.client.I_StorageIdentifier;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.OrganizationMutant;
import org.adligo.models.core.client.StorageIdentifier;

public class UserGroupMutant implements I_UserGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrganizationMutant org_mutant;
	private UserGroup wrapped;
	
	public UserGroupMutant() {
		wrapped = new UserGroup();
		org_mutant = new OrganizationMutant();
	}

	public UserGroupMutant(I_UserGroup other) throws InvalidParameterException {
		wrapped = new UserGroup(other);
		org_mutant = new OrganizationMutant(other);
	}
	
	public void addRole(String p) throws InvalidParameterException {
		wrapped.addRoleP(p);
	}
	
	public void addRoles(Collection<String> p) throws InvalidParameterException {
		wrapped.addAllRolesP(p);
	}

	public void setId(StorageIdentifier p) throws InvalidParameterException {
		org_mutant.setId(p);
	}

	public void setName(String p) throws InvalidParameterException {
		org_mutant.setName(p);
	}

	public void setType(NamedId p) throws InvalidParameterException {
		org_mutant.setType(p);
	}

	public I_StorageIdentifier getId() {
		return org_mutant.getId();
	}

	public String getName() {
		return org_mutant.getName();
	}

	public I_NamedId getType() {
		return org_mutant.getType();
	}

	public boolean isValid() {
		return org_mutant.isValid();
	}

	public String toString() {
		return wrapped.toString(this.getClass());
	}

	public Set<String> getRoles() {
		return wrapped.getRoles();
	}
}
