package tp06.ejercicio2;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

import tp06.Arista;
import tp06.Grafo;
import tp06.Vertice;

public class Recorridos<T> {

    public ListaGenerica<T> dfs(Grafo<T> grafo){
        ListaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();
        if (grafo == null || grafo.listaDeVertices().esVacia()) {
            return resultado;
        }
        boolean []marca = new boolean[grafo.listaDeVertices().tamanio()+1];

        ListaGenerica<Vertice<T>> vertices = grafo.listaDeVertices();
        vertices.comenzar();
        while(!vertices.fin()) {

            Vertice<T> v = vertices.proximo();

            if (!marca[v.getPosicion()]) {
                dfs(grafo, v, marca, resultado);
            }
        }

        return resultado;
    }

    private void dfs(Grafo<T> grafo, Vertice<T> v, boolean[] marca,  ListaGenerica<T> resultado ) {

        marca[v.getPosicion()]=true;
        ListaGenerica<Arista<T>>adyacentes =grafo.listaDeAdyacentes(v);

        resultado.agregarFinal(v.dato());
        adyacentes.comenzar();
        while(!adyacentes.fin()){
            Arista<T> arista = adyacentes.proximo();
            Vertice<T> w = arista.verticeDestino();

            if(!marca[w.getPosicion()]){
                dfs(grafo, w, marca, resultado);
            }
        }

    }

    public ListaGenerica<T> bfs(Grafo<T> grafo){

        if(grafo==null || grafo.esVacio()){
            return null;
        }

        Vertice<T> v = grafo.inicio();
        ListaGenerica<Vertice<T> > cola = new ListaEnlazadaGenerica<Vertice<T> >();
        boolean []marca = new boolean[grafo.listaDeVertices().tamanio()+1];
        ListaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();

        cola.agregarFinal(v);
        marca[v.getPosicion()]=true;


        while(!cola.esVacia()){
            Vertice<T> u = cola.elemento(1);
            cola.eliminarEn(1);

            resultado.agregarFinal(u.dato());

            ListaGenerica<Arista<T>> adyacentes = grafo.listaDeAdyacentes(u);
            adyacentes.comenzar();
            while(!adyacentes.fin()){

                Arista<T> arista = adyacentes.proximo();
                Vertice<T> w = arista.verticeDestino();


                if (!marca[w.getPosicion()]) {

                    marca[w.getPosicion()]=true;
                    cola.agregarFinal(w);
                }
            }


        }

        return  resultado;
    }
}
