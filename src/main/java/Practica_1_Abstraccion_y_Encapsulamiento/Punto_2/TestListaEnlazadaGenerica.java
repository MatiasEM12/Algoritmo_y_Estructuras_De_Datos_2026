package Practica_1_Abstraccion_y_Encapsulamiento.Punto_2;

import  tp01.ejercicio2.*;
public class TestListaEnlazadaGenerica {

    public static void main(String[] args){

        var estudiante1 = new Estudiante("Pepe", "Argento", 12345);
        var estudiante2 = new Estudiante("Steve", "Jobs", 67890);
        var estudiante3 = new Estudiante("Pepe", "Larraz", 54321);
        var estudiante4 = new Estudiante("Leo", "Messi", 98765);

        ListaGenerica<Estudiante> lista = new ListaEnlazadaGenerica<Estudiante>();

        lista.agregarFinal(estudiante1);
        lista.agregarFinal(estudiante2);
        lista.agregarFinal(estudiante3);
        lista.agregarFinal(estudiante4);

        lista.comenzar();
        while (!lista.fin()) {
            var estudiante = lista.proximo();
            System.out.println(estudiante.tusDatos());
        }
    }
}
