/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektas;

import java.util.Comparator;

/**
 *
 * @author zygis
 */
public interface nodeInterface<E> {
    /**
	 * Appends the specified element to the end of this list.
	 *
	 * @param e element to be appended to this list
	 */
	void add(E e);

	/**
	 * Returns the number of elements in this list.
     * @return 
	 */
	int size();

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param k index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	E get(int k);

	
	/**
	 * Removes all the unused space in the array.
	 */
	void shrinkSize();
        
        
        
        /**
         * Removes the element at the specified position in this list (optional operation). 
         * @param a 
         */
         void remove(int a);
         
         /**
          * Returns true if this list contains the specified element
          * @param o
          * @return true or false
          */
         boolean contains(Object o);
         
         void growSize(int z);
         
         void insert(E e,int ind);
         int getIndex(E o);
         void clear();
         void sort(Comparator<E> c);
}
