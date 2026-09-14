package tp03.ejercicio9;


import tp01.ejercicio2.ListaGenerica;
import tp03abb.ArbolBinarioDeBusqueda;

public class TestRecorridoABB {

    public static void main() {

        /*Construyo el arbol:
         *        100
         *     /      \
         *    20        300
         *  /    \       /
         * 4      30    150
         *       /  \
         *      24  40
         *    /
         *  23
         * */


        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>(100);
        arbol.agregar( 20);
        arbol.agregar( 300);
        arbol.agregar(  4);
        arbol.agregar(  30);
        arbol.agregar(  150);
        arbol.agregar(  24);
        arbol.agregar(  40);
        arbol.agregar(  23);

        RecorridoDeArbolBinario recorrido = new RecorridoDeArbolBinario(arbol, 23);
        ListaGenerica<Integer> camino = recorrido.caminoRecorrido(arbol);

        //100 -20 30 -24
        camino.comenzar();
        while (!camino.fin()) {
            System.out.print(camino.proximo() + " ");
        }
    }
}
