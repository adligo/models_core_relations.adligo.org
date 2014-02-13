package org.adligo.models.core_relations.shared;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.adligo.i.util.shared.ClassUtils;
import org.adligo.i.util.shared.I_Immutable;
import org.adligo.i.util.shared.StringUtils;
import org.adligo.models.core.shared.I_CustomInfo;
import org.adligo.models.core.shared.I_NamedId;
import org.adligo.models.core.shared.I_Organization;
import org.adligo.models.core.shared.I_OrganizationMutant;
import org.adligo.models.core.shared.I_StorageInfo;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ModelsCoreConstantsObtainer;
import org.adligo.models.core.shared.Organization;
import org.adligo.models.core.shared.ValidationException;
import org.adligo.models.core.shared.ids.I_StorageIdentifier;


public class UserGroup implements I_UserGroup, I_Immutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserGroupMutant mutant;
	private I_Organization org;
	
	public UserGroup() {
		mutant = new UserGroupMutant();
	}
	
	public UserGroup(I_UserGroup other) throws InvalidParameterException {
		mutant = new UserGroupMutant(other);
		I_Organization p_org = other.getOrg();
		try {
			org = p_org.toImmutable();
		} catch (ValidationException ve) {
			throw new InvalidParameterException(ve);
		}
	}

	public Set<String> getRoles() {
		return mutant.getRoles();
	}

	public I_StorageIdentifier getId() {
		return org.getId();
	}

	public String getName() {
		return org.getName();
	}

	public I_StorageIdentifier getType() {
		return org.getType();
	}

	@Override
	public void isValid() throws ValidationException {
		mutant.isValid();
	}

	@Override
	public String getImmutableFieldName() {
		return "mutant";
	}

	public I_Organization getOrg() {
		return org;
	}

	public I_Organization toImmutable() throws ValidationException {
		return org.toImmutable();
	}

	public I_OrganizationMutant toMutant() throws ValidationException {
		return org.toMutant();
	}

	public I_CustomInfo getCustomInfo() {
		return org.getCustomInfo();
	}

	public I_StorageInfo getStorageInfo() {
		return org.getStorageInfo();
	}

	public Integer getVersion() {
		return org.getVersion();
	}

	public boolean isStored() throws ValidationException {
		return mutant.isStored();
	}
}
