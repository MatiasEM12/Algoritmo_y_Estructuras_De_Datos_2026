package tp03ab;

import tp01.ejercicio2.ListaEnlazadaGenerica;



public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
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
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	//ejercicio 2 -a)
	public int contarHojas() {

		if(esHoja()){
			return 1;
		}


		if(tieneHijoIzquierdo() || tieneHijoDerecho()){

			if(tieneHijoIzquierdo() && tieneHijoDerecho()){
				return getHijoIzquierdo().contarHojas() + getHijoDerecho().contarHojas();
			}
			else if(tieneHijoIzquierdo()){
				return getHijoIzquierdo().contarHojas();
			}
			else{
				return getHijoDerecho().contarHojas();
			}
		}
		return 0;
	}

	//ejercicio 2-b)
    public ArbolBinario<T> espejo() {

		ArbolBinario<T> espejo = new ArbolBinario<T>(this.getDato());

		if(!esHoja()){
			ArbolBinario<T> hijoIzquierdoEspejo = null;
			ArbolBinario<T> hijoDerechoEspejo =null;


			//swap
			if(tieneHijoIzquierdo()) {
				 hijoDerechoEspejo = getHijoIzquierdo();
			}

			if(tieneHijoDerecho()) {
				hijoIzquierdoEspejo = getHijoDerecho();
			}


			if(hijoIzquierdoEspejo!=null){
				espejo.agregarHijoIzquierdo(hijoIzquierdoEspejo.espejo());
			}
			if(hijoDerechoEspejo!=null){

				espejo.agregarHijoDerecho(hijoDerechoEspejo.espejo());
			}
		}

		return espejo;
	}

//2 -c)
	public void entreNiveles(int n, int m){
		if(n>m || n<0 || m<0){
			return;
		}
		entreNiveles(n, m, 0);
	}
     //metodo axiliar que me permite hacer la recursion con el nivelActual
	private  void entreNiveles(int n, int m, int nivelActual){
		if(nivelActual>=n && nivelActual<=m  ){

			for (int i = 0; i < nivelActual; i++) {
				System.out.print("    ");
			}
			System.out.println("└─ " + this.getDato());

			if(tieneHijoIzquierdo()){
				var hijoIzquierdo = getHijoIzquierdo();
				hijoIzquierdo.entreNiveles(n, m, nivelActual+1);
			}
			if(tieneHijoDerecho()){
				var hijoDerecho= getHijoDerecho();
				hijoDerecho.entreNiveles(n, m, nivelActual+1);
			}
		}
	}

	//metodos para el ejercicio 3 a y b

	public ListaEnlazadaGenerica<T> inOrden() {

        ListaEnlazadaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();

        if (!this.esVacio()) {

            // recorrer hijo izquierdo
            if (this.tieneHijoIzquierdo()) {

                ListaEnlazadaGenerica<T> listaIzquierda = this.getHijoIzquierdo().inOrden();

                listaIzquierda.comenzar();

                while (!listaIzquierda.fin()) {
                    resultado.agregarFinal(listaIzquierda.proximo());
                }
            }

            // nodo actual
            resultado.agregarFinal(this.getDato());

            // recorrer hijo derecho
            if (this.tieneHijoDerecho()) {

                ListaEnlazadaGenerica<T> listaDerecha = this.getHijoDerecho().inOrden();

                listaDerecha.comenzar();

                while (!listaDerecha.fin()) {
                    resultado.agregarFinal(listaDerecha.proximo());
                }
            }
        }

        return resultado;
	}


	public ListaEnlazadaGenerica<T> postOrden() {

		ListaEnlazadaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();
		var hijos = new ListaEnlazadaGenerica<ArbolBinario<T>>();

		if (tieneHijoIzquierdo()) {
			hijos.agregarFinal(getHijoIzquierdo());
		}

		if (tieneHijoDerecho()) {
			hijos.agregarFinal(getHijoDerecho());
		}

		hijos.comenzar();


		while (!hijos.fin()) {
			var hijo = hijos.proximo();
			ListaEnlazadaGenerica<T> listaHijo = hijo.postOrden();

			listaHijo.comenzar();
			while (!listaHijo.fin()) {
				resultado.agregarFinal(listaHijo.proximo());
			}
		}

		resultado.agregarFinal(this.getDato());
		return resultado;


	}

	//euxiliar para el ejercicio 4
	public boolean estaLleno() {
		boolean resultado = true;

		if (!this.esVacio()) {

			// Si tiene un solo hijo, no está lleno
			if (tieneHijoIzquierdo() != tieneHijoDerecho()) {
				resultado = false;
			} else {

				// Si tiene ambos hijos, se verifica recursivamente
				if (tieneHijoIzquierdo() && tieneHijoDerecho()) {
					resultado = getHijoIzquierdo().estaLleno()
							&& getHijoDerecho().estaLleno();
				}
			}
		}

		return resultado;
	}
}
