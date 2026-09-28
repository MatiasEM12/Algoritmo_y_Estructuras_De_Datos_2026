package tp05.test;

import tp05.MaxHeap;

public class TestMaxHeap {
    public static void main() {

        MaxHeap<Integer> heap = new MaxHeap<>();


        System.out.println(" CREAR HEAP ");

        heap.agregar(10);
        heap.agregar(20);
        heap.agregar(5);
        heap.agregar(30);
        heap.agregar(15);

        System.out.println("Heap después de agregar:");
        heap.imprimir();




        System.out.println();
        System.out.println(" ELIMINAR ");

        heap.eliminar();

        System.out.println("Heap después de eliminar:");
        heap.imprimir();


        System.out.println();
        System.out.println(" ELIMINAR OTRA VEZ ");

        heap.eliminar();

        System.out.println("Heap después de eliminar:");
        heap.imprimir();
    }

}
