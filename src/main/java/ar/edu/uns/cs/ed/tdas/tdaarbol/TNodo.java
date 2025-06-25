package ar.edu.uns.cs.ed.tdas.tdaarbol;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class TNodo<E> implements Position<E> {

    protected TNodo<E> parent;
    protected PositionList<Position<E>> children;
    protected E element;

    public TNodo (TNodo<E> p, E elem){
        this.parent=p;
        this.element=elem;
        this.children= new ListaDoblementeEnlazada<Position<E>>();
    }

    @Override
    public E element() {
        return this.element;
    }

    public void setElement (E elem){
        element=elem;
    }

    public TNodo<E> getParent(){
        return this.parent;
    }

    public void setParent(TNodo<E> p){
        parent=p;
    }

    public PositionList<Position<E>> getChildren(){
        return this.children;
    }
    
    
		public void delete() {
			element= null;
			parent= null;
			children= null;
		}
}
