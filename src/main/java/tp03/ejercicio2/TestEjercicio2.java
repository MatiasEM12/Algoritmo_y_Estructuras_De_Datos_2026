package tp03.ejercicio2;

import tp03ab.ArbolBinario;


public class TestEjercicio2 {

    public static void main() {

        /*Construyo el arbol:
        *         1
        *     /      \
        *    2        3
        *  /    \     /
        * 4      5    6
        * */

        ArbolBinario<Integer> arbolRaiz = new ArbolBinario<>(1);
        ArbolBinario<Integer> arbolHijo1 = new ArbolBinario<>(2);
        ArbolBinario<Integer> arbolHijo2 = new ArbolBinario<>(3);
        ArbolBinario<Integer> arbolHijo3 = new ArbolBinario<>(4);
        ArbolBinario<Integer> arbolHijo4 = new ArbolBinario<>(5);
        ArbolBinario<Integer> arbolHijo5 = new ArbolBinario<>(6);

        arbolRaiz.agregarHijoIzquierdo(arbolHijo1);
        arbolRaiz.agregarHijoDerecho(arbolHijo2);

        arbolHijo1.agregarHijoIzquierdo(arbolHijo3);
        arbolHijo1.agregarHijoDerecho(arbolHijo4);

        arbolHijo2.agregarHijoIzquierdo(arbolHijo5);

        //test cantidad de Hojas
        System.out.println("Cantidad de hojas: " + arbolRaiz.contarHojas()); // Debería imprimir 3


        //test arbol espejo y entre niveles

        System.out.println("Arbol original: ");
        arbolRaiz.entreNiveles(0, 2);

        ArbolBinario<Integer> arbolEspejo = arbolRaiz.espejo();
        System.out.println("Arbol espejo: ");
        arbolEspejo.entreNiveles(0, 2);

        /* arbol espejo:
         *         1
         *     /      \
         *    3        2
         *     \      / \
         *      6    5   4
         * */

    }


}
