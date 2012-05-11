package org.adligo.models.core.relations.client;

import java.util.Collection;
import java.util.Set;

import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.I_NamedId;
import org.adligo.models.core.client.I_Organization;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreConstantsObtainer;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.ids.I_StorageIdentifier;

public class UserGroupMutant implements I_UserGroup {
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
	public UserGroupMutant() {}
	
	public UserGroupMutant(I_UserGroup group) throws InvalidParameterException {
		try {
			setOrg(group);
			if (group.getRoles() != null) {
				if (group.getRoles().size() >= 1) {
					setRoles(group.getRoles());
				}
			}
		} catch (InvalidParameterException  x) {
			throw new InvalidParameterException(x.getMessage(), USER_GROUP, x);
		}
	}
	


	public Set<String> getRoles() {
		return roles;
	}
	
	public void setRoles(Collection<String> p_roles) throws InvalidParameterException {
		if (p_roles.contains("") || p_roles.contains(null)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserGroupEmptyRoleError(), ADD_ALL_ROLES);
		}
		roles.clear();
		roles.addAll(p_roles);
	}
	
	public void addRole(String p_role) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_role)) {
			throw new InvalidParameterException(ModelsCoreConstantsObtainer.getConstants()
					.getUserGroupEmptyRoleError(), ADD_ROLE);
		}
		roles.add(p_role);
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

	public I_Organization getOrg() {
		return org;
	}

	public void setOrg(I_Organization other) throws InvalidParameterException {
		this.org = new Organization(other);
	}

}
