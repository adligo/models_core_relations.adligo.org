package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.User;

/**
 * may be used a surrogate for a LDAP i_netOrgUser
 * @author scott
 *
 */
public class UserRelations implements I_User, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * the list of roles in all of the groups
	 */
	protected Set<String> roles;
	/**
	 * the list of groups that the user belongs to
	 */
	protected Set<String> groups;
	
	/**
	 * the user could pertain to either a user or a organization
	 */
	protected User user;
	protected Person person;
	protected Organization org;
	
	
	protected UserRelations() {}
	
	public UserRelations(UserRelations p) throws InvalidParameterException {
		if (p.user != null) {
			user = new User(p.user);
		}
		if (p.org != null) {
			org = new Organization(p.org);
		}
		roles = p.roles;
		groups = p.groups;
		if (p.person != null) {
			person = new Person(p.person);
		}
	}
	
	public String getUserName() {
		if (org != null) {
			return org.getName();
		}
		if (person != null) {
			return person.getName();
		}
		if (user != null) {
			return user.getName();
		}
		return "";
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
		if (roles != null) {
			return Collections.unmodifiableSet(roles);
		}
		return null;
	}

	public Set<String> getGroups() {
		if (groups != null) {
			return Collections.unmodifiableSet(groups);
		}
		return null;
	}

	public Person getPerson() {
		return person;
	}
	
	public User getUser() {
		return user;
	}

	public Organization getOrg() {
		return org;
	}

}
