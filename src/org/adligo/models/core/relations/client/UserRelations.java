package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.DomainName;
import org.adligo.models.core.client.EMailAddress;
import org.adligo.models.core.client.I_NamedId;
import org.adligo.models.core.client.I_Org;
import org.adligo.models.core.client.I_Person;
import org.adligo.models.core.client.I_StorageIdentifier;
import org.adligo.models.core.client.I_Subject;
import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.I_Validateable;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreConstantsObtainer;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.Person;
import org.adligo.models.core.client.StorageIdentifier;
import org.adligo.models.core.client.User;

/**
 * A class that represents all of the possible relations
 * that a User object may have, things should be lazy initialized
 * except for the user which represents the base of this relations object
 * 
 * may be used a surrogate for a LDAP i_netOrgUser
 * @author scott
 *
 */
public class UserRelations implements I_Subject, I_NamedId, I_SerializableUserRelations, I_Validateable {
	
	public static final String ADD_GROUP = "addGroup";
	public static final String ADD_ROLE = "addRole";
	public static final String ADD_ALL_GROUPS = "addAllGroups";
	public static final String ADD_ALL_ROLES = "addAllRoles";
	public static final String USER_RELATIONS = "UserRelations";
	
	public static final String USER_NAME_ALREADY_EXISTS_ERROR = "User name already exists for this domain name.";
	
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
	
	/**
	 * for gwt serialization
	 */
	public UserRelations() {}

	/**
	 * constructor for creating a new user
	 * when the person or organization is not used
	 * 
	 * @param p
	 * @throws InvalidParameterException
	 */
	public UserRelations(I_UserRelations p) throws InvalidParameterException {
		try {
			user = new User(p.getUser());
			if (p.getOrg() != null) {
				org = new Organization(p.getOrg());
			}
			if (p.getPerson() != null) {
				person = new Person(p.getPerson());
			}
			setGroupsRolesFromOther(p);
		} catch (InvalidParameterException ipe) {
			InvalidParameterException x = new InvalidParameterException(
					ipe.getMessage(),USER_RELATIONS);
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
	public UserRelations(I_User p) throws InvalidParameterException {
		try {
			user = new User(p);
		} catch (InvalidParameterException ipe) {
			InvalidParameterException x = new InvalidParameterException(
					ipe.getMessage(),USER_RELATIONS);
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
	public UserRelations(String p_user_name, String p_domain, Collection<String> p_roles) throws InvalidParameterException {
		try {
			user = new User(p_user_name, p_domain);
			if (p_roles != null) {
				addAllRolesP(p_roles);
			}
		} catch (InvalidParameterException ipe) {
			InvalidParameterException x = new InvalidParameterException(
					ipe.getMessage(),USER_RELATIONS);
			x.initCause(ipe);
			throw x;
		}
	}

	private void setGroupsRolesFromOther(I_UserRelations p)
			throws InvalidParameterException {
		if (p.getRoles() != null) {
			if (p.getRoles().size() >= 1) {
				addAllRolesP(p.getRoles());
			}
		}
		if (p.getGroups() != null) {
			if (p.getGroups().size() >= 1) {
				addAllGroupsP(p.getGroups());
			}
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
		if (roles != null && !StringUtils.isEmpty(role)) {
			if (roles.contains(role)) {
				return true;
			}
		}
		return false;
	}

	void addAllRolesP(Collection<String> p_roles) throws InvalidParameterException {
		if (p_roles.contains("") || p_roles.contains(null)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserRelationsEmptyRoleError(), ADD_ALL_ROLES);
		}
		getRolesP().addAll(p_roles);
	}
	
	void addAllGroupsP(Collection<String> p_groups) throws InvalidParameterException  {
		if (p_groups.contains("") || p_groups.contains(null)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserRelationsEmptyGroupError(), ADD_ALL_GROUPS);
		}
		getGroupsP().addAll(p_groups);
	}
	
	void addRolesP(String p_role) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_role)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserRelationsEmptyRoleError(), ADD_ROLE);
		}
		getRolesP().add(p_role);
	}
	
	void addGroupP(String p_group) throws InvalidParameterException  {
		if (StringUtils.isEmpty(p_group)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserRelationsEmptyGroupError(), ADD_GROUP);
		}
		getGroupsP().add(p_group);
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_UserRelations#getRoles()
	 */
	@SuppressWarnings("unchecked")
	public Set<String> getRoles() {
		if (roles == null) {
			return Collections.EMPTY_SET;
		}
		return Collections.unmodifiableSet(getRolesP());
	}

	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_UserRelations#getGroups()
	 */
	@SuppressWarnings("unchecked")
	public Set<String> getGroups() {
		if (groups == null) {
			return Collections.EMPTY_SET;
		}
		return Collections.unmodifiableSet(getGroupsP());
	}

	Set<String> getRolesP() {
		if (roles == null) {
			roles = new HashSet<String>();
		}
		return roles;
	}

	Set<String> getGroupsP() {
		if (groups == null) {
			groups = new HashSet<String>();
		}
		return groups;
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
	public I_Org getOrg() {
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

	/*
	 * 
	 * provide delegation methods only for the base User object
	 * 
	 */
	
	@Override
	public boolean isValid() {
		if (user == null) {
			return false;
		}
		if (!user.isValid()) {
			return false;
		}
		return true;
	}

	public DomainName getDomain() {
		if (user == null) {
			return null;
		}
		return user.getDomain();
	}

	public StorageIdentifier generate() throws InvalidParameterException {
		if (user == null) {
			return null;
		}
		return user.generate();
	}

	public EMailAddress getEmail() {
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
}
