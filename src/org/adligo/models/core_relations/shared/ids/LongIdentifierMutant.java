package org.adligo.models.core_relations.shared.ids;

import org.adligo.i.adi.shared.I_Cacheable;
import org.adligo.i.util.shared.ClassUtils;
import org.adligo.i.util.shared.I_Immutable;
import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core.shared.InvalidParameterException;

public class LongIdentifierMutant implements I_LongIdentifier {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String SET_ID = "setId";
	public static final String TYPE = "LongIdentifier";
	public static final String ID_CANT_BE_SET_TO_NULL = "LongIdentifier id can't be set to null!";
	public static final String CONSTRUCTOR = "Constructor";
	
	private Long id;
	
	public LongIdentifierMutant() {}
	
	public LongIdentifierMutant(I_LongIdentifier p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(ID_CANT_BE_SET_TO_NULL, CONSTRUCTOR);
		}
		Long oid = p.getId();
		if (oid == null) {
			throw new InvalidParameterException(ID_CANT_BE_SET_TO_NULL, CONSTRUCTOR);
		}
		setId(p.getId());
		
	}

	public LongIdentifierMutant(Long p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(TYPE, CONSTRUCTOR);
		}
		setId(p);
	}
	
	public void setId(Long p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(TYPE, ID_CANT_BE_SET_TO_NULL);
		}
		id = p;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		try {
			I_LongIdentifier other = (I_LongIdentifier) obj;
			Long otherId = other.getId();
			if (id == null) {
				if (otherId == null) {
					return true;
				}
			} else if (id.equals(otherId)) {
				return true;
			}
		} catch (ClassCastException x) {
			//eat
		}
		return false;
	}

	public String toString() {
		return toString(this.getClass());
	}

	String toString(Class<?> c) {
		StringBuffer sb = new StringBuffer();
		sb.append(ClassUtils.getClassShortName(c));
		sb.append(" [id=");
		sb.append(id);
		sb.append("]");
		return sb.toString();
	}
	
	public Long getId() {
		return id;
	}

	public boolean hasValue() {
		if (id == null) {
			return false;
		}
		return true;
	}
	
	public String getImmutableFieldName() {
		return "id";
	}

	public int getMemsize() {
		int size = 0;
		if (id != null) {
			size = I_Cacheable.LONG;
		}
		return I_Cacheable.OBJECT + size;
	}

	public I_StorageIdentifier toImmutable() {
		try {
			return new LongIdentifier(this);
		} catch (InvalidParameterException ipe) {
			throw new IllegalStateException(ipe);
		}
	}

	@Override
	public int compareTo(I_LongIdentifier o) {
		if (id != null) {
			Long oid = o.getId();
			if (oid != null) {
				return id.compareTo(oid);
			}
		}
		return 0;
	}

}
