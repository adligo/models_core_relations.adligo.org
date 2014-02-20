package org.adligo.models.core_relations.shared.ids;

import java.io.Serializable;

import org.adligo.models.core.shared.I_StorageIdentifier;


public interface I_StringIdentifier extends I_StorageIdentifier, Serializable {
	/**
	 * return the value used int the storage system
	 * for uniqueness in the following (
	 * 		LDAP this is a dn, 
	 * 		Filesystem this is a java.io.File pathname from the constructor
	 * )
	 * @return
	 */
	public String getKey();
}
