package tp03.ejercicio10;

import tp03abb.ArbolBinarioDeBusqueda;

public class TestInmediatoMayor {
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

        InmediatoMayor inmediatoMayor = new InmediatoMayor(arbol, 40);
        Integer resultado = inmediatoMayor.inmediatoMayor();
        System.out.println("El inmediato mayor de 40 es: " + resultado);
    }
}
