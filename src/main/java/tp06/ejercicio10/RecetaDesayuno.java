package tp06.ejercicio10;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.Arista;
import tp06.Grafo;
import tp06.Vertice;

public class RecetaDesayuno<T> {

    private boolean[] marca;

    public ListaGenerica<T> recetaDeDesayuno(Grafo<T> grafo) {

        ListaGenerica<T> resultado = new ListaEnlazadaGenerica<>();

        if (grafo == null || grafo.listaDeVertices().esVacia()) {
            return resultado;
        }

        this.marca = new boolean[grafo.listaDeVertices().tamanio() + 1];

        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
        vertices.comenzar();

        while (!vertices.fin()) {
            Vertice<T> v = vertices.proximo();

            if (!marca[v.getPosicion()]) {
                dfs(grafo, v, resultado);
            }
        }

        return resultado;
    }

    private void dfs(Grafo<T> grafo, Vertice<T> v, ListaGenerica<T> resultado) {

        marca[v.getPosicion()] = true;

        ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(v);

        adyacentes.comenzar();

        while (!adyacentes.fin()) {
            Arista<T> arista = adyacentes.proximo();
            Vertice<T> adyacente = arista.verticeDestino();

            if (!marca[adyacente.getPosicion()]) {
                dfs(grafo, adyacente, resultado);
            }
        }
        //se agrega el vertice al inicio del resultado
        resultado.agregarInicio(v.dato());
    }
}