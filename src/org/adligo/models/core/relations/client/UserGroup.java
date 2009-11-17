package org.adligo.models.core.relations.client;

import java.util.Collections;
import java.util.Set;

import org.adligo.i.util.client.I_Serializable;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.Organization;


public class UserGroup implements I_Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Organization org;
	protected Set<String> roles;
	
	/**
	 * for gwt serialization
	 */
	public UserGroup() {}
	
	public UserGroup(UserGroup group) throws InvalidParameterException {
		org = new Organization(group.org);
		roles = group.roles;
	}
	
	public Set<String> getRoles() {
		if (roles != null) {
			return Collections.unmodifiableSet(roles);
		}
		return null;
	}
}
