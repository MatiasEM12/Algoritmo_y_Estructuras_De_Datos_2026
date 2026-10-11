package tp06.ejercicio4;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
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

        return  dfsPaseoEnBici(lugares,resultado, 0, origen);
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
    private ListaGenerica<String> dfsPaseoEnBici(Grafo<String> lugares, ListaGenerica<String> resultado,  int tiempoActual, Vertice<String> v) {

        return resultado;
    }
}
