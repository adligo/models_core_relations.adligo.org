package org.adligo.models.core.relations.client;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.i.adi.client.I_Invoker;
import org.adligo.i.adi.client.InvokerNames;
import org.adligo.i.adi.client.Registry;
import org.adligo.i.util.client.ClassUtils;
import org.adligo.i.util.client.I_Serializable;
import org.adligo.i.util.client.StringUtils;
import org.adligo.models.core.client.InvalidParameterException;
import org.adligo.models.core.client.ModelsCoreValidationConstantsObtainer;
import org.adligo.models.core.client.NamedId;
import org.adligo.models.core.client.Organization;
import org.adligo.models.core.client.StorageIdentifier;


public class UserGroup implements I_Serializable {
	private static final I_Invoker CONSTANTS_FACTORY = 
		Registry.getInvoker(InvokerNames.CONSTANTS_FACTORY);
	
	public static final String ADD_ROLE = "addRole";
	public static final String ADD_ALL_ROLES = "addAllRoles";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Organization org;
	protected Set<String> roles;
	
	/**
	 * for gwt serialization
	 */
	public UserGroup() {}
	
	public UserGroup(UserGroup group) throws InvalidParameterException {
		org = new Organization(group.org);
		if (group.roles != null) {
			addAllRolesP(group.roles);
		}
	}
	
	public Set<String> getRoles() {
		return Collections.unmodifiableSet(getRolesP());
	}

	protected Set<String> getRolesP() {
		if (roles == null) {
			roles = new HashSet<String>();
		}
		return roles;
	}
	
	protected void addAllRolesP(Collection<String> p_roles) throws InvalidParameterException {
		if (p_roles.contains("") || p_roles.contains(null)) {
			throw new InvalidParameterException(ModelsCoreValidationConstantsObtainer.getConstants()
					.getUserGroupEmptyRoleError(), ADD_ALL_ROLES);
		}
		getRolesP().addAll(p_roles);
	}
	
	protected void addRoleP(String p_role) throws InvalidParameterException {
		if (StringUtils.isEmpty(p_role)) {
			throw new InvalidParameterException(ModelsCoreValidationConstantsObtainer.getConstants()
					.getUserGroupEmptyRoleError(), ADD_ROLE);
		}
		getRolesP().add(p_role);
	}
	

	public StorageIdentifier getId() {
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

	public NamedId getType() {
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
		StringBuilder sb = new StringBuilder();
		sb.append(ClassUtils.getClassShortName(this.getClass()));
		sb.append(" [org=");
		sb.append(org);
		sb.append(",roles=");
		sb.append(roles);
		sb.append("]");
		return sb.toString();
	}
}
