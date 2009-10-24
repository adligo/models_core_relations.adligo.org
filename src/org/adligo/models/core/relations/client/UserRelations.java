package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.User;

/**
 * may be used a surrogate for a LDAP i_netOrgUser
 * @author scott
 *
 */
public class UserRelations extends User implements I_User, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Set<String> roles;
	protected Set<String> groups;
	protected Person person;
	
	protected UserRelations() {}
	
	public UserRelations(UserRelations p) {
		super(p);
		
		if (p.roles != null) {
			roles = Collections.unmodifiableSet(p.roles);
		}
		if (p.groups != null) {
			groups = Collections.unmodifiableSet(p.groups);
		}
		person = p.person;
	}
	
	public String getUserName() {
		if (person != null) {
			return person.getName();
		}
		return super.getName();
	}

	public boolean isUserInRole(String role) {
		if (roles != null) {
			if (role.contains(role)) {
				return true;
			}
		}
		return false;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public Set<String> getGroups() {
		return groups;
	}

	public Person getPerson() {
		return person;
	}

}
