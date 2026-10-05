package tp06.ListaDeAdyaciencia;

import tp06.Arista;
import tp06.Vertice;

public class AristaImpl<T> implements Arista {

    private Vertice<T> destino;
    private int peso;

    public AristaImpl(Vertice<T> destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
    @Override
    public Vertice verticeDestino() {
        return destino;
    }

    @Override
    public int peso() {
        return peso;
    }
}
