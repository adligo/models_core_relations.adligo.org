package org.adligo.models.core_relations.shared;

import java.util.Collection;

import org.adligo.models.core.shared.I_Org;
import org.adligo.models.core.shared.I_Person;
import org.adligo.models.core.shared.I_Storable;
import org.adligo.models.core.shared.I_Subject;
import org.adligo.models.core.shared.I_User;

public interface I_UserRelations extends I_User, I_Subject, I_Storable {

	public Collection<String> getRoles();

	public Collection<String> getGroups();

	public I_Person getPerson();

	public I_User getUser();

	public I_Org getOrg();

}