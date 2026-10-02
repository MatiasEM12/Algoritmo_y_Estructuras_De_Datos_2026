package tp05.ejercicio8;


import tp05.ColaPrioridades;
import tp05.MaxHeap;


public class KEnesimoElemento {


    private ColaPrioridades<Integer> heap;

    public KEnesimoElemento(){

        //en este ejercicio veo que es mas facil usar un maxHeap para eliminar los elementos hasta llegar al k-esimo
        //ya que el maxHeap me permite eliminar el elemento mas grande en O(log n) y asi ir eliminando hasta llegar al k-esimo
        this.heap= new MaxHeap<>();
    }


    public int elementoKMayor( Integer datos[], int k) {


        if (datos == null || k < 1 || k > datos.length) {
            throw new IllegalArgumentException("K no es válido");
        }

        //cargo los datos en un maxHeap
        cargarHeap(datos);

        //elimino la raiz hasta llegar a la posicion K
        for (int i = 1; i < k; i++) {
            heap.eliminar();
        }

        Object[] elementos = heap.getDatos();
        return (Integer) elementos[0];
    }



    private void cargarHeap(Integer[] datos) {
        for (Integer dato : datos) {
            if (!heap.agregar(dato)) {
                throw new IllegalArgumentException("No se pudo agregar el elemento al heap");
            }
        }

    }
}
