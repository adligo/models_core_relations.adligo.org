package org.adligo.models.core.relations.client;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import org.adligo.models.core.client.I_User;
import org.adligo.models.core.client.Person;

public class UserRelationsMutant extends UserRelations implements I_User, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserRelationsMutant() {
		roles = new HashSet<String>();
		groups = new HashSet<String>();
	}
	
	public UserRelationsMutant(UserRelations p) {
		super(p);
	}
	
	public void setId(String id) {
		super.name = id;
	}
	public void setDomain(String domain) {
		super.domain = domain;
	}
	public void setPassword(String password) {
		super.password = password;
	}

	public void setPerson(Person p) {
		person = p;
	}
	
	public void addAllRoles(Collection<String> p_roles) {
		roles.addAll(p_roles);
	}
	
	public void addAllGroups(Collection<String> p_groups) {
		groups.addAll(p_groups);
	}
	
}
