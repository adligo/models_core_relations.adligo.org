package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.Organization;

public class UserGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Organization org;
	protected Set<String> roles;
	
	protected UserGroup() {}
	
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
