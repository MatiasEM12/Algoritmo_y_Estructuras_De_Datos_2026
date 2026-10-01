package tp05.ejercicio8;


import tp05.ColaPrioridades;

public class KEnesimoElemento {


    private ColaPrioridades<Integer> heap;

    public KEnesimoElemento(ColaPrioridades<Integer> heap){
        this.heap=heap;
    }


    public int elementoKMayor( Integer datos[], int posicion) {

        Integer datosAux[] = this.cargarHeap(datos);
        datosAux= filtrado(datosAux,posicion);
        return datosAux[posicion];
    }

    private Integer[] filtrado(Integer[] datos, int posicion) {
        Integer datosAux[]=null;

        if(datos[0] > datos[posicion-1]){
            //si la raiz es más grande que el elemento en una posicion K
            //entonces se esta trabajando con una maxHeap por lo que se filtran
            //los primeros N elementos
            for(int i=0;i<posicion;i++) {
                datosAux[i] = datos[i];
            }

            return datosAux;
        }

        //si la raiz es más pequeña que el elemento en una posicion K
        //entonces se esta trabajando con una minHeap por lo que se filtran
        //los ultimos N elementos en orden inverso.
        for(int i=posicion;i>=0;i--){
            datosAux[i] = datos[i];
        }

        return datosAux;
    }


    private Integer[] cargarHeap(Integer datos[]){
        for(Integer dato : datos){
            heap.agregar( dato);
        }
        return heap.getDatos();
    }
}
