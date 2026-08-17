package tp01.ejercicio3;


import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio2.NodoGenerico;

public class PilaGenerica  <T> extends ListaGenerica<T> {


    private NodoGenerico<T> tope;
    private NodoGenerico<T> actual;
    private int tamanio;

    public PilaGenerica() {
        this.tope = null;
        this.tamanio = 0;
    }

    public void apilar(T elem){
        NodoGenerico<T> aux = new NodoGenerico<T>();
        aux.setDato(elem);

        //el primer elemento de la lista tendra null como siguiente para identificarlo
        aux.setSiguiente(tope);
        //tope siempre sera el inicio de la lista
        tope = aux;

        tamanio++;
    }

    public T desapilar(){

        if (esVacia()) {
            return null;
        }
        T elem = tope.getDato();
        tope = tope.getSiguiente();
        tamanio--;
        return elem;
    }

    public T tope(){
        if (esVacia()) {
            return null;
        }
        return tope.getDato();
    }


    @Override
    public boolean esVacia() {
        return (tope==null);
    }

    @Override
    public void comenzar() {
        actual=tope;
    }

    @Override
    public T proximo() {
        if (actual == null) {
            return null;
        }
        T elem = actual.getDato();
        actual = actual.getSiguiente();
        return elem;
    }

    @Override
    public boolean fin() {
        return (actual==null);
    }

    @Override
    public T elemento(int pos) {

        if (pos < 1 || pos > this.tamanio()) // no es posicion valida
            return null;
        NodoGenerico<T> n = this.tope;
        while (pos-- > 1)
            n = n.getSiguiente();
        return n.getDato();
    }

    @Override
    public boolean agregarEn(T elem, int pos) {
        //Una pila no inserta arbitrariamente
        return false;
    }

    @Override
    public boolean agregarInicio(T elem) {
        apilar(elem);
        return true;
    }

    @Override
    public boolean agregarFinal(T elem) {
        //No corresponde a la abstracción de pila
        return false;
    }

    @Override
    public boolean eliminar(T elem) {
        return false;
    }

    @Override
    public boolean eliminarEn(int pos) {
        //Rompe la operación LIFO
        return false;
    }

    @Override
    public boolean incluye(T elem) {
        NodoGenerico<T> aux = tope;

        while (aux != null) {
            if (aux.getDato().equals(elem)) {
                return true;
            }
            aux = aux.getSiguiente();
        }

        return false;
    }


    @Override
    public int tamanio() {
        return tamanio;
    }

    @Override
    public boolean reemplazarEn(T elem, int pos) {
        if (pos < 1 || pos > this.tamanio()) // posicion no valida
            return false;
        NodoGenerico<T> n = this.tope;
        while (!(n == null) && (pos > 1)) {
            pos--;
            n = n.getSiguiente();
        }
        n.setDato(elem);
        return true;
    }

    @Override
    public ListaGenerica<T> clonar() {
        ListaGenerica<T> nueva = new ListaEnlazadaGenerica<T>();
        this.comenzar();
        while (!this.fin()) {
            nueva.agregarFinal(this.proximo());
        }
        return nueva;
    }
}
