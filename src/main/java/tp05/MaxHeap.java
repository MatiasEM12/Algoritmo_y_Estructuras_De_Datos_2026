package tp05;

import tp01.ejercicio2.ListaGenerica;

public class MaxHeap <T> implements ColaPrioridades<T> {


    private T[] datos=(T[]) new Comparable[100];
    private int cantEltos;



    public MaxHeap() {
        this.cantEltos=0;
    }

    public MaxHeap(ListaGenerica<T> lista) {
        this.cantEltos=0;
        while (!lista.esVacia()){
            this.agregar(lista.proximo());
        }
    }


    @Override
    public boolean esVacia() {
        return cantEltos==0;
    }



    @Override
    public void eliminar() {

        if(!esVacia()){

            int ultimo = this.cantEltos - 1;

            this.datos[0] = this.datos[ultimo];

            this.datos[ultimo] = null;

            this.cantEltos--;

            percolate_down();
        }

    }

    @Override
    public boolean agregar(T dato) {

        if (dato==null) return false;

        if (this.cantEltos < this.datos.length) {

            this.datos[this.cantEltos] = dato;
            this.cantEltos++;
            percolate_up();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void tope() {

        System.out.println(datos[0].toString());
    }

    private void percolate_up(){

        if(!esVacia()) {

            int ultimo = this.cantEltos - 1;

            while (ultimo > 0){
                int padre = (ultimo - 1) / 2;

                T datoPadre = this.datos[padre];
                T datoHijo = this.datos[ultimo];

                if(((Comparable)datoHijo).compareTo(datoPadre) > 0){

                    this.datos[padre] = datoHijo;
                    this.datos[ultimo] = datoPadre;
                    ultimo = padre;
                }else{
                    break;
                }
            }

        }
    }

    private void percolate_down() {

        int posicion = 0;

        while (2 * posicion + 1 < this.cantEltos) {

            int hijoIzquierdo = 2 * posicion + 1;
            int hijoDerecho = 2 * posicion + 2;

            int hijoMayor;

            if (hijoDerecho < this.cantEltos && ((Comparable)this.datos[hijoDerecho]).compareTo(this.datos[hijoIzquierdo]) > 0) {

                hijoMayor = hijoDerecho;

            } else {

                hijoMayor = hijoIzquierdo;
            }

            if (((Comparable)this.datos[hijoMayor]).compareTo(this.datos[posicion]) > 0) {

                T aux = this.datos[posicion];
                this.datos[posicion] = this.datos[hijoMayor];
                this.datos[hijoMayor] = aux;

                posicion = hijoMayor;

            } else {
                break;
            }
        }
    }

    public void imprimir() {

        if (!esVacia()) {

            for (int i = 0; i < this.cantEltos; i++) {

                int nivel = (int) (Math.log(i + 1) / Math.log(2));

                String sangria = "";

                for (int j = 0; j < nivel; j++) {
                    sangria += "    ";
                }

                System.out.println(sangria + "└─ " + this.datos[i]);
            }
        }
    }



    public T[] getDatos(){
        return datos;
    }

}
