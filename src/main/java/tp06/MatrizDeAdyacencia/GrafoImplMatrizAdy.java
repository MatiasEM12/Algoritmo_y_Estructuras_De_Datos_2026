package tp06.MatrizDeAdyacencia;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.Arista;
import tp06.Grafo;
import tp06.AristaImpl;

import tp06.Vertice;

public class GrafoImplMatrizAdy<T>  implements Grafo {


    private int maxVertice;
    private int[][] matrizAdy;
    private ListaGenerica<Vertice<T>> vertices;



    public GrafoImplMatrizAdy(int maxVertice) {
        this.maxVertice = maxVertice;
        this.matrizAdy = new int[maxVertice][maxVertice];
        this.vertices = new ListaEnlazadaGenerica<Vertice<T>>();
    }

    private VerticeImplMatrizAdy<T> buscarVertice(Vertice<T> v){
        return null;
    }

    @Override
    public void agregarVertice(Vertice v) {

        if(!existe(v) && vertices.tamanio() < maxVertice){
            VerticeImplMatrizAdy<T> vertice = (VerticeImplMatrizAdy<T>) v;
            vertice.setPosicion(vertices.tamanio());
            vertices.agregarFinal(v);
        }
    }

    //metodo auxiliar
    private boolean existe(Vertice v) {
        if(vertices==null || esVacio() || v==null){
            return false;
        }
        return vertices.incluye(v);
    }
    @Override
    public void eliminarVertice(Vertice v) {

        if(existe(v)){
            actualizarPosicionesMatriz(v.getPosicion());
            vertices.eliminar(v);
            actualizarPosicionesLista();
        }

    }


    //auxiliar para eliminar, cuando elimino un vertice debo actualizar las posiciones de los otros vertices

    private void actualizarPosicionesMatriz(int p){
        //creo una matriz auxiliar para eliminar las aristas del vertice
        int[][] matrizAux = new int[maxVertice][maxVertice];
        for(int i=0;i<vertices.tamanio();i++){
            for(int j=0;j<vertices.tamanio();j++){

                if(i !=p && j !=p){
                    int posI = i;
                    int posJ = j;
                    if(i>p){
                        posI--;
                    }
                    if(j>p){
                        posJ--;
                    }
                    matrizAux[posI][posJ] = matrizAdy[i][j];
                }
            }
        }

        matrizAdy = matrizAux;
    }
    private void actualizarPosicionesLista() {


        this.vertices.comenzar();
        int posicion = 0;
        while (!this.vertices.fin()) {
            VerticeImplMatrizAdy<T> v = (VerticeImplMatrizAdy<T>) this.vertices.proximo();

            v.setPosicion(posicion);
            posicion++;
        }

    }


    @Override
    public void conectar(Vertice origen, Vertice destino) {

        if(existe(origen) && existe(destino)){

            matrizAdy[origen.getPosicion()][destino.getPosicion()]=1;

        }
    }

    @Override
    public void conectar(Vertice origen, Vertice destino, int peso) {

        if(existe(origen) && existe(destino)){

            matrizAdy[origen.getPosicion()][destino.getPosicion()]=peso;

        }
    }

    @Override
    public void desConectar(Vertice origen, Vertice destino) {

        if(existe(origen) && existe(destino)){

            matrizAdy[origen.getPosicion()][destino.getPosicion()]=0;

        }
    }

    @Override
    public boolean esAdyacente(Vertice origen, Vertice destino) {
        if(existe(origen) && existe(destino)){

            int esAdy = matrizAdy[origen.getPosicion()][destino.getPosicion()];
            if(esAdy==0){
                return false;
            }else{
                return true;
            }

        }
        return false;
    }

    @Override
    public int peso(Vertice origen, Vertice destino) {
        if(existe(origen) && existe(destino)){

            return matrizAdy[origen.getPosicion()][destino.getPosicion()];

        }
        return 0;
    }

    @Override
    public boolean esVacio() {
        return vertices.esVacia();
    }

    @Override
    public ListaGenerica<Vertice<T>> listaDeVertices() {
        return this.vertices;
    }

    @Override
    public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice v) {

        ListaGenerica<Arista<T>> adyacentes = new  ListaEnlazadaGenerica<Arista<T>>();

        if(existe(v)){

            for(int i=0; i<vertices.tamanio(); i++){
                if(matrizAdy[v.getPosicion()][i]!=0){
                    Vertice<T> destino = this.vetice(i);
                    Arista<T> arista = new AristaImpl<T>(destino, matrizAdy[v.getPosicion()][i]);
                    adyacentes.agregarFinal(arista);
                }
            }

        }
        return adyacentes;
    }

    @Override
    public Vertice vetice(int posicion) {
        return vertices.elemento(posicion+1);
    }

    @Override
    public Vertice inicio() {
        if(!esVacio()){
            return vertices.elemento(1);
        }
        return null;
    }

    @Override
    public Vertice buscarVertice(Object elem) {

        if(existeVertice(elem)){
            ListaGenerica<Vertice<T>> vertices = this.listaDeVertices();
            vertices.comenzar();
            while(!vertices.fin()){
                Vertice<T> v = vertices.proximo();
                if(v.dato().equals(elem)){
                    return v;
                }
            }
        }
        return null;
    }

    @Override
    public boolean existeVertice(Object elem) {
        ListaGenerica<Vertice<T>> vertices = this.listaDeVertices();

        vertices.comenzar();
        while(!vertices.fin()){
            Vertice<T> v = vertices.proximo();
            if(v.dato().equals(elem)){
                return true;
            }
        }
        return false;
    }
}
