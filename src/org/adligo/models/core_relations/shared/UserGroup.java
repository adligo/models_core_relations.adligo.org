package org.adligo.models.core_relations.shared;

import java.util.Set;

import org.adligo.i.util.shared.I_Immutable;
import org.adligo.models.core.shared.I_CustomInfo;
import org.adligo.models.core.shared.I_Org;
import org.adligo.models.core.shared.I_OrgMutant;
import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core.shared.I_StorageInfo;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.Org;
import org.adligo.models.core.shared.ValidationException;


public class UserGroup implements I_UserGroup, I_Immutable {
	private UserGroupMutant mutant;
	private I_Org org;
	
	public UserGroup() {
		mutant = new UserGroupMutant();
	}
	
	public UserGroup(I_UserGroup other) throws InvalidParameterException {
		mutant = new UserGroupMutant(other);
		I_Org p_org = other.getOrg();
		org = new Org(p_org);
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

	public I_Org getOrg() {
		return org;
	}


	public I_CustomInfo getCustomInfo() {
		return org.getCustomInfo();
	}

	public I_StorageInfo getStorageInfo() {
		return org.getStorageInfo();
	}

	public boolean isStored() throws ValidationException {
		return mutant.isStored();
	}
}
