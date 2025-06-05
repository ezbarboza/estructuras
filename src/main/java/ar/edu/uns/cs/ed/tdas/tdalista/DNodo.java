package ar.edu.uns.cs.ed.tdas.tdalista;

import ar.edu.uns.cs.ed.tdas.Position;

public class DNodo<E> implements Position<E>{
    protected E element;
    protected DNodo<E> last;
    protected DNodo<E> next;
    
    
    public DNodo (E dato){
    	element = dato;
    	last = null;
    	next = null;
    }
	
	public E element() {
		return this.element;
	}
	
	 public void setElement(E elemento) {
	        this.element = elemento;
	    }

	    public DNodo<E> getLast() {
	        return last;
	    }

	    public void setLast(DNodo<E> last) {
	        this.last = last;
	    }

	    public DNodo<E> getNext() {
	        return next;
	    }

	    public void setNext(DNodo<E> next) {
	        this.next = next;
	    }


        public void linkNext (DNodo<E> n){
            this.next = n;
            if (n!=null)
                next.setLast(this);
        }
        public void linkLast (DNodo<E> n){
            this.last = n;
            if(n!=null)
                last.setNext(this);
        }
         public void unlink (){
            if (next==null)
            last.linkNext(next);
            else
            next.linkLast(last);   
        }

}
