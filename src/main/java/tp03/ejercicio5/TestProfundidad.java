package tp03.ejercicio5;

import tp03ab.ArbolBinario;

public class TestProfundidad {

    public static void main() {
        /*Construyo el arbol:
         *         1
         *     /      \
         *    2        3
         *  /    \     / \
         * 4      10    6   7
         * */

        ArbolBinario<Integer> arbolRaiz = new ArbolBinario<>(1);
        ArbolBinario<Integer> arbolHijo1 = new ArbolBinario<>(2);
        ArbolBinario<Integer> arbolHijo2 = new ArbolBinario<>(3);
        ArbolBinario<Integer> arbolHijo3 = new ArbolBinario<>(4);
        ArbolBinario<Integer> arbolHijo4 = new ArbolBinario<>(10);
        ArbolBinario<Integer> arbolHijo5 = new ArbolBinario<>(6);
        ArbolBinario<Integer> arbolHijo6 = new ArbolBinario<>(7);

        arbolRaiz.agregarHijoIzquierdo(arbolHijo1);
        arbolRaiz.agregarHijoDerecho(arbolHijo2);

        arbolHijo1.agregarHijoIzquierdo(arbolHijo3);
        arbolHijo1.agregarHijoDerecho(arbolHijo4);

        arbolHijo2.agregarHijoIzquierdo(arbolHijo5);
        arbolHijo2.agregarHijoDerecho(arbolHijo6);

        ProfundidadDeArbolBinario profundidadArbol = new ProfundidadDeArbolBinario(arbolRaiz);

        System.out.println("Suma de elementos en profundidad 0: " + profundidadArbol.sumaElementosProfundidad(0)); //valor esperado 1
        System.out.println("Suma de elementos en profundidad 1: " + profundidadArbol.sumaElementosProfundidad(1)); //valor esperado 5 (2 + 3)
        System.out.println("Suma de elementos en profundidad 2: " + profundidadArbol.sumaElementosProfundidad(2)); //valor esperado 27 (4 + 10 + 6 + 7)
        System.out.println("Suma de elementos en profundidad 3: " + profundidadArbol.sumaElementosProfundidad(3)); //valor esperado 0

    }
}
