package org.adligo.models.core_relations.shared.ids;

import java.io.Serializable;

import org.adligo.models.core.shared.I_StorageIdentifier;

/**
 * note 
 * it would get normalized to the version integer and I_StorageIdentifier
 * at runtime in the class (see Person, Org)
 * @author scott
 *
 */
public interface I_VersionedLongIdentifier extends I_StorageIdentifier, Serializable {

	public abstract Long getId();

	public abstract Integer getVersion();

}