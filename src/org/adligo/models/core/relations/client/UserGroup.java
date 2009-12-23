package org.adligo.models.core.relations.client;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.I_NamedId;
import org.adligo.models.core.client.I_SerializableStorageIdentifier;
import org.adligo.models.core.client.I_StorageIdentifier;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreConstantsObtainer;
import org.adligo.models.core.client.Organization;


public class UserGroup implements I_SerializableUserGroup {
	public static final String USER_GROUP = "UserGroup";
	public static final String ADD_ROLE = "addRole";
	public static final String ADD_ALL_ROLES = "addAllRoles";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * id is handled by org
	 */
	protected Organization org;
	protected Set<String> roles;
	
	/**
	 * for gwt serialization
	 */
	public UserGroup() {}
	
	public UserGroup(I_UserGroup group) throws InvalidParameterException {
		try {
			org = new Organization(group);
			if (group.getRoles() != null) {
				if (group.getRoles().size() >= 1) {
					addAllRolesP(group.getRoles());
				}
			}
		} catch (InvalidParameterException  x) {
			InvalidParameterException ipe = new InvalidParameterException(x.getMessage(), USER_GROUP);
			ipe.initCause(x);
			throw ipe;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_UserGroup#getRoles()
	 */
	public Set<String> getRoles() {
		return Collections.unmodifiableSet(getRolesP());
	}

	protected Set<String> getRolesP() {
		if (roles == null) {
			roles = new HashSet<String>();
		}
		return roles;
	}
	
	void addAllRolesP(Collection<String> p_roles) throws InvalidParameterException {
		if (p_roles.contains("") || p_roles.contains(null)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserGroupEmptyRoleError(), ADD_ALL_ROLES);
		}
		getRolesP().addAll(p_roles);
	}
	
	void addRoleP(String p_role) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_role)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserGroupEmptyRoleError(), ADD_ROLE);
		}
		getRolesP().add(p_role);
	}
	

	public I_StorageIdentifier getId() {
		if (org != null) {
			return org.getId();
		}
		return null;
	}

	public String getName() {
		if (org != null) {
			return org.getName();
		}
		return null;
	}

	public I_NamedId getType() {
		if (org != null) {
			return org.getType();
		}
		return null;
	}

	public boolean isValid() {
		if (org != null) {
			return org.isValid();
		}
		return false;
	}
	
	public String toString() {
		return toString(this.getClass());
	}
	
	public String toString(Class c) {
		StringBuilder sb = new StringBuilder();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [org=");
		sb.append(org);
		sb.append(",roles=");
		sb.append(roles);
		sb.append("]");
		return sb.toString();
	}

}
