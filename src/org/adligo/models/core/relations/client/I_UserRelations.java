package org.adligo.models.core.relations.client;

import java.util.Set;

import org.adligo.models.core.client.I_Org;
import org.adligo.models.core.client.I_Person;
import org.adligo.models.core.client.I_Subject;
import org.adligo.models.core.client.I_User;

public interface I_UserRelations extends I_Subject {

	public abstract Set<String> getRoles();

	public abstract Set<String> getGroups();

	public abstract I_Person getPerson();

	public abstract I_User getUser();

	public abstract I_Org getOrg();

}