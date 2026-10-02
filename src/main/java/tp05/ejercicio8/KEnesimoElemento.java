package tp05.ejercicio8;


import tp05.ColaPrioridades;
import tp05.MaxHeap;

public class KEnesimoElemento {


    private ColaPrioridades<Integer> heap;

    public KEnesimoElemento(ColaPrioridades<Integer> heap){
        this.heap=heap;
    }


    public int elementoKMayor( Integer datos[], int k) {


        if (datos == null || k < 1 || k > datos.length) {
            throw new IllegalArgumentException("K no es válido");
        }

        Integer[] datosAux = cargarHeap(datos);

        MaxHeap<Integer> max = new MaxHeap<>();

        for (Integer dato : datosAux) {
            if (dato != null) {
                max.agregar(dato);
            }
        }

        for (int i = 1; i < k; i++) {
            max.eliminar();
        }

        Object[] elementos = max.getDatos();
        return (Integer) elementos[0];
    }



    private Integer[] cargarHeap(Integer[] datos) {
        for (Integer dato : datos) {
            if (!heap.agregar(dato)) {
                throw new IllegalArgumentException("No se pudo agregar el elemento al heap");
            }
        }

        Integer[] datosHeap = new Integer[datos.length];
        Object[] elementos = heap.getDatos();

        for (int i = 0; i < datos.length; i++) {
            datosHeap[i] = (Integer) elementos[i];
        }

        return datosHeap;
    }
}
