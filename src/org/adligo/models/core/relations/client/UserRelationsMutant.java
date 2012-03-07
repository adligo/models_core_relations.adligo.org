package org.adligo.models.core.relations.client;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.I_DomainName;
import org.adligo.models.core.client.I_EMailAddress;
import org.adligo.models.core.client.I_Organization;
import org.adligo.models.core.client.I_Person;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.I_UserMutant;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreConstantsObtainer;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.User;
import org.adligo.models.core.client.UserMutant;
import org.adligo.models.core.client.ids.I_StorageIdentifier;

/**
 * A class that represents all of the possible relations
 * that a User object may have, things should be lazy initialized
 * except for the user which represents the base of this relations object
 * 
 * may be used a surrogate for a LDAP i_netOrgUser
 * @author scott
 *
 */
public class UserRelationsMutant implements I_UserRelationsMutant {
	
	public static final String ADD_GROUP = "addGroup";
	public static final String ADD_ROLE = "addRole";
	public static final String CONSTRUCTOR = "Constructor";
	public static final String CONSTRUCTOR_REQUIRES_USER = "The constructor requires a user object";
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
	protected I_UserMutant user = new UserMutant();
	protected I_Person person;
	protected I_Organization org;
	
	
	/**
	 * for gwt serialization
	 */
	public UserRelationsMutant() {}

	/**
	 * constructor for creating a new user
	 * when the person or organization is not used
	 * 
	 * @param p
	 * @throws InvalidParameterException
	 */
	public UserRelationsMutant(I_UserRelations p) throws InvalidParameterException {
		try {
			I_User o_user = p.getUser();
			if (o_user == null) {
				throw new InvalidParameterException(CONSTRUCTOR_REQUIRES_USER, CONSTRUCTOR);
			}
			user = new UserMutant(o_user);
			
			if (p.getPerson() != null) {
				person = new Person(p.getPerson());
			} else if (p.getOrg() != null) {
				org = new Organization(p.getOrg());
			}
			Collection<String> o_groups = p.getGroups();
			if (!o_groups.isEmpty()) {
				addGroups(o_groups);
			}
			Collection<String> o_roles = p.getRoles();
			if (!o_roles.isEmpty()) {
				addRoles(o_roles);
			}
		} catch (InvalidParameterException ipe) {
			InvalidParameterException x = new InvalidParameterException(
					ipe.getMessage(),CONSTRUCTOR);
			x.initCause(ipe);
			throw x;
		}
	}
	
	/**
	 * constructor for creating a new user
	 * when the person or organization is not used
	 * 
	 * @param p
	 * @throws InvalidParameterException
	 */
	public UserRelationsMutant(I_User p) throws InvalidParameterException {
		try {
			user = new UserMutant(p);
		} catch (InvalidParameterException ipe) {
			InvalidParameterException x = new InvalidParameterException(
					ipe.getMessage(),CONSTRUCTOR);
			x.initCause(ipe);
			throw x;
		}
	}
	
	/**
	 * constructor for creating a I_User to pass back to the client
	 * for client authentication checks to see if things are visible
	 * 
	 * @param p_user
	 * @param p_roles
	 * 
	 * @throws InvalidParameterException
	 */
	public UserRelationsMutant(String p_user_name, String p_domain, Collection<String> p_roles) throws InvalidParameterException {
		try {
			user = new UserMutant(p_user_name, p_domain);
			if (p_roles != null) {
				addRoles(p_roles);
			}
		} catch (InvalidParameterException ipe) {
			InvalidParameterException x = new InvalidParameterException(
					ipe.getMessage(),CONSTRUCTOR);
			x.initCause(ipe);
			throw x;
		}
	}

	
	public String getUserName() {
		if (user != null) {
			return user.getName();
		}
		return "";
	}

	public I_StorageIdentifier getId() {
		if (user != null) {
			return user.getId();
		}
		return null;
	}
	
	public boolean isUserInRole(String role) {
		if (!StringUtils.isEmpty(role)) {
			if (roles.contains(role)) {
				return true;
			}
		}
		return false;
	}

	public void addRoles(Collection<String> p_roles) throws InvalidParameterException {
		roles.clear();
		for (String role: p_roles) {
			addRole(role);
		}
	}
	
