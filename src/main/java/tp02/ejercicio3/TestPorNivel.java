package tp02.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp02.ArbolGeneral;

public class TestPorNivel {

    public static void main(String[] args) {

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

        ListaEnlazadaGenerica<Integer> resultado = nodo1.porNivel();

        System.out.println("Recorrido por nivel:");

        resultado.comenzar();
        //1 2 3 4 5 6 7
        while (!resultado.fin()) {
            System.out.print(resultado.proximo() + " ");
        }
    }

}