package tp01.ejercicio3;


import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio2.NodoGenerico;

public class PilaGenerica  <T> {

    private ListaGenerica<T> datos;


    public PilaGenerica() {

        this.datos = new ListaEnlazadaGenerica<>();
    }

    public void apilar(T elem){

        datos.agregarInicio(elem);
    }

    public T desapilar(){

        if (esVacia()) {
            return null;
        }
        T elem = datos.elemento(1);
        datos.eliminarEn(1);
        return elem;

    }

    public T tope(){
        if (esVacia()) {
            return null;
        }
        return datos.elemento(1);
    }

    public boolean esVacia() {
        return datos.esVacia();
    }

}
