package tp06.ejercicio4;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.Arista;
import tp06.Grafo;
import tp06.Vertice;

public class VisitaOslo {


    private boolean[] marca;
    private String origen;
    private int maxTiempo;

    public VisitaOslo(String origen){
        this.origen=origen;
    }
    public ListaGenerica<String> paseoEnBici(Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos) {

        ListaGenerica<String> resultado = new ListaEnlazadaGenerica<String>();

        if (this.origen == null || this.origen.isEmpty()) {
            return resultado;
        }
        if (lugares == null || lugares.listaDeVertices().esVacia()) {
            return resultado;
        }

        if (destino == null || destino.isEmpty() || maxTiempo < 0) {
            return resultado;
        }

        if (lugaresRestringidos == null) {
            return resultado;
        }

        if (!lugares.existeVertice(destino)) {
            return resultado;
        }

        this.marca = new boolean[lugares.listaDeVertices().tamanio() + 1];
        this.maxTiempo=maxTiempo;
        Vertice<String> origen = lugares.buscarVertice(this.origen);

        if (origen == null) {
            return resultado;
        }
        if(lugaresRestringidos.incluye(origen.dato()) || lugaresRestringidos.incluye(destino)){
            return resultado;
        }
        if (!this.dfsOslo(lugares, origen, destino, 0, lugaresRestringidos, resultado)) {
            resultado = new ListaEnlazadaGenerica<String>(); // sin camino: lista vacía
        }
        return resultado;
    }

    private boolean dfsOslo(Grafo<String> lugares,Vertice<String > v, String destino, int tiempoActual, ListaGenerica<String> lugaresRestringidos, ListaGenerica<String> resultado){
        this.marca[v.getPosicion()]=true;
        resultado.agregarFinal(v.dato());
        boolean encontrado = false;

        if (v.dato().equals(destino)) {
            encontrado = true;
        }else{

            ListaGenerica<Arista<String>> adyacentes = lugares.listaDeAdyacentes(v);
            adyacentes.comenzar();
            while (!adyacentes.fin()&& !encontrado){

                Arista<String> arista = adyacentes.proximo();
                Vertice<String> w = arista.verticeDestino();
                if(!marca[w.getPosicion()]
                        && !lugaresRestringidos.incluye(w.dato())
                        && (tiempoActual + arista.peso() <= this.maxTiempo)){

                    encontrado = dfsOslo(lugares, w, destino, tiempoActual + arista.peso(), lugaresRestringidos, resultado);
                }

            }

        }

        if (!encontrado) {
            // backtracking: se desenmarca y se saca del resultado(camino)
            this.marca[v.getPosicion()] = false;
            resultado.eliminarEn(resultado.tamanio());
        }
        return encontrado;
    }

}

