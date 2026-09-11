package tp03.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp03ab.ArbolBinario;

public class ContadorArbol {

    ArbolBinario<Integer> arbol;

    public ContadorArbol(ArbolBinario<Integer> arbol) {
        this.arbol = arbol;
    }

   public  ListaEnlazadaGenerica<Integer> numerosPares(){
        ListaEnlazadaGenerica<Integer> recorrido = new ListaEnlazadaGenerica<Integer>();
        ListaEnlazadaGenerica<Integer> lista = listaInOrden();
        //ListaEnlazadaGenerica<Integer> lista = listaPostOrden();
       lista.comenzar();
        while (!lista.fin()) {
            Integer numero = lista.proximo();
            if (numero % 2 == 0) {
                recorrido.agregarFinal(numero);
            }
        }
        return recorrido;
   }

   private ListaEnlazadaGenerica<Integer>  listaInOrden() {
       return  arbol.inOrden();
    }

    public ListaEnlazadaGenerica<Integer> listaPostOrden() {
        return arbol.postOrden();
    }
}
