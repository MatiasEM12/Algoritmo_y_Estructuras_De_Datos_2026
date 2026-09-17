package tp03.ejercicio4;

import tp03ab.ArbolBinario;

public class TestRedBinariaLlena {

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

        int retardo = new RedBinariaLlena(arbolRaiz).retardoReenvio();
        System.out.println("El retardo de reenvio es: " + retardo); //valor esperado 13


        //ahora cuando el arbol no esta lleno
        arbolHijo2.eliminarHijoDerecho();
        int retardo2 = new RedBinariaLlena(arbolRaiz).retardoReenvio();
        System.out.println("El retardo de reenvio es: " + retardo2); //valor esperado -1

    }
}
