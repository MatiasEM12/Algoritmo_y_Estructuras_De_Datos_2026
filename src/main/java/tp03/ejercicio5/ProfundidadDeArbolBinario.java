package tp03.ejercicio5;

import tp03ab.ArbolBinario;

public class ProfundidadDeArbolBinario {

    ArbolBinario<Integer> arbol;

    public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

    public int sumaElementosProfundidad(int p){
        return sumaElementosProfundidadRecursivo(arbol, p, 0);
    }

    private int sumaElementosProfundidadRecursivo(ArbolBinario<Integer> arbol, int p, int profundidadActual) {

        if(profundidadActual==p){

            return arbol.getDato();
        }

        int suma = 0;
        if(arbol.tieneHijoIzquierdo()){
            var hijoIzquierdo = arbol.getHijoIzquierdo();
            suma += sumaElementosProfundidadRecursivo(hijoIzquierdo, p, profundidadActual + 1);
        }

        if(arbol.tieneHijoDerecho()){
            var hijoDerecho = arbol.getHijoDerecho();
            suma +=  sumaElementosProfundidadRecursivo(hijoDerecho, p, profundidadActual + 1);
        }

        return suma;
    }
}
