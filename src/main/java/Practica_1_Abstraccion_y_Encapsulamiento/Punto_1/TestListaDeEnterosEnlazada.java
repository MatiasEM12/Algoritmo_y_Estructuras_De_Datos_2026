package Practica_1_Abstraccion_y_Encapsulamiento.Punto_1;

import tp01.ejercicio1.*;
public class TestListaDeEnterosEnlazada {

    public static void main(String[] args){

        ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();

        for (String arg : args){
            lista.agregarFinal(Integer.parseInt(arg));
        }

        lista.comenzar();

        while (!lista.fin()){
            System.out.println(lista.proximo());
        }
    }

}
