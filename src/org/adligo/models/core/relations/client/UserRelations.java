package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.User;
import org.adligo.models.core.client.UserMutant;

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
	protected Set<String> roles = new HashSet<String>();
	/**
	 * the list of groups that the user belongs to
	 */
	protected Set<String> groups = new HashSet<String>();
	
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
		roles.addAll(p.roles);
		groups.addAll(p.groups);
		
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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ClassUtils.getClassShortName(UserRelations.class));
		appendFields(sb);
		return sb.toString();
	}
	
	protected void appendFields(StringBuilder sb) {
		sb.append(" [user=");
		sb.append(user);
		sb.append(",person=");
		sb.append(person);
		sb.append(",org=");
		sb.append(org);
		sb.append(",roles=");
		sb.append(roles.size());
		sb.append(",groups=");
		sb.append(groups.size());
		sb.append("]");
	}
}
