package org.adligo.models.core_relations.shared.ids;

import org.adligo.i.util.shared.I_Immutable;
import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core.shared.InvalidParameterException;

public class LongIdentifier implements I_LongIdentifier, I_Immutable {
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

	public LongIdentifier(Long o) throws InvalidParameterException {
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

	/**
	 * Note this method is used by Hibernate which
	 * can access this method 
	 * It would be nice if Hibernate could allow constructor
	 * parameters and not just property parameters.
	 * I can't seem to log into the hibernate forum anymore to suggest this :(
	 * 
	 * @param p
	 * @throws InvalidParameterException
	 */
	@SuppressWarnings("unused")
	private void setId(Long p) throws InvalidParameterException {
		mut.setId(p);
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
