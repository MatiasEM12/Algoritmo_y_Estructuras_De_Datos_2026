package tp03.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp03ab.ArbolBinario;

public class TestContadorArbol {

    public static void main() {

         /*Construyo el arbol:
         *         0
         *     /      \
         *    2        3
         *  /    \     /
         * 4      5    6
         * */

        ArbolBinario<Integer> arbolRaiz = new ArbolBinario<>(0);
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

        ContadorArbol contador = new ContadorArbol(arbolRaiz);
        ListaEnlazadaGenerica<Integer> numerosPares = contador.numerosPares();

        numerosPares.comenzar();
        //inOrden : 4206
        //PostOrden: 4260
        while (!numerosPares.fin()) {
            System.out.println(numerosPares.proximo());
        }

    }
}
