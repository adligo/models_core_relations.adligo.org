package org.adligo.models.core.relations.client;

import java.util.Set;

import org.adligo.models.core.client.I_Org;
import org.adligo.models.core.client.I_Storable;

public interface I_UserGroup extends I_Org, I_Storable {

	public abstract Set<String> getRoles();

}