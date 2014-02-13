package org.adligo.models.core_relations.shared;

import java.io.Serializable;
import java.util.ArrayList;

public interface I_Subset<T> extends Serializable {

	public abstract Integer getTotalRecords();

	public abstract Integer getStartRecord();

	public abstract ArrayList<T> getItems();

	public int size();
	
	public T get(int p);
}