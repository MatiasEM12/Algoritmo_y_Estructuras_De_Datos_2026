package tp06.ejercicio2;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp06.Arista;
import tp06.Grafo;
import tp06.Vertice;

public class Recorridos<T> {

    public ListaGenerica<T> dfs(Grafo<T> grafo){

        return null;
    }

    public ListaGenerica<T> bfs(Grafo<T> grafo){

        if(grafo==null || grafo.esVacio()){
            return null;
        }

        Vertice<T> v = grafo.vetice(1);
        ListaGenerica<Vertice<T> > cola = new ListaEnlazadaGenerica<Vertice<T> >();
        ListaGenerica<Vertice<T> > visitados = new ListaEnlazadaGenerica<Vertice<T> >();
        ListaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();

        cola.agregarFinal(v);
        visitados.agregarFinal(v);


        while(!cola.esVacia()){
            Vertice<T> u = cola.elemento(1);
            cola.eliminarEn(1);

            resultado.agregarFinal(u.dato());

            ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(u);
            adyacentes.comenzar();
            while(!adyacentes.fin()){

                Arista<T> arista = adyacentes.proximo();
                Vertice<T> w = arista.verticeDestino();


                if (!visitados.incluye(w)) {


                    visitados.agregarFinal(w);
                    cola.agregarFinal(w);
                }
            }


        }

        return  resultado;
    }
}
