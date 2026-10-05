package tp06.MatrizDeAdyacencia;

import tp01.ejercicio2.ListaGenerica;
import tp06.Arista;
import tp06.Grafo;
import tp06.Vertice;

public class GrafoImplMatrizAdy  implements Grafo {


    @Override
    public void agregarVertice(Vertice v) {

    }

    @Override
    public void eliminarVertice(Vertice v) {

    }

    @Override
    public void conectar(Vertice origen, Vertice destino) {

    }

    @Override
    public void conectar(Vertice origen, Vertice destino, int peso) {

    }

    @Override
    public void desConectar(Vertice origen, Vertice destino) {

    }

    @Override
    public boolean esAdyacente(Vertice origen, Vertice destino) {
        return false;
    }

    @Override
    public int peso(Vertice origen, Vertice destino) {
        return 0;
    }

    @Override
    public boolean esVacio() {
        return false;
    }

    @Override
    public ListaGenerica<Vertice> listaDeVertices() {
        return null;
    }

    @Override
    public ListaGenerica<Arista> listaDeAdyacentes(Vertice v) {
        return null;
    }

    @Override
    public Vertice vetice(int posicion) {
        return null;
    }
}
