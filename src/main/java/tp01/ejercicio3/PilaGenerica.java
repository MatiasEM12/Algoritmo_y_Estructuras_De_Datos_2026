package tp01.ejercicio3;


import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio2.NodoGenerico;

public class PilaGenerica  <T> {

    private ListaGenerica<T> datos;


    public PilaGenerica(ListaGenerica<T> lista) {

        this.datos = lista;
    }

    public void apilar(T elem){

        datos.agregarFinal(elem);
    }

    public T desapilar(){

        if (esVacia()) {
            return null;
        }
        T elem = datos.elemento(datos.tamanio());
        datos.eliminarEn(datos.tamanio());
        return elem;

    }

    public T tope(){
        if (esVacia()) {
            return null;
        }
        return datos.elemento(datos.tamanio());
    }

    public boolean esVacia() {
        return datos.esVacia();
    }

}