	public void addGroups(Collection<String> p_groups) throws InvalidParameterException  {
		groups.clear();
		for (String group: p_groups) {
			addGroup(group);
		}
	}
	
	public void addRole(String p_role) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_role)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserRelationsEmptyRoleError(), ADD_ROLE);
		}
		roles.add(p_role);
	}
	
	public void addGroup(String p_group) throws InvalidParameterException  {
		if (StringUtils.isEmpty(p_group)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserRelationsEmptyGroupError(), ADD_GROUP);
		}
		groups.add(p_group);
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_UserRelations#getRoles()
	 */
	public Set<String> getRoles() {
		return Collections.unmodifiableSet(roles);
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_UserRelations#getGroups()
	 */
	public Set<String> getGroups() {
		return Collections.unmodifiableSet(groups);
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_UserRelations#getPerson()
	 */
	public I_Person getPerson() {
		return person;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_UserRelations#getUser()
	 */
	public I_User getUser() {
		return user;
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_UserRelations#getOrg()
	 */
	public I_Organization getOrg() {
		return org;
	}

	public String toString() {
		return toString(this.getClass());
	}
	
	public String toString(Class c) {
		StringBuilder sb = new StringBuilder();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [user=");
		sb.append(user);
		sb.append(",person=");
		sb.append(person);
		sb.append(",org=");
		sb.append(org);
		sb.append(",roles=");
		sb.append(roles);
		sb.append(",groups=");
		sb.append(groups);
		sb.append("]");
		return sb.toString();
	}


	public I_DomainName getDomain() {
		if (user == null) {
			return null;
		}
		return user.getDomain();
	}

	public I_EMailAddress getEmail() {
		return user.getEmail();
	}

	public String getName() {
		return getUserName();
	}

	public String getPassword() {
		if (user != null) {
			return user.getPassword();
		}
		return null;
	}

	public String getDn() {
		return user.getDn();
	}

	@Override
	public void setRoles(Collection<String> p) throws InvalidParameterException {
		roles.clear();
		for (String role: p) {
			addRole(role);
		}
	}

	@Override
	public void setGroups(Collection<String> p)
			throws InvalidParameterException {
		groups.clear();
		for (String group: p) {
			addGroup(group);
		}
	}

	@Override
	public void setPerson(I_Person p) throws InvalidParameterException {
		person = p;
	}

	@Override
	public void setUser(I_User p) throws InvalidParameterException {
		user = new UserMutant(p);
	}

	@Override
	public void setOrg(I_Organization p) throws InvalidParameterException {
		org = p;
	}

	public void setName(String p) throws InvalidParameterException {
		user.setName(p);
	}

	public void setPassword(String p) throws InvalidParameterException {
		user.setPassword(p);
	}

	public void setEmail(I_EMailAddress p) throws InvalidParameterException {
		user.setEmail(p);
	}

	public void setDomain(I_DomainName d) throws InvalidParameterException {
		user.setDomain(d);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groups == null) ? 0 : groups.hashCode());
		result = prime * result + ((org == null) ? 0 : org.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		try {
			I_UserRelations other = (I_UserRelations) obj;
			if (groups == null) {
				if (other.getGroups() != null)
					return false;
			} else {
				Collection otherGroups = other.getGroups();
				if (groups.size() != otherGroups.size()) {
					return false;
				}
				if (!groups.containsAll(otherGroups)) {
					return false;
				}
			}
			if (org == null) {
				if (other.getOrg() != null)
					return false;
			} else if (!org.equals(other.getOrg()))
				return false;
			if (person == null) {
				if (other.getPerson() != null)
					return false;
			} else if (!person.equals(other.getPerson()))
				return false;
			if (roles == null) {
				if (other.getRoles() != null)
					return false;
			} else {
				Collection otherRoles = other.getRoles();
				if (roles.size() != otherRoles.size()) {
					return false;
				}
				if (!roles.containsAll(otherRoles)) {
					return false;
				}
			}
			if (user == null) {
				if (other.getUser() != null)
					return false;
			} else if (!user.equals(other.getUser()))
				return false;
		} catch (ClassCastException x) {
			return false;
		}
		return true;
	}
}
