package tp06.ListaDeAdyaciencia;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.Arista;
import tp06.Vertice;

public class VerticeImplListAdy<T> implements Vertice {

    private ListaGenerica<Arista<T>> adyacentes;
    private T dato;
    private int posicion;

    public VerticeImplListAdy(T dato){
        this.dato = dato;
        this.adyacentes = new ListaEnlazadaGenerica<Arista<T>>();
    }
    @Override
    public Object dato() {
        return dato;
    }

    @Override
    public void setDato(Object dato) {
        this.dato= (T) dato;
    }

    @Override
    public int getPosicion() {
        return posicion;
    }

    public void conectar(Vertice<T> v){

        Arista<T> arista = new AristaImpl<T>(v, 1);
        this.adyacentes.agregarFinal(arista);

    }

    public void conectar(Vertice<T> v, int peso){

        Arista<T> arista = new AristaImpl<T>(v, peso);
        this.adyacentes.agregarFinal(arista);
    }

    public void desconectar(Vertice<T> v){

        //metodo auxiliar para buscar la arista
        Arista<T> arista = this.obtenerArista(v);
        if(arista!=null){
            this.adyacentes.eliminar(arista);
        }
    }

    public ListaGenerica<Arista<T>> obtenerAdyacentes(){
        return this.adyacentes;
    }


    public boolean esAdyacente(Vertice<T> v){
        return false;
    }

    public int peso (Vertice<T> v){

        Arista<T> arista = this.obtenerArista(v);
        if(arista!=null){
            arista.peso();
        }
        return 0;
    }

    public Arista<T> obtenerArista(Vertice<T> v){

        ListaGenerica<Arista<T>> adyacentes = this.obtenerAdyacentes();
        adyacentes.comenzar();
        while(!adyacentes.fin()){
            Arista<T> arista = adyacentes.proximo();
            if(arista.verticeDestino().equals(v)){
                return arista;
            }
        }
        return null;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
