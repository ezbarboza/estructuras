package ar.edu.uns.cs.ed.tdas.tdaarbol;

import java.util.Iterator;

import ar.edu.uns.cs.ed.tdas.Position;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public Iterable<Position<E>> positions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'positions'");
    }

    @Override
    public E replace(Position<E> v, E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replace'");
    }

    @Override
    public Position<E> root() {
        return this.root;
    }
j
    @Override
    public Position<E> parent(Position<E> v) {
        //TODO BoundryViolationException
        return checkPosition(v).getParent();
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v) {
        TNodo<E> nodo= checkPosition(v);
        
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !(isExternal(v));
    }

    @Override
    public boolean isExternal(Position<E> v) {
        TNodo<E> p = checkPosition(v);
        return p.getChildren().isEmpty();
    }

    @Override
    public boolean isRoot(Position<E> v) {
         TNodo<E> p = checkPosition(v);
        return p.getParent()==null;
    }

    @Override
    public void createRoot(E e) {
        //TODO Exception si ya tiene raiz
        TNodo<E> raiz = new TNodo<E>(null, e);
        this.root=raiz;
        size++;
    }

    @Override
    public Position<E> addFirstChild(Position<E> p, E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFirstChild'");
    }

    @Override
    public Position<E> addLastChild(Position<E> p, E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addLastChild'");
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
    
    protected TNodo<E> checkPosition (Position<E> p){
        //TODO exceptions
        TNodo<E> toReturn= (TNodo<E>)p;
        return toReturn;
    }
}
