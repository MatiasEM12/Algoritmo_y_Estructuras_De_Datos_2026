package tp03.ejercicio10;

import tp03abb.ArbolBinarioDeBusqueda;

public class TestInmediatoMayorAlternativo {

    public static void main() {
        //utilizando el metodo de abb : buscarMenorDeLosMayores



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

        ArbolBinarioDeBusqueda<Integer> nodo = arbol.buscar(40, arbol);
        InmediatoMayorAlternativo inmediatoMayorAlternativo = new InmediatoMayorAlternativo();
        Integer resultado = inmediatoMayorAlternativo.inmediatoMayorAlternativo(arbol, 40);
        System.out.println("El inmediato mayor de 40 es: " + resultado);

    }


}
