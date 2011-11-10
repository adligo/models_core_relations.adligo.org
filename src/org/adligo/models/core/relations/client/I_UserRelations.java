package org.adligo.models.core.relations.client;

import java.util.Collection;

import org.adligo.models.core.client.I_Organization;
import org.adligo.models.core.client.I_Person;
import org.adligo.models.core.client.I_Storable;
import org.adligo.models.core.client.I_Subject;
import org.adligo.models.core.client.I_User;

public interface I_UserRelations extends I_User, I_Subject, I_Storable {

	public Collection<String> getRoles();

	public Collection<String> getGroups();

	public I_Person getPerson();

	public I_User getUser();

	public I_Organization getOrg();

}