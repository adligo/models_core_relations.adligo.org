package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class UserGroupMutant extends UserGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserGroupMutant() {
		roles = new HashSet<String>();
	}
	

	public void addRole(String p) {
		roles.add(p);
	}
	
	public void addRoles(Collection<String> p) {
		roles.addAll(p);
	}
}
