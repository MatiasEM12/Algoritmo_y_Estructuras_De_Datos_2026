package tp02.ejercicio3;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp02.ArbolGeneral;



public class RecorridosAG {


    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral <Integer> a, Integer n){

        ListaEnlazadaGenerica<Integer> listaPreOrden = a.preOrden();
        ListaEnlazadaGenerica<Integer> listaResultado = new ListaEnlazadaGenerica<>();

        listaPreOrden.comenzar();
        while(!listaPreOrden.fin()){
            Integer numero = listaPreOrden.proximo();
            if(numero % 2 != 0 && numero > n){
                listaResultado.agregarFinal(numero);
            }
        }

        return listaResultado;
    }

    public ListaGenerica< Integer > numerosImparesMayoresQueInOrden(ArbolGeneral <Integer> a, Integer n){

        ListaEnlazadaGenerica<Integer> listaInOrden = a.inOrden();
        ListaEnlazadaGenerica<Integer> listaResultado = new ListaEnlazadaGenerica<>();

        listaInOrden.comenzar();
        while(!listaInOrden.fin()){
            Integer numero = listaInOrden.proximo();
            if(numero % 2 != 0 && numero > n){
                listaResultado.agregarFinal(numero);
            }
        }

        return listaResultado;
    }

    public ListaGenerica< Integer > numerosImparesMayoresQuePostOrden(ArbolGeneral <Integer> a, Integer n){
        ListaEnlazadaGenerica<Integer> listaPostOrden = a.postOrden();
        ListaEnlazadaGenerica<Integer> listaResultado = new ListaEnlazadaGenerica<>();

        listaPostOrden.comenzar();
        while(!listaPostOrden.fin()){
            Integer numero = listaPostOrden.proximo();
            if(numero % 2 != 0 && numero > n){
                listaResultado.agregarFinal(numero);
            }
        }

        return listaResultado;
    }

    public ListaGenerica< Integer > numerosImparesMayoresQuePorNiveles(ArbolGeneral <Integer> a, Integer n){
        ListaEnlazadaGenerica<Integer> listaPorNivel = a.porNivel();
        ListaEnlazadaGenerica<Integer> listaResultado = new ListaEnlazadaGenerica<>();

        listaPorNivel.comenzar();
        while(!listaPorNivel.fin()){

            Integer numero = listaPorNivel.proximo();
            if(numero % 2 != 0 && numero > n){
                listaResultado.agregarFinal(numero);
            }
        }

        return listaResultado;
    }

}
