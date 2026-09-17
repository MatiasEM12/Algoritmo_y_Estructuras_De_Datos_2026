package tp03.ejercicio9;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp03abb.ArbolBinarioDeBusqueda;

public class RecorridoDeArbolBinario {


    private ArbolBinarioDeBusqueda<Integer> arbol;
    private Integer buscado;

    public RecorridoDeArbolBinario(ArbolBinarioDeBusqueda<Integer> arbol, Integer buscado) {
        this.arbol = arbol;
        this.buscado=buscado;
    }

    public ListaGenerica<Integer> caminoRecorrido (ArbolBinarioDeBusqueda<Integer> arbol){

        ListaEnlazadaGenerica<Integer> camino = new ListaEnlazadaGenerica<Integer>();

        caminoRecorrido(arbol, camino,false);

        return camino;
    }

    private void caminoRecorrido(ArbolBinarioDeBusqueda<Integer> arbol, ListaEnlazadaGenerica<Integer> camino, boolean signo) {

        if (!arbol.getDato().equals(buscado)) {

            if(signo){
                camino.agregarFinal(-Math.abs(arbol.getDato())); //paso el numero a negativo
            }else{
                camino.agregarFinal(arbol.getDato());
            }

            if (arbol.getDato().compareTo(buscado) < 0) {
                caminoRecorrido(arbol.getHijoDerecho(), camino, false);

            } else if (arbol.getDato().compareTo(buscado) > 0) {
                caminoRecorrido(arbol.getHijoIzquierdo(), camino,true);
            }
        }
    }


}
