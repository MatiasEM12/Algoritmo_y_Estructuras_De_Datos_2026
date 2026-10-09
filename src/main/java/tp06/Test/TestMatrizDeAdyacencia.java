package tp06.Test;

import tp01.ejercicio2.ListaGenerica;
import tp06.Arista;
import tp06.Grafo;
import tp06.MatrizDeAdyacencia.GrafoImplMatrizAdy;
import tp06.MatrizDeAdyacencia.VerticeImplMatrizAdy;
import tp06.Vertice;

public class TestMatrizDeAdyacencia {

    public static void main(String[] args) {

        Grafo<Integer> grafo = new GrafoImplMatrizAdy<>(10);

        Vertice<Integer> v1 = new VerticeImplMatrizAdy<>(1);
        Vertice<Integer> v2 = new VerticeImplMatrizAdy<>(2);
        Vertice<Integer> v3 = new VerticeImplMatrizAdy<>(3);
        Vertice<Integer> v4 = new VerticeImplMatrizAdy<>(4);

        // Agregar vértices
        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);

        // Conectar
        grafo.conectar(v1, v2);
        grafo.conectar(v1, v3, 5);
        grafo.conectar(v2, v4, 10);
        grafo.conectar(v3, v4, 20);

        // Consultar adyacencias
        System.out.println();
        System.out.println("v1 -> v2: " + grafo.esAdyacente(v1, v2));
        System.out.println("v1 -> v4: " + grafo.esAdyacente(v1, v4));

        // Consultar pesos
        System.out.println();
        System.out.println("Peso v1 -> v2: " + grafo.peso(v1, v2));
        System.out.println("Peso v1 -> v3: " + grafo.peso(v1, v3));

        // Mostrar adyacentes de v1
        System.out.println();
        System.out.println("Adyacentes de v1:");

        ListaGenerica<Arista<Integer>> adyacentes = grafo.listaDeAdyacentes(v1);

        adyacentes.comenzar();

        while (!adyacentes.fin()) {
            Arista<Integer> arista = adyacentes.proximo();

            System.out.println(
                    "Destino: " + arista.verticeDestino().dato() + " - Peso: " + arista.peso()
            );
        }

        // Desconectar
        grafo.desConectar(v1, v2);
        System.out.println();
        System.out.println("v1 -> v2 después de desconectar: " + grafo.esAdyacente(v1, v2));
        System.out.println("v1 -> v3: " + grafo.esAdyacente(v1, v3));
        System.out.println("v2 -> v4: " + grafo.esAdyacente(v2, v4));
        System.out.println("v3 -> v4: " + grafo.esAdyacente(v3, v4));

        // Eliminar vértice
        System.out.println();
        System.out.println("Antes de eliminar v3:");
        System.out.println("v1 -> v3: " + grafo.esAdyacente(v1, v3));
        System.out.println("v3 -> v4: " + grafo.esAdyacente(v3, v4));

        System.out.println("Adyacentes de v3 antes de eliminar:");

        ListaGenerica<Arista<Integer>> adyacentesV3 = grafo.listaDeAdyacentes(v3);

        adyacentesV3.comenzar();

        while (!adyacentesV3.fin()) {
            Arista<Integer> arista = adyacentesV3.proximo();

            System.out.println("v3 -> " + arista.verticeDestino().dato() + " - Peso: " + arista.peso());
        }
        grafo.eliminarVertice(v3);


        System.out.println();
        System.out.println("Después de eliminar v3:");

        System.out.println("¿Existe v3?: " + grafo.listaDeVertices().incluye(v3));

        System.out.println("v1 -> v3: " + grafo.esAdyacente(v1, v3));

        System.out.println("v3 -> v4: " + grafo.esAdyacente(v3, v4));

        System.out.println("v1 -> v3 después de eliminar: " + grafo.esAdyacente(v1, v3));

        ListaGenerica<Arista<Integer>> adyacentesV3Eliminado = grafo.listaDeAdyacentes(v3);
        adyacentesV3Eliminado.comenzar();

        while (!adyacentesV3Eliminado.fin()) {
            Arista<Integer> arista = adyacentesV3Eliminado.proximo();

            System.out.println("v3 -> " + arista.verticeDestino().dato() + " - Peso: " + arista.peso());
        }
    }
}
