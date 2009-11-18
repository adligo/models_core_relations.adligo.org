package org.adligo.models.core.relations.client;

import java.util.Collection;
import java.util.HashSet;

import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.OrganizationMutant;
import org.adligo.models.core.client.StorageIdentifier;

public class UserGroupMutant extends UserGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrganizationMutant org_mutant;
	
	public UserGroupMutant() {
		org_mutant = new OrganizationMutant();
		//copy to super reference for gwt serialization
		org = org_mutant;
	}

	public void addRole(String p) throws InvalidParameterException {
		super.addRoleP(p);
	}
	
	public void addRoles(Collection<String> p) throws InvalidParameterException {
		super.addAllRolesP(p);
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
}
