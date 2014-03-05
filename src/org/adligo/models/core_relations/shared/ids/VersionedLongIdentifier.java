package org.adligo.models.core_relations.shared.ids;

import org.adligo.i.adi.shared.I_Cacheable;
import org.adligo.i.util.shared.I_Immutable;
import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ValidationException;

public class VersionedLongIdentifier implements I_VersionedLongIdentifier, I_Immutable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VersionedLongIdentifierMutant vim;
	
	public VersionedLongIdentifier() {
		vim = new VersionedLongIdentifierMutant();
	}
	
	public VersionedLongIdentifier(I_VersionedLongIdentifier p) throws InvalidParameterException {
		vim = new VersionedLongIdentifierMutant(p);
		try {
			vim.isValid();
		} catch (ValidationException ve) {
			throw new InvalidParameterException(ve);
		}
	}

	public void isValid() throws ValidationException {
		vim.isValid();
	}

	
	public Long getId() {
		return vim.getId();
	}

	public Integer getVersion() {
		return vim.getVersion();
	}

	public boolean equals(Object obj) {
		return vim.equals(obj);
	}

	
	public int hashCode() {
		return vim.hashCode();
	}

	public String toString() {
		return vim.toString(VersionedLongIdentifier.class);
	}

	public int getMemsize() {
		return vim.getMemsize() + I_Cacheable.OBJECT;
	}

	public String getImmutableFieldName() {
		return "vim";
	}

	public boolean hasValue() {
		// TODO Auto-generated method stub
		return false;
	}

	public I_StorageIdentifier toImmutable() {
		try {
			return new VersionedLongIdentifier(this);
		} catch (InvalidParameterException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public int compareTo(I_VersionedLongIdentifier o) {
		return vim.compareTo(o);
	}
}
