package Practica_1_Abstraccion_y_Encapsulamiento.Punto_1;

import tp01.ejercicio1.*;

public class TestListaDeEnterosConArreglos {

    public static void main(String[] args){

        ListaDeEnterosConArreglos lista= new ListaDeEnterosConArreglos();


        for (String arg : args) {
            lista.agregarFinal(Integer.parseInt(arg));
        }
        lista.comenzar();

        while (!lista.fin()) {
            System.out.println(lista.proximo());
        }
    }
}
