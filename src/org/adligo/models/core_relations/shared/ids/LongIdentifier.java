package org.adligo.models.core_relations.shared.ids;

import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core.shared.InvalidParameterException;

public class LongIdentifier implements I_LongIdentifier {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LongIdentifierMutant mut;
	
	public LongIdentifier() {
		mut = new LongIdentifierMutant();
	}
	
	public LongIdentifier(I_LongIdentifier o) throws InvalidParameterException {
		mut = new LongIdentifierMutant(o);
	}
	
	public int hashCode() {
		return mut.hashCode();
	}

	public boolean equals(Object obj) {
		return mut.equals(obj);
	}

	public String toString() {
		return mut.toString(LongIdentifier.class);
	}

	public Long getId() {
		return mut.getId();
	}

	public boolean hasValue() {
		return mut.hasValue();
	}

	public String getImmutableFieldName() {
		return "mut";
	}

	public int getMemsize() {
		return mut.getMemsize();
	}

	public I_StorageIdentifier toImmutable() {
		return mut.toImmutable();
	}

	public int compareTo(I_LongIdentifier o) {
		return mut.compareTo(o);
	}

}
