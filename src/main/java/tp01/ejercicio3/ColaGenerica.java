package tp01.ejercicio3;


import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio2.NodoGenerico;

public class ColaGenerica <T> extends ListaGenerica<T> {

    private NodoGenerico<T> inicio;
    private NodoGenerico<T> fin;
    private int tamanio;


    public ColaGenerica() {
        this.inicio = null;
        this.fin = null;
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

    }


    @Override
    public T proximo() {
        return null;
    }

    @Override
    public boolean fin() {
        return true;
    }

    @Override
    public T elemento(int pos) {
        return null;
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
        return false;
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
        return false;
    }



    @Override
    public int tamanio() {
        return tamanio;
    }

    @Override
    public boolean reemplazarEn(T elem, int pos) {
        return false;
    }

    @Override
    public ListaGenerica<T> clonar() {
        return null;
    }
}
