package org.adligo.models.core_relations.shared;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.adligo.i.util.shared.ClassUtils;
import org.adligo.i.util.shared.StringUtils;
import org.adligo.models.core.shared.I_CustomInfo;
import org.adligo.models.core.shared.I_Organization;
import org.adligo.models.core.shared.I_OrganizationMutant;
import org.adligo.models.core.shared.I_Storable;
import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core.shared.I_StorageInfo;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ModelsCoreConstantsObtainer;
import org.adligo.models.core.shared.Organization;
import org.adligo.models.core.shared.StorableValidator;
import org.adligo.models.core.shared.ValidationException;

public class UserGroupMutant implements I_UserGroup {
	public static final String USER_GROUP = "UserGroup";
	public static final String ADD_ROLE = "addRole";
	public static final String ADD_ALL_ROLES = "addAllRoles";
	/**
	 * id is handled by org
	 */
	protected Organization org;
	protected Set<String> roles = new HashSet<String>();
	
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

	public I_StorageIdentifier getType() {
		if (org != null) {
			return org.getType();
		}
		return null;
	}

	public void isValid() throws ValidationException{
		if (org != null) {
			org.isValid();
		}
	}
	
	public String toString() {
		return toString(this.getClass());
	}
	
	public String toString(Class<?> c) {
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

	@Override
	public I_CustomInfo getCustomInfo() {
		if (org == null) {
			return null;
		}
		return org.getCustomInfo();
	}

	@Override
	public I_StorageInfo getStorageInfo() {
		if (org == null) {
			return null;
		}
		return org.getStorageInfo();
	}

	@Override
	public Integer getVersion() {
		if (org == null) {
			return null;
		}
		return org.getVersion();
	}

	@Override
	public I_Organization toImmutable() throws ValidationException {
		if (org == null) {
			return null;
		}
		return org.toImmutable();
	}

	@Override
	public I_OrganizationMutant toMutant() throws ValidationException {
		if (org == null) {
			return null;
		}
		return org.toMutant();
	}

	public boolean isStored() throws ValidationException {
		return StorableValidator.validate(this, I_Storable.IS_STORED);
	}
}
