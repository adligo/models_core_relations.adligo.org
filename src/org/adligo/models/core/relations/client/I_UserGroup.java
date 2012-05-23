package org.adligo.models.core.relations.client;

import java.util.Set;

import org.adligo.models.core.client.I_Organization;
import org.adligo.models.core.client.I_Storable;

public interface I_UserGroup extends I_Organization, I_Storable {
	public I_Organization getOrg();
	public abstract Set<String> getRoles();
}