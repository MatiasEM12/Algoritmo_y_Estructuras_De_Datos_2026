package tp05.ejercicio8;


public class TestKEnesimoElemento {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("TEST K-ESIMO ELEMENTO\n");

        // arreglo desordenado
        Integer[] datos = {12, 4, 6, 1, 89, 89, 3, 6, 3, 17, 20, 5};


        KEnesimoElemento kMax = new KEnesimoElemento();

        // se busca el tercer elemento más grande
        int k = 3;

        System.out.println("Arreglo original:");
        for (Integer dato : datos) {
            System.out.print(dato + " ");
        }

        System.out.println("\n\nK = " + k); //valor esperado 20

        System.out.println("Usando MaxHeap: " + kMax.elementoKMayor(datos, k));


        System.out.println();
        System.out.println("TEST 1er ELEMENTO\n");


        Integer[] datos2 = {12, 4, 6, 1, 89, 3, 6, 3, 17, 20, 5};

        KEnesimoElemento kMax2 = new KEnesimoElemento();

        int k2 = 1;

        System.out.println("Arreglo original:");
        for (Integer dato : datos2) {
            System.out.print(dato + " ");
        }

        System.out.println("\n\nK = " + k2); //valor esperado 89

        System.out.println(
                "Usando MaxHeap: " + kMax2.elementoKMayor(datos2, k2)
        );

        System.out.println();
        System.out.println("TEST K-ESIMO ELEMENTO CON VALORES REPETIDOS\n");

        Integer[] datos3 = {12, 4, 6, 1, 89, 3, 6, 3, 17, 17,20, 5};

        KEnesimoElemento kMax3 = new KEnesimoElemento();

        int k3 = 4;

        System.out.println("Arreglo original:");
        for (Integer dato : datos3) {
            System.out.print(dato + " ");
        }

        System.out.println("\n\nK = " + k3); //valor esperado 17

        System.out.println(
                "Usando MaxHeap: " + kMax3.elementoKMayor(datos3, k3)
        );

    }
}