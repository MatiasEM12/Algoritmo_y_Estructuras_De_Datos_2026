package tp02.ejercicio3;

import tp01.ejercicio2.ListaGenerica;
import tp02.ArbolGeneral;


public class TestRecorridosAG {

    public static void main() {

        ArbolGeneral<Integer> nodo1 = new ArbolGeneral<>(1);
        ArbolGeneral<Integer> nodo2 = new ArbolGeneral<>(2);
        ArbolGeneral<Integer> nodo3 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> nodo4 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> nodo5 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> nodo6 = new ArbolGeneral<>(6);
        ArbolGeneral<Integer> nodo7 = new ArbolGeneral<>(7);


        nodo1.agregarHijo(nodo2);
        nodo1.agregarHijo(nodo3);
        nodo1.agregarHijo(nodo4);

        nodo2.agregarHijo(nodo5);
        nodo2.agregarHijo(nodo6);

        nodo4.agregarHijo(nodo7);

        /*
         *        1
         *      / | \
         *     2  3  4
         *    / \    |
         *   5   6   7
         */

        RecorridosAG recorridos = new RecorridosAG();

        // Números impares mayores que 3
        Integer n = 3;

        ListaGenerica<Integer> preOrden = recorridos.numerosImparesMayoresQuePreOrden(nodo1, n);

        ListaGenerica<Integer> inOrden = recorridos.numerosImparesMayoresQueInOrden(nodo1, n);

        ListaGenerica<Integer> postOrden = recorridos.numerosImparesMayoresQuePostOrden(nodo1, n);

        ListaGenerica<Integer> porNivel = recorridos.numerosImparesMayoresQuePorNiveles(nodo1, n);



        System.out.println("Impares mayores que " + n);

        System.out.print("Preorden: ");
        preOrden.comenzar();
        while (!preOrden.fin()) {
            System.out.print(preOrden.proximo() + " ");
        }

        System.out.println();

        System.out.print("Inorden: ");
        inOrden.comenzar();
        while (!inOrden.fin()) {
            System.out.print(inOrden.proximo() + " ");
        }

        System.out.println();

        System.out.print("Postorden: ");
        postOrden.comenzar();
        while (!postOrden.fin()) {
            System.out.print(postOrden.proximo() + " ");
        }

        System.out.println();

        System.out.print("Por niveles: ");
        porNivel.comenzar();
        while (!porNivel.fin()) {
            System.out.print(porNivel.proximo() + " ");
        }
    }

}
