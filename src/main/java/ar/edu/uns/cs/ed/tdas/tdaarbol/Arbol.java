package ar.edu.uns.cs.ed.tdas.tdaarbol;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Position;
import ar.edu.uns.cs.ed.tdas.excepciones.BoundaryViolationException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidOperationException;
import ar.edu.uns.cs.ed.tdas.excepciones.InvalidPositionException;
import ar.edu.uns.cs.ed.tdas.tdalista.ListaDoblementeEnlazada;
import ar.edu.uns.cs.ed.tdas.tdalista.PositionList;

public class Arbol<E> implements Tree<E>{

    protected TNodo<E> root;
    protected int size;

    public Arbol(){
        this.root=null;
        this.size=0;
    }
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public Iterator<E> iterator() {
        PositionList<E> lista= new ListaDoblementeEnlazada<>();
        preOrderElements(root,lista);
        return lista.iterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> lista= new ListaDoblementeEnlazada<>();
        preOrderPositions(root,lista);
        return lista;
    }

    @Override
    public E replace(Position<E> v, E e) {
        TNodo<E> nodo= checkPosition(v);
        E toReturn= nodo.element();
        nodo.setElement(e);
        return toReturn;
    }

    @Override
    public Position<E> root() {
        return this.root;
    }
j
    @Override
    public Position<E> parent(Position<E> v) {
        if (isRoot(v)){throw new BoundaryViolationException("se pide el padre de la raiz");}
        return checkPosition(v).getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v) {
        return checkPosition(v).getChildren();
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !(isExternal(v));
    }

    @Override
    public boolean isExternal(Position<E> v) {
        return checkPosition(v).getChildren().isEmpty();
    }

    @Override
    public boolean isRoot(Position<E> v) {
         TNodo<E> p = checkPosition(v);
        return p.getParent()==null;
    }

    @Override
    public void createRoot(E e) {
        if(!isEmpty()) {throw new InvalidOperationException("El árbol ya tiene un root");}
        root= new TNodo<E>(null, e);
        size++;
    }

    @Override
    public Position<E> addFirstChild(Position<E> p, E e) {
        TNodo<E> parent= checkPosition(p);
        TNodo<E> child= new TNodo<E>(parent, e);
        parent.getChildren().addFirst(child);
        size++;
        return child;
    }

    @Override
    public Position<E> addLastChild(Position<E> p, E e) {
        TNodo<E> parent= checkPosition(p);
        TNodo<E> child= new TNodo<E>(parent, e);
        parent.getChildren().addLast(child);
        size++;
        return child;
    }

    @Override
    public Position<E> addBefore(Position<E> p, Position<E> rb, E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBefore'");
    }

    @Override
    public Position<E> addAfter(Position<E> p, Position<E> lb, E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAfter'");
    }

    @Override
    public void removeExternalNode(Position<E> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeExternalNode'");
    }

    @Override
    public void removeInternalNode(Position<E> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeInternalNode'");
    }

    @Override
    public void removeNode(Position<E> p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeNode'");
    }
    
    /*chequea si una position es un TNodo valido y lo castea
     * tira invalidPositionException si no es valido
     */
    private TNodo<E> checkPosition (Position<E> p){
        if (isEmpty()){throw new InvalidPositionException ("el arbol esta vacio");}
        if (p==null){throw new InvalidPositionException("posicion nula");}
        TNodo<E> toReturn=null;
        try {
            toReturn= (TNodo<E>)p;
        }catch(ClassCastException e){throw new InvalidPositionException("error de casteo al chequar la posicion");}
        return toReturn;
    }

    /*añade a la lista dada por parametro los elementos que tienes los nodos del subarbol de nodo en preorden */
     private void preOrderElements(TNodo<E> nodo, PositionList<E> lista) {
        lista.addLast(nodo.element());
        for(Position<E> n:nodo.getChildren()){
            preOrderElements(checkPosition(n), lista);
        }
    }
   /*añade a la lista dada por parametro los nodos del subarbol de nodo en preorden */
    private void preOrderPositions (TNodo<E> nodo, PositionList<Position<E>> lista) {
        lista.addLast(nodo);
        for(Position<E> n:nodo.getChildren()){
            preOrderPositions(checkPosition(n), lista);
        }
    }

    Position<Position<E>> findBrotherPosition(Position<E> p, Position<E> b){
        
    }

}
