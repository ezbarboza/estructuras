package ar.edu.uns.cs.ed.tdas.tdalista;

import java.util.Iterator;
import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import ar.edu.uns.cs.ed.tdas.excepciones.EmptyListException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;

public class ListaDoblementeEnlazada<E> implements PositionList<E>{

	private DNodo<E> head;
    private DNodo<E> tail;
    private int size;
	

	public ListaDoblementeEnlazada() {
		head = new DNodo<E>(null); // centinela inicial
        tail = new DNodo<E>(null); // centinela final
        head.linkNext(tail);
        size = 0;
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
	public Position<E> first() {
		if(isEmpty())
			throw new EmptyListException("La lista esta vacia");
		return  head.getNext();
	}

	@Override
	public Position<E> last() {
		if(isEmpty())
			throw new EmptyListException("La lista esta vacia");
	
		return  tail.getLast();
	}

	@Override
	public Position<E> next(Position<E> p) {
		DNodo<E> n = checkPosition(p);
		if(n.getNext() == tail) 
			throw new BoundaryViolationException("La posición pasada por parámetro corresponde al último elemento de la lista.");
		return n.getNext();
	}

	@Override
	public Position<E> prev(Position<E> p) {
	DNodo<E> n = checkPosition(p);
		if(n.getLast() == head) 
			throw new BoundaryViolationException("La posición pasada por parámetro corresponde al primer elemento de la lista.");
		return n.getLast();
	}

	@Override
	public void addFirst(E element) {
		 linkBtwn(element, head, head.getNext());
	}

	@Override
	public void addLast(E element) {
		linkBtwn(element, tail.getLast(), tail);
	}

	@Override
	public void addAfter(Position<E> p, E element) {
		DNodo<E> nodo = checkPosition(p);
	    linkBtwn(element, nodo, nodo.getNext());
	}


	@Override
	public void addBefore(Position<E> p, E element) {
		DNodo<E> nodo = checkPosition(p);
	    linkBtwn(element, nodo.getLast(), nodo);
	}

	@Override
	public E remove(Position<E> p) {
		DNodo<E> nodo = checkPosition(p);
		nodo.unlink();
        size--;
        return nodo.element();
	}

	@Override
	public E set(Position<E> p, E element) {
		DNodo<E> nodo = checkPosition(p);
		E toReturn = nodo.element();
		nodo.setElement(element);
		return toReturn;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
            DNodo<E> actual = head.getNext();

            public boolean hasNext() {
                return actual != tail;
            }

            public E next() {
                	E elem = actual.element();
                    actual = actual.getNext();
              return elem;
            }};
	}

	 public Iterable<Position<E>> positions() {
		 PositionList<Position<E>> list= new ListaDoblementeEnlazada<Position<E>>();
		 if (!isEmpty()) {
			 DNodo<E> i= head.getNext();
			 while (i != tail) {
				 list.addLast(i);
				 i = i.getNext();
			 }
		 }
    return list;
}
	
	protected void linkBtwn(E elem, DNodo<E> last, DNodo<E> next){
	    DNodo<E> nodo= new DNodo<E>(elem);
	    nodo.linkNext(next);
        nodo.linkLast(last);    
	    size++;
	}
	
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
        DNodo<E> n; 
        if(p == null){
            throw new InvalidPositionException("Posicion Nula. Posicion Invalida");
        }
        if(isEmpty()){
            throw new InvalidPositionException("La lista esta vacia. Posicion Invalidad");
        }
        try {
            n = (DNodo<E>) p;
        } catch (ClassCastException e) {
            throw new InvalidPositionException("La posicion no es un nodo doble. Posicion invalida");
        }
        return n;
	}
	
}