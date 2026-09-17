package tp03.ejercicio4;

import tp03ab.ArbolBinario;

public class RedBinariaLlena {

    ArbolBinario<Integer> arbol;

    public RedBinariaLlena(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio(){

        if(arbol.estaLleno()){
            return retardoReenvioProfundidad(arbol);
        }
        return -1;
    }

    private int retardoReenvioProfundidad(ArbolBinario<Integer> arbol){

        if (arbol.esHoja()) {
            return arbol.getDato();
        }
        int retardoIzquierdo = retardoReenvioProfundidad(arbol.getHijoIzquierdo());
        int retardoDerecho = retardoReenvioProfundidad(arbol.getHijoDerecho());

        return arbol.getDato() + Math.max(retardoIzquierdo, retardoDerecho);
    }

}
