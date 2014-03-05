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

	public StringIdentifier(String o) throws InvalidParameterException {
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
	private void setKey(String p) throws InvalidParameterException {
		mut.setKey(p);
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
