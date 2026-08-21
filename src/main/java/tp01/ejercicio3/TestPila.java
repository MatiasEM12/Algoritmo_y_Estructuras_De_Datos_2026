package tp01.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;

public class TestPila{

    public static void main(String[] args) {

        // Creo la pila utilizando una lista generica
        PilaGenerica<Integer> pila = new PilaGenerica<Integer>(new ListaEnlazadaGenerica<>());

        // Verifico que inicialmente esté vacía
        System.out.println("¿La pila está vacía? " + pila.esVacia());

        // Apilo elementos
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);


        System.out.println("Tope: " + pila.tope());

        // Desapilo elementos
        System.out.println("Desapilado: " + pila.desapilar());
        System.out.println("Tope: " + pila.tope());

        System.out.println("Desapilado: " + pila.desapilar());
        System.out.println("Tope: " + pila.tope());

        System.out.println("Desapilado: " + pila.desapilar());

        // Verifico nuevamente si está vacía
        System.out.println("¿La pila está vacía? " + pila.esVacia());

        // Intento desapilar una pila vacía
        System.out.println("Desapilar pila vacía: " + pila.desapilar());
    }
}