package org.adligo.models.core_relations.shared;

import java.util.Set;

import org.adligo.models.core.shared.I_Org;
import org.adligo.models.core.shared.I_Storable;

public interface I_UserGroup extends I_Org, I_Storable {
	public I_Org getOrg();
	public abstract Set<String> getRoles();
}