package ar.edu.uns.cs.ed.tdas.tdaarbol;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;

public class TNodo<E> implements Position<E> {

    protected TNodo<E> dad;
    protected ListaDoblementeEnlazada<TNodo<E>> sons;

    @Override
    public E element() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'element'");
    }
    
}
