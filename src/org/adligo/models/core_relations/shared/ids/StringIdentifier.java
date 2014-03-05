package org.adligo.models.core_relations.shared.ids;

import org.adligo.i.util.shared.I_Immutable;
import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core.shared.InvalidParameterException;

public class StringIdentifier implements I_StringIdentifier, I_Immutable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StringIdentifierMutant mut;
	
	public StringIdentifier() {
		mut = new StringIdentifierMutant();
	}
	
	public StringIdentifier(I_StringIdentifier o) throws InvalidParameterException {
		mut = new StringIdentifierMutant(o);
	}

	public int hashCode() {
		return mut.hashCode();
	}

	public boolean equals(Object obj) {
		return mut.equals(obj);
	}

	public String getKey() {
		return mut.getKey();
	}

	public boolean hasValue() {
		return mut.hasValue();
	}

	public String toString() {
		return mut.toString(StringIdentifier.class);
	}

	public String getImmutableFieldName() {
		return "mut";
	}

	public int getMemsize() {
		return mut.getMemsize();
	}

	public I_StorageIdentifier toImmutable() {
		return this;
	}

	public int compareTo(I_StringIdentifier o) {
		return mut.compareTo(o);
	}
	
}
