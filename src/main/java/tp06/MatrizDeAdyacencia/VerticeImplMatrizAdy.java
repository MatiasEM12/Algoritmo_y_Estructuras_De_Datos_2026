package tp06.MatrizDeAdyacencia;

import tp06.Vertice;


public class VerticeImplMatrizAdy<T> implements Vertice {

    private T dato;
    private int posicion;

    public VerticeImplMatrizAdy(T dato){
        this.dato = dato;

    }
    @Override
    public Object dato() {
        return this.dato;
    }

    @Override
    public void setDato(Object dato) {
        this.dato=(T)dato;
    }

    @Override
    public int getPosicion() {
        return this.posicion;
    }

    public void setPosicion(int posicion) {
         this.posicion=posicion;
    }

}
