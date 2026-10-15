package tp06.Test;

import tp01.ejercicio2.ListaGenerica;
import tp06.Grafo;
import tp06.ListaDeAdyaciencia.GrafoImplListAdy;
import tp06.ListaDeAdyaciencia.VerticeImplListAdy;
import tp06.Vertice;
import tp06.ejercicio10.RecetaDesayuno;


public class Test10Receta {

    public static void main() {


        Grafo<String> grafo = new GrafoImplListAdy<>();

        Vertice<String> vA = new VerticeImplListAdy<>("A: Mezclar los ingredientes (harina, leche, huevos).");
        Vertice<String> vB = new VerticeImplListAdy<>("B: Calentar la sartén.");
        Vertice<String> vC = new VerticeImplListAdy<>("C: Verter la mezcla en la sartén y cocinar.");
        Vertice<String> vD = new VerticeImplListAdy<>("D: Servir en el plato.");
        Vertice<String> vE = new VerticeImplListAdy<>("E: Agregar dulce de leche (o miel).");

        grafo.agregarVertice(vA);
        grafo.agregarVertice(vB);
        grafo.agregarVertice(vC);
        grafo.agregarVertice(vD);
        grafo.agregarVertice(vE);

        grafo.conectar(vA, vC);
        grafo.conectar(vB, vC);
        grafo.conectar(vC, vD);
        grafo.conectar(vD, vE);


        RecetaDesayuno<String> receta = new RecetaDesayuno<>();
        ListaGenerica<String> resultado = receta.recetaDeDesayuno(grafo);

        System.out.println("Orden de pasos para preparar el desayuno:");
        resultado.comenzar();
        while(!resultado.fin()){
            String s = resultado.proximo();
            System.out.println(s);
        }
    }
}
