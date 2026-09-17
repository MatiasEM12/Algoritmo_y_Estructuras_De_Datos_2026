package tp03.ejercicio10;

import tp03abb.ArbolBinarioDeBusqueda;

public class InmediatoMayorAlternativo {
    //utilizando el metodo de abb : buscarMenorDeLosMayores
    public  Integer inmediatoMayorAlternativo(ArbolBinarioDeBusqueda<Integer> arbol, Integer buscado) {

        ArbolBinarioDeBusqueda<Integer> nodo = arbol.buscar(buscado, arbol);

        if (nodo == null) {
            return null;
        }

        // Caso 1: tiene subárbol derecho
        if (nodo.tieneHijoDerecho()) {

            ArbolBinarioDeBusqueda<Integer> sucesor = arbol.buscarMenorDeLosMayores(nodo);

            return sucesor.getDato();
        }

        // Caso 2: no tiene subárbol derecho
        // se busca el antecesor mayor más cercano

        ArbolBinarioDeBusqueda<Integer> aux = arbol;
        Integer sucesor = null;

        while (aux != null && !aux.esVacio()) {

            if (buscado.compareTo(aux.getDato()) < 0) {

                sucesor = aux.getDato();
                aux = aux.getHijoIzquierdo();

            } else if (buscado.compareTo(aux.getDato()) > 0) {

                aux = aux.getHijoDerecho();

            } else {
                break;
            }
        }

        return sucesor;
    }

}
