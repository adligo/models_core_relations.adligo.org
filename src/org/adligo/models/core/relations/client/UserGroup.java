package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import org.adligo.models.core.client.Organization;

public class UserGroup extends Organization implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Set<String> roles;
	
	protected UserGroup() {}
	
	public UserGroup(UserGroup group) {
		super(group);
		roles = group.roles;
	}
	
	public Set<String> getRoles() {
		if (roles != null) {
			return Collections.unmodifiableSet(roles);
		}
		return null;
	}
}
