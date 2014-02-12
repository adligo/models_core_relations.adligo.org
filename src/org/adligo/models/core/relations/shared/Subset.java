package org.adligo.models.core.relations.shared;

import java.util.ArrayList;

import org.adligo.i.util.shared.I_Immutable;

public class Subset <T> implements I_Subset<T>, I_Immutable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SubsetMutant<T> mutant;
	
	public Subset() {}
	
	public Subset(I_Subset<T> p) {
		mutant = new SubsetMutant<T>(p);
	}

	public Integer getTotalRecords() {
		return mutant.getTotalRecords();
	}

	public Integer getStartRecord() {
		return mutant.getStartRecord();
	}

	public T get(int arg0) {
		return mutant.get(arg0);
	}

	public int size() {
		return mutant.size();
	}

	public ArrayList<T> getItems() {
		return mutant.getItems();
	}

	public String getImmutableFieldName() {
		return "mutant";
	}
}
