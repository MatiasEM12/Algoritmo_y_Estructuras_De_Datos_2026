package tp06.ejercicio9;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.Arista;
import tp06.Grafo;
import tp06.Vertice;

public class RecorridoCamion {

    private boolean[] marca;
    private int pesoCamion;

    public ListaGenerica<ListaGenerica<String>> caminosValidos(Grafo<String> grafo, String origen, String destino, int pesoCamion) {

        //esto es para todos los resultados posibles y no solo el primer resultado encontrado
        ListaGenerica<ListaGenerica<String>> resultados = new ListaEnlazadaGenerica<ListaGenerica<String>>();

        if (grafo == null || grafo.listaDeVertices().esVacia()) {
            return resultados;
        }

        if (origen == null || origen.isEmpty() || destino == null || destino.isEmpty() || pesoCamion <= 0) {
            return resultados;
        }

        Vertice<String> vOrigen = grafo.buscarVertice(origen);

        if (vOrigen == null || !grafo.existeVertice(destino)) {
            return resultados;
        }

        this.marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
        this.pesoCamion = pesoCamion;

        ListaGenerica<String> caminoActual = new ListaEnlazadaGenerica<String>();

        this.dfsCamino(grafo, vOrigen, destino, caminoActual, resultados);

        return resultados;
    }

    private void dfsCamino(Grafo<String> grafo, Vertice<String> v, String destino, ListaGenerica<String> caminoActual, ListaGenerica<ListaGenerica<String>> resultados) {

        this.marca[v.getPosicion()] = true;
        caminoActual.agregarFinal(v.dato());

        if (v.dato().equals(destino)) {

            // Se copia el camino encontrado y se agrega a resultado
            ListaGenerica<String> copia = new ListaEnlazadaGenerica<String>();

            caminoActual.comenzar();

            while (!caminoActual.fin()) {
                copia.agregarFinal(caminoActual.proximo());
            }

            resultados.agregarFinal(copia);

        } else {

            ListaGenerica<Arista<String>> adyacentes = grafo.listaDeAdyacentes(v);

            adyacentes.comenzar();

            while (!adyacentes.fin()) {

                Arista<String> arista = adyacentes.proximo();
                Vertice<String> w = arista.verticeDestino();

                if (!marca[w.getPosicion()] && arista.peso() >= this.pesoCamion) {

                    this.dfsCamino(grafo, w, destino, caminoActual, resultados);
                }
            }
        }

        // Backtracking
        this.marca[v.getPosicion()] = false;
        caminoActual.eliminarEn(caminoActual.tamanio());
    }
}