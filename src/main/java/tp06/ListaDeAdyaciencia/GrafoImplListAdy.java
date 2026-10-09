package tp06.ListaDeAdyaciencia;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.Arista;
import tp06.Grafo;
import tp06.Vertice;

public class GrafoImplListAdy<T> implements Grafo {

    private ListaGenerica<Vertice<T>> vertices;


    public GrafoImplListAdy(){
        this.vertices = new ListaEnlazadaGenerica<Vertice<T>>();
    }


    @Override
    public void agregarVertice(Vertice v) {

        if (!existe(v)) {
            VerticeImplListAdy<T> vertice = (VerticeImplListAdy<T>) v;

            vertice.setPosicion(this.vertices.tamanio()+1);

            this.vertices.agregarFinal(v);
        }
    }
    //metodo auxiliar
    private boolean existe (Vertice v){

        if(vertices==null || esVacio() || v==null){
            return false;
        }
        return vertices.incluye(v);
    }

    @Override
    public void eliminarVertice(Vertice v) {



        //de V eliminar todas las aristas
        ListaGenerica<Arista<T>> adyacentes = this.listaDeAdyacentes(v);

        adyacentes.comenzar();
        while(!adyacentes.fin()){
            VerticeImplListAdy<T> vOrigen = (VerticeImplListAdy<T>) this.vetice(v.getPosicion());
            vOrigen.desconectar(adyacentes.proximo().verticeDestino());
        }


        //luego de mis vertises eliminar aristas a v
        this.vertices.comenzar();
        while (!this.vertices.fin()){
            VerticeImplListAdy<T> vOrigen = (VerticeImplListAdy<T>) this.vetice(this.vertices.proximo().getPosicion());
            if(vOrigen.esAdyacente(v)){
                vOrigen.desconectar(v);
            }
        }

        vertices.eliminar(v);
        actualizarPosiciones();
    }

    //auxiliar para eliminar, cuando elimino un vertice debo actualizar las posiciones de los otros vertices

    private void actualizarPosiciones() {
        this.vertices.comenzar();
        int posicion = 1;
        while (!this.vertices.fin()) {
            VerticeImplListAdy<T> v = (VerticeImplListAdy<T>) this.vertices.proximo();

            v.setPosicion(posicion);
            posicion++;
        }
    }

    @Override
    public void conectar(Vertice origen, Vertice destino) {

        if( this.existe(origen) && this.existe(destino)){

            VerticeImplListAdy<T> vOrigen = (VerticeImplListAdy<T>) this.vetice(origen.getPosicion());
            vOrigen.conectar(destino);

        }
    }

    @Override
    public void conectar(Vertice origen, Vertice destino, int peso) {

        if( this.existe(origen) && this.existe(destino)){

            VerticeImplListAdy<T> vOrigen = (VerticeImplListAdy<T>) this.vetice(origen.getPosicion());
            vOrigen.conectar(destino,peso);

        }
    }

    @Override
    public void desConectar(Vertice origen, Vertice destino) {


        if( this.existe(origen) && this.existe(destino)){
            VerticeImplListAdy<T> vOrigen = (VerticeImplListAdy<T>) this.vetice(origen.getPosicion());
            if(vOrigen.esAdyacente(destino)){
                vOrigen.desconectar(destino);
            }
        }
    }

    @Override
    public boolean esAdyacente(Vertice origen, Vertice destino) {

        if( this.existe(origen) && this.existe(destino)){
            VerticeImplListAdy<T> vOrigen = (VerticeImplListAdy<T>) this.vetice(origen.getPosicion());
            return vOrigen.esAdyacente(destino);
        }

        return false;
    }

    @Override
    public int peso(Vertice origen, Vertice destino) {


        if( this.existe(origen) && this.existe(destino)){
            VerticeImplListAdy<T> vOrigen = (VerticeImplListAdy<T>) this.vetice(origen.getPosicion());
            return vOrigen.peso(destino);
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

        if( this.existe(v) ){
            VerticeImplListAdy<T> vOrigen = (VerticeImplListAdy<T>) this.vetice(v.getPosicion());
            return vOrigen.obtenerAdyacentes();
        }

        return new ListaEnlazadaGenerica<Arista<T>>();
    }

    @Override
    public Vertice<T> vetice(int posicion) {

        return vertices.elemento(posicion);
    }
}
