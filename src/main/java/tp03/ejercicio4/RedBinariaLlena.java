package tp03.ejercicio4;

import tp03ab.ArbolBinario;

public class RedBinariaLlena {

    ArbolBinario<Integer> arbol;

    public RedBinariaLlena(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public int retardoReenvio(){
        return retardoReenvioProfundidad(arbol);
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
