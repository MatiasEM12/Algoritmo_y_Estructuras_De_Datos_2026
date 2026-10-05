package tp06.MatrizDeAdyacencia;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.Arista;
import tp06.Vertice;


public class VerticeImplMatrizAdy<T> implements Vertice {

    private ListaGenerica<Arista<T>> adyacentes;
    private T dato;
    private int posicion;

    public VerticeImplMatrizAdy(T dato){
        this.dato = dato;
        this.adyacentes = new ListaEnlazadaGenerica<Arista<T>>();
    }
    @Override
    public Object dato() {
        return null;
    }

    @Override
    public void setDato(Object dato) {

    }

    @Override
    public int getPosicion() {
        return 0;
    }

}
