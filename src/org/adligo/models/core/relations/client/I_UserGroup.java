package org.adligo.models.core.relations.client;

import java.util.Set;

import org.adligo.models.core.client.I_Org;

public interface I_UserGroup extends I_Org {

	public abstract Set<String> getRoles();

}