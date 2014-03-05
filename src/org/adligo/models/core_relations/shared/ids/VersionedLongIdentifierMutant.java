package org.adligo.models.core_relations.shared.ids;

import org.adligo.i.adi.shared.I_Cacheable;
import org.adligo.models.core.shared.I_Changeable;
import org.adligo.models.core.shared.I_StorageIdentifier;
import org.adligo.models.core.shared.I_Validateable;
import org.adligo.models.core.shared.InvalidParameterException;
import org.adligo.models.core.shared.ValidationException;

/**
 * a class that may be used as a Hibernate component
 * to a history table (Where id, version is the primary key)
 * @author scott
 *
 */
public class VersionedLongIdentifierMutant implements I_VersionedLongIdentifier {
	public static final String THE_I_CHANGEABLE_ID_MUST_BE_A_LONG_IDENTIFIER_FOR_THIS_CONSTRUCTOR = 
					"The I_Changeable's id must be a I_LongIdentifier for this constructor.";
	public static final String ID_MAY_NOT_BE_SET_TO_NULL = "Id may not be set to null.";
	public static final String SET_ID = "setId";
	public static final String VERSION_MAY_NOT_BE_SET_TO_NULL = "Version may not be set to null";
	public static final String SET_VERSION = "setVersion";
	public static final String NULL_VERSION = "Null Version";
	public static final String NULL_ID = "Null Id";
	public static final String DOES_NOT_ACCEPT_NULLS = "Does Not accept nulls";
	public static final String CONSTRUCTOR = "Constructor";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer version;
	private Long id;
	
	public VersionedLongIdentifierMutant() {}
	public VersionedLongIdentifierMutant(I_VersionedLongIdentifier vi) throws InvalidParameterException {
		if (vi == null) {
			throw new InvalidParameterException(DOES_NOT_ACCEPT_NULLS, 
					CONSTRUCTOR);
		}
		setId(vi.getId());
		setVersion(vi.getVersion());
	}
	
	public VersionedLongIdentifierMutant(I_Changeable p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(DOES_NOT_ACCEPT_NULLS, 
					CONSTRUCTOR);
		}
		I_StorageIdentifier oid = p.getId();
		if (oid == null) {
			throw new InvalidParameterException(DOES_NOT_ACCEPT_NULLS, 
					CONSTRUCTOR);
		}
		I_LongIdentifier lid = null;
		try {
			lid = (I_LongIdentifier) oid;
		} catch (ClassCastException ce) {
			throw new InvalidParameterException(THE_I_CHANGEABLE_ID_MUST_BE_A_LONG_IDENTIFIER_FOR_THIS_CONSTRUCTOR, 
					CONSTRUCTOR);
		}
		Long lidId = lid.getId();
		if (lidId == null) {
			throw new InvalidParameterException(DOES_NOT_ACCEPT_NULLS, 
					CONSTRUCTOR);
		}
		setId(lidId);
		Integer lidVersion = p.getVersion();
		if (lidVersion == null) {
			throw new InvalidParameterException(DOES_NOT_ACCEPT_NULLS, 
					CONSTRUCTOR);
		}
		setVersion(lidVersion);
		try {
			isValid();
		} catch (ValidationException ve) {
			throw new InvalidParameterException(ve);
		}
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifier#getId()
	 */
	public Long getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifierMutant#setId(org.adligo.models.core.client.ids.I_StorageIdentifier)
	 */
	public void setId(Long p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(ID_MAY_NOT_BE_SET_TO_NULL, SET_ID);
		}
		this.id = p;
	}
	
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifier#getVersion()
	 */
	public Integer getVersion() {
		return version;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.client.ids.I_VersionedLongIdentifierMutant#setVersion(java.lang.Integer)
	 */
	public void setVersion(Integer p) throws InvalidParameterException {
		if (p == null) {
			throw new InvalidParameterException(VERSION_MAY_NOT_BE_SET_TO_NULL, SET_VERSION);
		}
		version = p;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		try {
			I_VersionedLongIdentifier other = (I_VersionedLongIdentifier) obj;
			if (id == null) {
				if (other.getId() != null)
					return false;
			} else if (!id.equals(other.getId()))
				return false;
			if (version == null) {
				if (other.getVersion() != null)
					return false;
			} else if (!version.equals(other.getVersion()))
				return false;
		} catch (ClassCastException x) {
			//eat
		}
		return true;
	}
	
	public String toString() {
		return toString(VersionedLongIdentifierMutant.class);
	}
	
	public String toString(Class<?> c) {
		return c.getSimpleName() + " [id="
				+ id + ", version=" + version + "]";
	}
	
	public int getMemsize() {
		int size = 0;
		if (id != null) {
			size = I_Cacheable.LONG;
		}
		if (id != null) {
			size = size + I_Cacheable.INT;
		}
		return I_Cacheable.OBJECT + size;
	}
	
	public boolean hasValue() {
		if (id == null || version == null) {
			return false;
		}
		return true;
	}
	
	public I_StorageIdentifier toImmutable() {
		try{
			return new VersionedLongIdentifier(this);
		} catch (InvalidParameterException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public int compareTo(I_VersionedLongIdentifier o) {
		if (id != null) {
			Long oid = o.getId();
			if (oid != null) {
				if (id.equals(oid)) {
					if (version != null) {
						Integer oVersion = o.getVersion();
						if (oVersion != null) {
							return version.compareTo(oVersion);
						}
					}
				} else {
					return id.compareTo(oid);
				}
			}
		}
		return 0;
	}
	@Override
	public void isValid() throws ValidationException {
		if (id == null) {
			throw new ValidationException(NULL_ID, I_Validateable.IS_VALID);
		}
		if (version == null) {
			throw new ValidationException(NULL_VERSION, I_Validateable.IS_VALID);
		}
	}
}
