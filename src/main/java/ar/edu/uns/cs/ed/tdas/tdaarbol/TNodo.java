package ar.edu.uns.cs.ed.tdas.tdaarbol;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class TNodo<E> implements Position<E> {

    protected TNodo<E> dad;
    protected PositionList<TNodo<E>> sons;
    protected E element;

    public TNodo (TNodo<E> p, E elem){
        this.dad=p;
        this.element=elem;
        this.sons= new ListaDoblementeEnlazada<TNodo<E>>();
    }

    @Override
    public E element() {
        return this.element;
    }

    public TNodo<E> getParent(){
        return this.dad;
    }

    public PositionList<TNodo<E>> getChildren(){
        return sons;
    }
    
}
