package org.adligo.models.core_relations.shared.ids;

import java.io.Serializable;

import org.adligo.models.core.shared.I_StorageIdentifier;


public interface I_LongIdentifier extends I_StorageIdentifier, Comparable<I_LongIdentifier>, Serializable {
	public Long getId();
}
