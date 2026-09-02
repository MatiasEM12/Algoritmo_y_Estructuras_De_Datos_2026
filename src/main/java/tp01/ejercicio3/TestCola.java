package tp01.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;


public class TestCola {

    public static void main(String[] args) {

        // Creo la cola utilizando una lista
        ColaGenerica<Integer> cola = new ColaGenerica<Integer>();

        // Verifico que inicialmente esté vacía
        System.out.println("¿La cola está vacía? " + cola.esVacia());

        // Encolo elementos
        cola.encolar(10);
        cola.encolar(20);
        cola.encolar(30);

        // Muestro el elemento que está en el frente
        System.out.println("Tope: " + cola.tope());

        // Desencolo elementos
        System.out.println("Desencolado: " + cola.desencolar());
        System.out.println("Tope: " + cola.tope());

        System.out.println("Desencolado: " + cola.desencolar());
        System.out.println("Tope: " + cola.tope());

        System.out.println("Desencolado: " + cola.desencolar());

        // Verifico nuevamente si está vacía
        System.out.println("¿La cola está vacía? " + cola.esVacia());

        // Intento desencolar una cola vacía
        System.out.println("Desencolar cola vacía: " + cola.desencolar());
    }
}
