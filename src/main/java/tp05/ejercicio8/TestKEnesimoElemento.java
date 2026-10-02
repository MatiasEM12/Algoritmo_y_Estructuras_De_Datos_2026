package tp05.ejercicio8;

import tp05.ColaPrioridades;
import tp05.MaxHeap;
import tp05.MinHeap;

public class TestKEnesimoElemento {

    public static void main(String[] args) {

        // Crear el arreglo desordenado
        Integer[] datos = {12, 4, 6, 1, 89, 89, 3, 6, 3, 17, 20, 5};

        // Crear los heaps
        ColaPrioridades<Integer> heapMax = new MaxHeap<>();
        ColaPrioridades<Integer> heapMin = new MinHeap<>();

        // Crear los objetos que buscan el K-ésimo mayor
        KEnesimoElemento kMax = new KEnesimoElemento(heapMax);
        KEnesimoElemento kMin = new KEnesimoElemento(heapMin);

        // Buscar el tercer elemento más grande
        int k = 3;

        System.out.println("Arreglo original:");
        for (Integer dato : datos) {
            System.out.print(dato + " ");
        }

        System.out.println("\n\nK = " + k);

        System.out.println(
                "Usando MaxHeap: " + kMax.elementoKMayor(datos, k)
        );

        System.out.println(
                "Usando MinHeap: " + kMin.elementoKMayor(datos, k)
        );
    }
}