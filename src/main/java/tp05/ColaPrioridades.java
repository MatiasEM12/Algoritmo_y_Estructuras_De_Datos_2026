package tp05;

public interface ColaPrioridades <T>{

    public boolean esVacia();

    public void eliminar();

    public boolean agregar(T dato);

    public void tope();

    public T[] getDatos();
}
