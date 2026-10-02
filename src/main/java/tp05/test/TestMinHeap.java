package tp05.test;
import tp05.MinHeap;

public class TestMinHeap {

    public static void main() {


        MinHeap<Integer> heap = new MinHeap<>();


        System.out.println(" CREAR HEAP ");

        heap.agregar(10);
        heap.agregar(20);
        heap.agregar(15);
        heap.agregar(15);
        heap.agregar(30);
        heap.agregar(40);

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
