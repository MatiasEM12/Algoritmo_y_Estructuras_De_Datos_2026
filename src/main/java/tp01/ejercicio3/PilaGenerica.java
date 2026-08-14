package tp01.ejercicio3;

import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio2.NodoGenerico;

public class PilaGenerica  <T> extends ListaGenerica<T> {


    private NodoGenerico<T> comienzo;
    private NodoGenerico<T> tope;
    private int tamanio;

    public PilaGenerica() {
        this.comienzo = null;
        this.tope = null;
        this.tamanio = 0;
    }

    public void apilar(T elem){
        NodoGenerico<T> aux = new NodoGenerico<T>();
        aux.setDato(elem);

        if(comienzo == null){
            comienzo=aux;
            tope=aux;
        }else{
            aux.setSiguiente(tope);
            tope = aux;
        }
        tamanio++;
    }

    public T desapilar(){
        return null;
    }

    public T tope(){
        return null;
    }


    @Override
    public boolean esVacia() {
        return (comienzo==null);
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
        return false;
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
        return 0;
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
