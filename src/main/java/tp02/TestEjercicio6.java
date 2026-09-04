package tp02;

public class TestEjercicio6 {
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


        nodo1.agregarHijo(nodo2);
        nodo1.agregarHijo(nodo3);
        nodo1.agregarHijo(nodo4);

        nodo2.agregarHijo(nodo5);
        nodo2.agregarHijo(nodo6);

        nodo4.agregarHijo(nodo7);
        nodo4.agregarHijo(nodo8);

        nodo7.agregarHijo(nodo9);


        /*
                  1
            /     |     \
           2      3      4
         /  \           / \
        5    6         7   8
                       |
                        9
        */



        // ALTURA

        System.out.println("Altura del árbol: " + nodo1.altura());   // 3




        // Nivek
        System.out.println("\nNIVEL");

        System.out.println("Nivel de 1: " + nodo1.nivel(1));
        System.out.println("Nivel de 2: " + nodo1.nivel(2));
        System.out.println("Nivel de 5: " + nodo1.nivel(5));
        System.out.println("Nivel de 9: " + nodo1.nivel(9));
        System.out.println("Nivel de 100: " + nodo1.nivel(100));

        /*
        Esperado:

        Nivel de 1: 0
        Nivel de 2: 1
        Nivel de 5: 2
        Nivel de 9: 3
        Nivel de 100: -1
        */



        // ANCHO
        System.out.println("\nAncho");

        System.out.println("Ancho del árbol: " + nodo1.ancho());

        /*
         Nivel 0 → 1       → 1 nodo
         Nivel 1 → 2 3 4   → 3 nodos
         Nivel 2 → 5 6 7 8 → 4 nodos
         Nivel 3 → 9       → 1 nodo

         El máximo es 4
        */


        // ANCESTROS

        System.out.println("\nAncestros");

        System.out.println("¿1 es ancestro de 9?: " + nodo1.esAncestro(1, 9)); //TRUE

        System.out.println("¿2 es ancestro de 6?: " + nodo1.esAncestro(2, 6)); //TRUE

        System.out.println("¿4 es ancestro de 9?: " + nodo1.esAncestro(4, 9)); //TRUE

        System.out.println("¿3 es ancestro de 9?: " + nodo1.esAncestro(3, 9)); //FALSE

        System.out.println("¿5 es ancestro de 6?: " + nodo1.esAncestro(5, 6)); //FALSE




        // ÁRBOL LLENO

        System.out.println("\nArbol lleno");

        System.out.println("¿El árbol es lleno?: " + nodo1.esArbolLleno()); //FALSE


        // ÁRBOL COMPLETO


        System.out.println("\nArbol completo");

        System.out.println("¿El árbol es completo?: " + nodo1.esArbolCompleto()); //FALSE

    }
}
