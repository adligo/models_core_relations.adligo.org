package org.adligo.models.core.relations.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * this class represents a set theory subset containting part of the ordered results
 * from a query.  This is for the general usage of buffering scrollable/pageable data.
 * It implements List so that it doesn't need to be changed to iterate through or 
 * to do addAll or for loop through, and preserves ordering.
 * 
 * @author scott
 *
 */
public class SubsetMutant <T> implements List<T>, I_Subset<T>, I_SubsetMutant<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * (the total actual ordered unique results)
	 * which may be null (if it was not requsted for)
	 * 
	 * This is used to identify the total results if this is a page of results
	 * ie if there are 10,000 results and 100 objects of those are contained
	 * here
	 * 
	 */
	private Integer totalRecords;
	/**
	 * the first record zero based
	 * should never be null (defaults to zero)
	 */
	private Integer startRecord = 0;
	/**
	 * the items, note the size may be used to identify how many records
	 */
	private ArrayList<T> items = new ArrayList<T>();
	
	public SubsetMutant() {}
	
	public SubsetMutant(I_Subset<T> p) {
		setTotalRecords(p.getTotalRecords());
		setStartRecord(p.getStartRecord());
		setItems(p.getItems());
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_Subset#getTotalRecords()
	 */
	@Override
	public Integer getTotalRecords() {
		return totalRecords;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_SubsetMutant#setTotalRecords(java.lang.Integer)
	 */
	@Override
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_Subset#getStartRecord()
	 */
	@Override
	public Integer getStartRecord() {
		return startRecord;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_SubsetMutant#setStartRecord(java.lang.Integer)
	 */
	@Override
	public void setStartRecord(Integer startRecord) {
		this.startRecord = startRecord;
	}
	public void add(int arg0, T arg1) {
		items.add(arg0, arg1);
	}
	public boolean add(T arg0) {
		if (items.add(arg0)) {
			return true;
		}
		return false;
	}
	public boolean addAll(Collection<? extends T> arg0) {
		if (items.addAll(arg0)) {
			return true;
		}
		return false;
	}
	public boolean addAll(int arg0, Collection<? extends T> arg1) {
		if (items.addAll(arg0, arg1)) {
			return true;
		}
		return false;
	}
	public void clear() {
		items.clear();
		totalRecords = 0;
	}
	public Object clone() {
		return items.clone();
	}
	public boolean contains(Object arg0) {
		return items.contains(arg0);
	}
	public boolean containsAll(Collection<?> arg0) {
		return items.containsAll(arg0);
	}
	public void ensureCapacity(int arg0) {
		items.ensureCapacity(arg0);
	}
	public boolean equals(Object arg0) {
		return items.equals(arg0);
	}
	public T get(int arg0) {
		return items.get(arg0);
	}
	public int hashCode() {
		return items.hashCode();
	}
	public int indexOf(Object arg0) {
		return items.indexOf(arg0);
	}
	public boolean isEmpty() {
		return items.isEmpty();
	}
	public Iterator<T> iterator() {
		return items.iterator();
	}
	public int lastIndexOf(Object arg0) {
		return items.lastIndexOf(arg0);
	}
	public ListIterator<T> listIterator() {
		return items.listIterator();
	}
	public ListIterator<T> listIterator(int arg0) {
		return items.listIterator(arg0);
	}
	public T remove(int arg0) {
		T item = items.remove(arg0);
		return item;
	}
	public boolean remove(Object arg0) {
		if (items.remove(arg0)) {
			return true;
		}
		return false;
	}
	public boolean removeAll(Collection<?> arg0) {
		if (items.removeAll(arg0)) {
			return true;
		}
		return false;
	}
	public boolean retainAll(Collection<?> arg0) {
		if (items.retainAll(arg0)) {
			return true;
		}
		return false;
	}
	public T set(int arg0, T arg1) {
		return items.set(arg0, arg1);
	}
	public int size() {
		return items.size();
	}
	public List<T> subList(int arg0, int arg1) {
		return items.subList(arg0, arg1);
	}
	public Object[] toArray() {
		return items.toArray();
	}
	public <J> J[] toArray(J[] arg0) {
		return items.toArray(arg0);
	}
	public String toString() {
		return items.toString();
	}
	public void trimToSize() {
		items.trimToSize();
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_Subset#getItems()
	 */
	@Override
	public ArrayList<T> getItems() {
		return items;
	}
	/* (non-Javadoc)
	 * @see org.adligo.models.core.relations.client.I_SubsetMutant#setItems(java.util.ArrayList)
	 */
	@Override
	public void setItems(Collection<T> p) {
		if  (p.contains(null)) {
			throw new NullPointerException("");
		}
		items.clear();
		items.addAll(p);
	}

}
