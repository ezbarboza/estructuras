package ar.edu.uns.cs.ed.tdas.tdacola;

import ar.edu.uns.cs.ed.tdas.excepciones.EmptyQueueException;

public class ArrayQueue<E> implements Queue<E>{
	private E[] array;
	private int size;
	private int first;
	private int last;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int size) {
		array = (E[]) new Object[size];
		size = 0;
		first = 0;
		last = 0;
	}
	
	public ArrayQueue() {
		this(20);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E front() {
		if(size == 0) {
			throw new EmptyQueueException("La cola esta vacia");
		} 
		
		return array[first];
	}

	@Override
	public void enqueue(E elemento) {
		if(size == array.length) {
			redimensionar();
		} 
		
		array[last] = elemento;
		size++;
		last = (last + 1) % (array.length);
				
	}
	
	private void redimensionar() {
		int aux = 0;
		 @SuppressWarnings("unchecked")
		 E[] nuevoarray = (E[]) new Object[array.length * 2];

	      
	        for (int i = first; i < array.length; i++) {
	        	nuevoarray[aux] = array[i];
	        	aux++;
	            
	        }
	        
	        if(aux <= size) {
	        	for(int j = 0; j < first; j++) {
	        		nuevoarray[aux] = array[j];
	        		aux++;
	        	}
	        }

	        array = nuevoarray;
	        first = 0;
	        last = aux;
	}

	@Override
	public E dequeue() {
		E elemento = null;
		
		if(this.isEmpty()) {
			throw new EmptyQueueException("La cola esta vacia");
		} else {
			elemento = this.array[first];
			array[first] = null;
			size--;
			first = (first + 1) % (array.length);
		}
		return elemento;
}
}