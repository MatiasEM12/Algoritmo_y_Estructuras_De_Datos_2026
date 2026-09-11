package tp03abb;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {
	private T dato;
	private ArbolBinarioDeBusqueda<T> hijoIzquierdo;
	private ArbolBinarioDeBusqueda<T> hijoDerecho;

	
	public ArbolBinarioDeBusqueda() {
		super();
	}

	public ArbolBinarioDeBusqueda(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinarioDeBusqueda<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinarioDeBusqueda<T> getHijoDerecho() {
		return this.hijoDerecho;

	}
	
	private void setHijoIzquierdo(ArbolBinarioDeBusqueda<T> hijo) {
		this.hijoIzquierdo = hijo;

	}
	
	
	private void setHijoDerecho(ArbolBinarioDeBusqueda<T> hijo) {
		this.hijoDerecho = hijo;

	}
	
	
	public boolean incluye (Comparable<T> dato){
		return this.buscar(dato, this) != null;
	}
	 
	
	public ArbolBinarioDeBusqueda<T> buscar (Comparable<T> x, ArbolBinarioDeBusqueda<T> arbol){
		if (arbol != null) {
			if (x.compareTo(arbol.getDato()) < 0) {
				arbol = this.buscar(x, arbol.getHijoIzquierdo());
			} else if (x.compareTo(arbol.getDato()) > 0) {
				arbol = this.buscar(x, arbol.getHijoDerecho());
			} else
				; // Se encontro el dato, asi que es arbol
			return arbol;
		} else {
			return null;
		}
	}
	 
	public void agregar (Comparable<T> dato){
		if (this.esVacio()) {
			this.setDato((T) dato);
		} else {
			this.agregar(dato, this);
		}
		
	} 
	
	private void agregar (Comparable<T> dato, ArbolBinarioDeBusqueda<T> arbol){

		if (dato.compareTo(arbol.getDato()) < 0) {
			if (arbol.getHijoIzquierdo() == null) {
				arbol.setHijoIzquierdo(new ArbolBinarioDeBusqueda<T>((T) dato));
			} else {

				this.agregar(dato, arbol.getHijoIzquierdo());
			}
		} else if (dato.compareTo(arbol.getDato()) > 0) {
			if (arbol.getHijoDerecho() == null) {
				arbol.setHijoDerecho(new ArbolBinarioDeBusqueda<T>((T) dato));
			} else {
				this.agregar(dato, arbol.getHijoDerecho());
			}
		} else if(dato.compareTo(arbol.getDato()) == 0) {
			arbol.setDato((T) dato);
		}
	} 
	
	public ArbolBinarioDeBusqueda<T> buscarMayorDeLosMenores (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}
	
	public ArbolBinarioDeBusqueda<T> buscarMayor (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}
	
	public ArbolBinarioDeBusqueda<T> buscarMenorDeLosMayores (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}
	
	public ArbolBinarioDeBusqueda<T> buscarMenor (ArbolBinarioDeBusqueda<T> arbol) {
		// TO DO
		return null;
	}
	
	@Override
	public String toString() {
		return this.getDato().toString();
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	private boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo != null;
	}

	private boolean tieneHijoDerecho() {
		return this.hijoDerecho != null;
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	

}
