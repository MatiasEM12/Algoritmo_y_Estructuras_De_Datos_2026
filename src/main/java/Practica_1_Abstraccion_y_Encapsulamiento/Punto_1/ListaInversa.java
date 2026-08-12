package Practica_1_Abstraccion_y_Encapsulamiento.Punto_1;
import tp01.ejercicio1.*;
public class ListaInversa {

    public void imprimirInverso( ListaDeEnteros lista){

        validarLista(lista);
        var index = lista.tamanio();
        while (index > 0){
            System.out.println(lista.elemento(index));
            index--;
        }
    }

    public void validarLista(ListaDeEnteros lista){
        if(lista==null) throw new NullPointerException("La lista no puede ser nula");
        if(lista.esVacia()) throw new IllegalArgumentException("La lista no puede estar vacia");
    }
}
