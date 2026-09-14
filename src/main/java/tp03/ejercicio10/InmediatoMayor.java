package tp03.ejercicio10;

import tp03abb.ArbolBinarioDeBusqueda;

public class InmediatoMayor {



    private ArbolBinarioDeBusqueda<Integer> arbol;
    private Integer buscado;

    public  InmediatoMayor(ArbolBinarioDeBusqueda<Integer> arbol, Integer buscado) {
        this.arbol = arbol;
        this.buscado=buscado;
    }

    public Integer inmediatoMayor() {
        return inmediatoMayor(this.arbol);
    }

    private Integer inmediatoMayor(ArbolBinarioDeBusqueda<Integer> arbol) {
        Integer sucesor = -1;
        ArbolBinarioDeBusqueda<Integer> nodoActual = arbol;

        while(nodoActual != null && !nodoActual.esVacio()){
            if(buscado< nodoActual.getDato()){
                sucesor = nodoActual.getDato();
                nodoActual = nodoActual.getHijoIzquierdo();
            }else{
                nodoActual = nodoActual.getHijoDerecho();
            }
        }


        return sucesor;
    }
}
