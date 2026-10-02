package tp05;

import tp01.ejercicio2.ListaGenerica;

public class MinHeap <T> implements ColaPrioridades<T> {

    private T[] datos=(T[]) new Comparable[100];
    private int cantEltos;



    public MinHeap() {
        this.cantEltos=0;
    }

    public MinHeap(ListaGenerica<T> lista) {
        if(lista!=null || !lista.esVacia()){
            this.cantEltos=0;
            while (!lista.esVacia()){
                this.agregar(lista.proximo());
            }
        }
    }


    @Override
    public boolean esVacia() {
        return cantEltos==0;
    }



    @Override
    public void eliminar() {
        if (!esVacia()) {
            int ultimo = this.cantEltos - 1;

            if (ultimo == 0) {
                this.datos[0] = null;
                this.cantEltos--;
            }

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

        if (!esVacia()) {
            System.out.println(datos[0]);
        }
    }

    private void percolate_up(){

        if(!esVacia()) {

            int ultimo = this.cantEltos - 1;

            while (ultimo > 0){
                int padre = (ultimo - 1) / 2;

                T datoPadre = this.datos[padre];
                T datoHijo = this.datos[ultimo];

                if(((Comparable)datoHijo).compareTo(datoPadre) < 0){

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

            int hijoMenor;

            if (hijoDerecho < this.cantEltos && ((Comparable)this.datos[hijoDerecho]).compareTo(this.datos[hijoIzquierdo]) < 0) {

                hijoMenor = hijoDerecho;

            } else {

                hijoMenor = hijoIzquierdo;
            }

            if (((Comparable) datos[hijoMenor]).compareTo(datos[posicion]) < 0){

                T aux = this.datos[posicion];
                this.datos[posicion] = this.datos[hijoMenor];
                this.datos[hijoMenor] = aux;

                posicion = hijoMenor;

            } else {
                break;
            }
        }
    }

    public void imprimir() {
        if (!esVacia()) {
            imprimir(0, "");
        }
    }

    private void imprimir(int posicion, String sangria) {

        if (posicion < this.cantEltos) {

            System.out.println(sangria + "└─ " + this.datos[posicion]);

            int hijoIzquierdo = 2 * posicion + 1;
            int hijoDerecho = 2 * posicion + 2;

            imprimir(hijoIzquierdo, sangria + "    ");
            imprimir(hijoDerecho, sangria + "    ");
        }
    }

    @Override
    public T[] getDatos(){
        T[] copia = (T[]) new Comparable[this.cantEltos];
        for (int i = 0; i < this.cantEltos; i++) {
            copia[i] = this.datos[i];
        }
        return copia;
    }
}
