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

        if(!existe(v)){
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
        //antes verificar aristas y enlaces
        vertices.eliminar(v);
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

        return null;
    }

    @Override
    public Vertice<T> vetice(int posicion) {

        return vertices.elemento(posicion);
    }
}
