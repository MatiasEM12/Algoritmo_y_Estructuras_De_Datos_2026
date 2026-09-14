package tp03.ejercicio2;

import tp03ab.ArbolBinario;
import tp03abb.ArbolBinarioDeBusqueda;

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


        //test arbol espejo

        System.out.println("Arbol original: ");
        imprimirArbol(arbolRaiz, 0);

        ArbolBinario<Integer> arbolEspejo = arbolRaiz.espejo();
        System.out.println("Arbol espejo: ");
        imprimirArbol(arbolEspejo, 0);

        /* arbol espejo:
         *         1
         *     /      \
         *    3        2
         *     \      / \
         *      6    5   4
         * */

    }

    private static  void imprimirArbol(ArbolBinario arbol, int nivel) {
        if (arbol == null || arbol.esVacio()) {
            return;
        }

        //Recorre primero el subárbol derecho
        if (arbol.tieneHijoDerecho()) {
            imprimirArbol(arbol.getHijoDerecho(), nivel + 1);
        }

        // Imprimir el nodo actual con sangría según su profundidad
        for (int i = 0; i < nivel; i++) {
            System.out.print("    "); // 4 espacios por cada nivel de profundidad
        }
        System.out.println("└─ " + arbol.getDato());

        // Recorre el subárbol izquierdo
        if (arbol.tieneHijoIzquierdo()) {
            imprimirArbol(arbol.getHijoIzquierdo(), nivel + 1);
        }
    }
}
