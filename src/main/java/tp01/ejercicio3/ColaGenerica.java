package tp01.ejercicio3;


import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio2.NodoGenerico;

public class ColaGenerica <T> extends ListaGenerica<T> {

    private NodoGenerico<T> inicio;
    private NodoGenerico<T> actual;
    private NodoGenerico<T> fin;
    private int tamanio;


    public ColaGenerica() {
        this.inicio = null;
        this.fin = null;
        this.actual = null;
        this.tamanio = 0;
    }
    public void encolar(T elem){
        NodoGenerico<T> aux = new NodoGenerico<T>();
        aux.setDato(elem);

        if(inicio==null){
            inicio = aux;
            fin = aux;
        }else{
            fin.setSiguiente(aux);
            fin = aux;
        }
        tamanio++;
    }

    public T desencolar(){

        if(inicio==null){
            return null;
        }

        T elem = inicio.getDato();
        inicio = inicio.getSiguiente();
        tamanio--;
        if (tamanio == 0) {
            fin = null;
        }
        return elem;
    }

    public T tope (){
        if(inicio==null){
            return null;
        }
        return inicio.getDato();
    }

    @Override
    public boolean esVacia(){
        return (inicio==null);
    }

    @Override
    public void comenzar() {
        actual = inicio;
    }


    @Override
    public T proximo() {
        T elem = this.actual.getDato();
        this.actual = this.actual.getSiguiente();
        return elem;
    }

    @Override
    public boolean fin() {
        return actual == null ;
    }

    @Override
    public T elemento(int pos) {
        if (pos < 1 || pos > this.tamanio()) // no es posicion valida
            return null;
        NodoGenerico<T> n = this.inicio;
        while (pos-- > 1)
            n = n.getSiguiente();
        return n.getDato();
    }

    @Override
    public boolean agregarEn(T elem, int pos) {
        return false;
    }

    @Override
    public boolean agregarInicio(T elem) {
        return false;
    }

    @Override
    public boolean agregarFinal(T elem) {
        encolar(elem);
        return true;
    }

    @Override
    public boolean eliminar(T elem) {
        return false;
    }

    @Override
    public boolean eliminarEn(int pos) {
        return false;
    }

    @Override
    public boolean incluye(T elem) {
        NodoGenerico<T> n = this.inicio;
        while (!(n == null) && !(n.getDato().equals(elem)))
            n = n.getSiguiente();
        return !(n == null);
    }



    @Override
    public int tamanio() {
        return tamanio;
    }

    @Override
    public boolean reemplazarEn(T elem, int pos) {
        if (pos < 1 || pos > this.tamanio()) // posicion no valida
            return false;
        NodoGenerico<T> n = this.inicio;
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
