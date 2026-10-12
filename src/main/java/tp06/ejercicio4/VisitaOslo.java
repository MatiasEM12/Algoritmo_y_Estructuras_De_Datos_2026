package tp06.ejercicio4;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.Arista;
import tp06.Grafo;
import tp06.Vertice;

public class VisitaOslo {

    private String destino;
    private int maxTiempo;
    private ListaGenerica<String> lugaresRestringidos;
    private ListaGenerica<String> camino;
    private boolean[] marca;

    public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos){

        ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();
        if (lugares == null ||lugares.listaDeVertices().esVacia()) {
            return resultado;
        }

        if(destino==null || destino.isEmpty() || maxTiempo<=0){
            return resultado;
        }

        if (lugaresRestringidos == null ) {
            return resultado;
        }

        if(!this.existeDestino(lugares,destino)){
            return resultado;
        }

        Vertice<String> origen = buscarOrigen(lugares);
        if (origen == null) {
            return resultado;
        }

        this.destino=destino;
        this.maxTiempo=maxTiempo;
        this.lugaresRestringidos=lugaresRestringidos;


        this.marca = new boolean[lugares.listaDeVertices().tamanio()+1];

        for(int i=0; i<marca.length; i++){
            marca[i]=false;
        }

        if (dfsPaseoEnBici(lugares, 0, origen)) {
            return this.camino;
        }

        return resultado;
    }

    private boolean existeDestino(Grafo<String> lugares, String destino) {

        ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();
        vertices.comenzar();
        while(!vertices.fin()) {
            Vertice<String> v = vertices.proximo();
            if (v.dato().equals(destino)) {
                return true;
            }
        }
        return false;
    }

    private Vertice<String> buscarOrigen(Grafo<String> lugares) {
        ListaGenerica<Vertice<String>> vertices = lugares.listaDeVertices();

        vertices.comenzar();

        while (!vertices.fin()) {
            Vertice<String> v = vertices.proximo();

            if (v.dato().equalsIgnoreCase("Ayuntamiento")) {
                return v;
            }
        }

        return null;
    }

    private boolean dfsPaseoEnBici(Grafo<String> lugares, int tiempoActual, Vertice<String> v) {


        if (lugaresRestringidos.incluye(v.dato())) {
            return false;
        }


        if (tiempoActual > maxTiempo) {
            return false;
        }

        camino.agregarFinal(v.dato());
        marca[v.getPosicion()] = true;

        // Caso base
        if (v.dato().equalsIgnoreCase(destino)) {
            return true;
        }


        //buscar el camino
        ListaGenerica<Arista<String>> adyacentes = lugares.listaDeAdyacentes(v);

        adyacentes.comenzar();
        while (!adyacentes.fin()) {
            Arista<String> arista = adyacentes.proximo();
            Vertice<String> w = arista.verticeDestino();

            if (!marca[w.getPosicion()]) {
                int nuevoTiempo = tiempoActual + arista.peso();

                if (dfsPaseoEnBici(lugares, nuevoTiempo, w)) {
                    return true;
                }
            }
        }

        //el camino  no funcionó.
        marca[v.getPosicion()] = false;
        camino.eliminarEn(camino.tamanio());

        return false;
    }
}
