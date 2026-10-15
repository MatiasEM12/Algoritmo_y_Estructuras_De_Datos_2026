package tp06.Test;

import tp01.ejercicio2.ListaGenerica;
import tp06.Grafo;
import tp06.ListaDeAdyaciencia.GrafoImplListAdy;
import tp06.ListaDeAdyaciencia.VerticeImplListAdy;
import tp06.Vertice;
import tp06.ejercicio9.RecorridoCamion;

public class Test9RecorridoCamion {

    public static void main(String[] args) {

        Grafo<String> grafo = new GrafoImplListAdy<>();

        String origen = "A";
        String destino ="E";

        Vertice<String> vA = new VerticeImplListAdy<>(origen);
        Vertice<String> vB = new VerticeImplListAdy<>("B");
        Vertice<String> vC = new VerticeImplListAdy<>("C");
        Vertice<String> vD = new VerticeImplListAdy<>("D");
        Vertice<String> vE = new VerticeImplListAdy<>(destino);

        grafo.agregarVertice(vA);
        grafo.agregarVertice(vB);
        grafo.agregarVertice(vC);
        grafo.agregarVertice(vD);
        grafo.agregarVertice(vE);

        grafo.conectar(vA, vB, 5);
        grafo.conectar(vB, vA, 5);

        grafo.conectar(vA, vD, 4);
        grafo.conectar(vD, vA, 4);

        grafo.conectar(vA, vC, 2);
        grafo.conectar(vC, vA, 2);

        grafo.conectar(vB, vC, 2);
        grafo.conectar(vC, vB, 2);

        grafo.conectar(vB, vD, 3);
        grafo.conectar(vD, vB, 3);

        grafo.conectar(vC, vD, 1);
        grafo.conectar(vD, vC, 1);

        grafo.conectar(vD, vE, 6);
        grafo.conectar(vE, vD, 6);


        int pesoCamion = 3;

        RecorridoCamion recorridoCamion = new RecorridoCamion();
        ListaGenerica<ListaGenerica<String>> caminos = recorridoCamion.caminosValidos(grafo, origen, destino, pesoCamion);

        caminos.comenzar();
        while (!caminos.fin()) {
            ListaGenerica<String> camino = caminos.proximo();
            camino.comenzar();
            System.out.print("Camino válido: ");
            while (!camino.fin()) {
                System.out.print(camino.proximo() + " ");
            }
            System.out.println();
        }
    }
}
