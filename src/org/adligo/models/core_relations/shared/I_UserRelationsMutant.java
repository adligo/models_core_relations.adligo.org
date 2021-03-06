package org.adligo.models.core_relations.shared;

import java.util.Collection;

import org.adligo.models.core.shared.I_Org;
import org.adligo.models.core.shared.I_Person;
import org.adligo.models.core.shared.I_User;
import org.adligo.models.core.shared.InvalidParameterException;

public interface I_UserRelationsMutant extends I_UserRelations {
	public void setRoles(Collection<String> p) throws InvalidParameterException ;
	public void setGroups(Collection<String> p) throws InvalidParameterException ;
	public void setPerson(I_Person p) throws InvalidParameterException ;
	public void setUser(I_User p) throws InvalidParameterException ;
	public void setOrg(I_Org p) throws InvalidParameterException ;
}
