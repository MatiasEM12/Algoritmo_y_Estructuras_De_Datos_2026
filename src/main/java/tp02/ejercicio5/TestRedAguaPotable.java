package tp02.ejercicio5;

import tp02.ArbolGeneral;

public class TestRedAguaPotable {

    public static void main() {



        ArbolGeneral<Integer> nodo1 = new ArbolGeneral<>(1);
        ArbolGeneral<Integer> nodo2 = new ArbolGeneral<>(2);
        ArbolGeneral<Integer> nodo3 = new ArbolGeneral<>(3);
        ArbolGeneral<Integer> nodo4 = new ArbolGeneral<>(4);
        ArbolGeneral<Integer> nodo5 = new ArbolGeneral<>(5);
        ArbolGeneral<Integer> nodo6 = new ArbolGeneral<>(6);
        ArbolGeneral<Integer> nodo7 = new ArbolGeneral<>(7);
        ArbolGeneral<Integer> nodo8 = new ArbolGeneral<>(8);
        ArbolGeneral<Integer> nodo9 = new ArbolGeneral<>(9);
        ArbolGeneral<Integer> nodo10 = new ArbolGeneral<>(10);


        nodo1.agregarHijo(nodo2);
        nodo1.agregarHijo(nodo3);
        nodo1.agregarHijo(nodo4);

        nodo2.agregarHijo(nodo5);
        nodo2.agregarHijo(nodo6);

        nodo4.agregarHijo(nodo7);
        nodo4.agregarHijo(nodo8);

        nodo8.agregarHijo(nodo9);
        nodo8.agregarHijo(nodo10);


        RedDeAguaPotable red = new RedDeAguaPotable(nodo1);

        // Caudal inicial
        double caudal = 120;

        /*
               1(120)
            /      |     \
           2(40)   3(40)  4(20)
          /   \      /  \
       5(20)  6(20) 7(20) 8(20)
                           /   \
                         10(10) 9(10)
        */
        double resultado = red.minimoCaudal(caudal);

        System.out.println("Caudal inicial: " + caudal);
        System.out.println("Mínimo caudal recibido: " + resultado);
    }

}
