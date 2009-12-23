package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.InvalidParameterException;

public class UserGroupMutant extends UserGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserGroupMutant() {
		roles = new HashSet<String>();
	}
	

	public void addRole(String p) throws InvalidParameterException {
		if (StringUtils.isEmpty(p)) {
			throw new InvalidParameterException("Can't add a empty role to UserGroupMutant.", "addRole");
		}
		roles.add(p);
	}
	
	public void addRoles(Collection<String> p) throws InvalidParameterException {
		if (p.contains(null)) {
			throw new InvalidParameterException("Can't add a null role to UserGroupMutant.", "addRoles");
		} else if (p.contains("")) {
			throw new InvalidParameterException("Can't add a empty role to UserGroupMutant.", "addRoles");
		}
		roles.addAll(p);
	}
}
