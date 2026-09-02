package tp01.ejercicio3;


import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

public class ColaGenerica <T>  {

    private ListaGenerica<T> datos;


    public ColaGenerica() {
        this.datos = new ListaEnlazadaGenerica<>();
    }
    public void encolar(T elem){
        if (elem !=null) {
            datos.agregarFinal(elem);
        }
    }

    public T desencolar(){
        if (esVacia()) {
            return null;
        }
        T elem = datos.elemento(1);
        datos.eliminarEn(1);
        return elem;
    }

    public T tope (){
        if (esVacia()) {
            return null;
        }
        return datos.elemento(1);
    }

    public boolean esVacia(){
        return datos.esVacia();
    }

}
