package Practica_1_Abstraccion_y_Encapsulamiento.Punto_1;

import tp01.ejercicio1.*;
public class Test_ListaInversa {

    public static void main(String[] args){

        ListaDeEnterosEnlazada listaEnlazada = new ListaDeEnterosEnlazada();
        ListaDeEnterosConArreglos listaArreglo = new ListaDeEnterosConArreglos();
        ListaInversa listaInversa = new ListaInversa();

        for(String arg :args){
            listaEnlazada.agregarFinal(Integer.parseInt(arg));
            listaArreglo.agregarFinal(Integer.parseInt(arg));
        }

        System.out.println("Lista enlazada inversa:");
        listaInversa.imprimirInverso(listaEnlazada);

        System.out.println("Lista con Arreglo inversa:");
        listaInversa.imprimirInverso(listaArreglo);
    }

}
