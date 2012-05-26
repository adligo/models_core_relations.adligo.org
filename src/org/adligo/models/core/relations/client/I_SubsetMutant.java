package org.adligo.models.core.relations.client;

import java.util.Collection;
import java.util.List;

public interface I_SubsetMutant<T> extends List<T>, I_Subset<T> {

	public abstract void setTotalRecords(Integer totalRecords);

	public abstract void setStartRecord(Integer startRecord);

	public abstract void setItems(Collection<T> p);

}