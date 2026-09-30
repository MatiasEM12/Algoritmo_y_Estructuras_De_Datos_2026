package tp05.ejercicio8;


import tp05.ColaPrioridades;

public class KEnesimoElemento {


    private ColaPrioridades<Integer> heap;

    public KEnesimoElemento(ColaPrioridades<Integer> heap){
        this.heap=heap;
    }


    public int elementoKMayor( Integer datos[], int posicion) {

        Integer datosAux[] = this.cargarHeap(datos);
        Integer datosUnicos[] = this.eliminarRepetidos(datos,posicion);
        return datosUnicos[posicion];
    }

    private Integer[] eliminarRepetidos( Integer datos[],int posicion) {
        Integer datosUnicos[];

        for(int i =0;i <= posicion ;i++){
            Integer aux = datos[i];
            Integer aux2 = datos[i++];
            if ( ){ //comparable
                //si son diferentes
                datosUnicos[i]=aux;
            }
        }

        return datosUnicos;
    }

    private Integer[] cargarHeap(Integer datos[]){
        for(Integer dato : datos){
            heap.agregar( dato);
        }
        return heap.getDatos();
    }
}
