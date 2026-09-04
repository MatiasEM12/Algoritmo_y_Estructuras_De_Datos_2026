package tp02;


import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {

		if (this.esVacio()) {
			return new ListaEnlazadaGenerica<T>();
		}


		ListaEnlazadaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();
		resultado.agregarFinal(this.getDato());

		if (this.tieneHijos()) {

			ListaEnlazadaGenerica<ArbolGeneral<T>> hijos = (ListaEnlazadaGenerica<ArbolGeneral<T>>) this.getHijos();
			hijos.comenzar();
			while(!hijos.fin()){
				ArbolGeneral<T> hijo = hijos.proximo();
				ListaEnlazadaGenerica<T> listaHijo = hijo.preOrden();

				listaHijo.comenzar();
				while (!listaHijo.fin()) {
					resultado.agregarFinal(listaHijo.proximo());
				}
			}


		}

		return resultado;
	}

	public ListaEnlazadaGenerica<T> postOrden() {

		if (this.esVacio()) {
			return new ListaEnlazadaGenerica<T>();
		}


		ListaEnlazadaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();


		if (this.tieneHijos()) {

			ListaEnlazadaGenerica<ArbolGeneral<T>> hijos = (ListaEnlazadaGenerica<ArbolGeneral<T>>) this.getHijos();
			hijos.comenzar();
			while(!hijos.fin()){
				ArbolGeneral<T> hijo = hijos.proximo();
				ListaEnlazadaGenerica<T> listaHijo = hijo.postOrden();

				listaHijo.comenzar();
				while (!listaHijo.fin()) {
					resultado.agregarFinal(listaHijo.proximo());
				}
			}

		}
		resultado.agregarFinal(this.getDato());
		return resultado;
	}

	public ListaEnlazadaGenerica<T> inOrden() {

		if (this.esVacio()) {
			return new ListaEnlazadaGenerica<T>();
		}

		ListaEnlazadaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();

		if (this.tieneHijos()) {

			ListaEnlazadaGenerica<ArbolGeneral<T>> hijos = (ListaEnlazadaGenerica<ArbolGeneral<T>>) this.getHijos();

			hijos.comenzar();

			// Primer hijo
			ArbolGeneral<T> primerHijo = hijos.proximo();

			ListaEnlazadaGenerica<T> listaHijo = primerHijo.inOrden();
			listaHijo.comenzar();

			while (!listaHijo.fin()) {
				resultado.agregarFinal(listaHijo.proximo());
			}

			// Nodo actual
			resultado.agregarFinal(this.getDato());

			// Resto de los hijos
			while (!hijos.fin()) {

				ArbolGeneral<T> hijo = hijos.proximo();

				listaHijo = hijo.inOrden();

				listaHijo.comenzar();

				while (!listaHijo.fin()) {
					resultado.agregarFinal(listaHijo.proximo());
				}
			}

		} else {
			// Si es hoja
			resultado.agregarFinal(this.getDato());
		}

		return resultado;
	}

	public ListaEnlazadaGenerica<T> porNivel() {

		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		ListaEnlazadaGenerica<T> resultado = new ListaEnlazadaGenerica<T>();

		cola.encolar(this);
		while(!cola.esVacia()){
			ArbolGeneral<T> nodo = cola.desencolar();
			resultado.agregarFinal(nodo.getDato());
			if(nodo.tieneHijos()){
				ListaEnlazadaGenerica<ArbolGeneral<T>> hijos = (ListaEnlazadaGenerica<ArbolGeneral<T>>) nodo.getHijos();
				hijos.comenzar();
				while(!hijos.fin()){
					cola.encolar(hijos.proximo());
				}
			}
		}



		return resultado;
	}



	//EJERCICIO 6
	public Integer altura() {

		if (this.esVacio() || this.esHoja()) {
			return 0;
		}

		Integer mayor = 0;
		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
		hijos.comenzar();

		while (!hijos.fin()) {

			ArbolGeneral<T> hijo = hijos.proximo();
			Integer alturaHijo = hijo.altura();
			if (alturaHijo > mayor) {
				mayor = alturaHijo;
			}
		}

		return mayor + 1;
	}
	public Integer nivel(T dato) {

		if (this.esVacio()) {
			return -1;
		}

		if (this.getDato().equals(dato)) {
			return 0;
		}

		ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();

		hijos.comenzar();

		while (!hijos.fin()) {

			ArbolGeneral<T> hijo = hijos.proximo();

			Integer nivelHijo = hijo.nivel(dato);

			if (nivelHijo != -1) {
				return nivelHijo + 1;
			}
		}

		return -1;
	}
	public Integer ancho() {

		if (this.esVacio()) {
			return 0;
		}

		ListaEnlazadaGenerica<ArbolGeneral<T>> cola = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

		cola.agregarFinal(this);

		Integer mayor = 0;

		while (!cola.esVacia()) {

			Integer cantidadNivel = cola.tamanio();

			if (cantidadNivel > mayor) {
				mayor = cantidadNivel;
			}

			for (int i = 0; i < cantidadNivel; i++) {

				ArbolGeneral<T> nodo = cola.elemento(0);
				cola.eliminar(nodo);

				ListaGenerica<ArbolGeneral<T>> hijos = nodo.getHijos();


				hijos.comenzar();

				while (!hijos.fin()) {
					cola.agregarFinal(hijos.proximo());
				}
			}
		}

		return mayor;
	}

	public Boolean esAncestro(T a, T b) {

		if( a ==null || b==null){
			return false;
		}

		var hijos = this.getHijos();

		while (!hijos.fin()) {
			var hijo = hijos.proximo();

			if (hijo.getDato().equals(a)) {

				return hijo.buscarDescendiente(hijo, b);
			}
			if (hijo.esAncestro(a, b)) {
				return true;
			}

		}

		return false;
	}




	private Boolean buscarDescendiente(ArbolGeneral<T> padre, T b){
		var hijos = padre.getHijos();

		while (!hijos.fin()) {

			var hijo = hijos.proximo();

			if (hijo.getDato().equals(b)) {
				return true;
			}

			if (hijo.buscarDescendiente(hijo, b)) {
				return true;
			}
		}
		return false;
	}
	public Boolean esArbolLleno(){

		if(!this.esHoja()){

			var hijos = this.getHijos();
			var tamanio = hijos.tamanio();

			while (!hijos.fin()){
				var hijo = hijos.proximo();

				if(hijo.tieneHijos() && hijo.getHijos().tamanio() != tamanio){
					return false;
				}

				if (!hijo.esArbolLleno()) {
					return false;
				}
			}

		}
		return true;
	}
	public Boolean esArbolCompleto() {

		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();

		cola.encolar(this);

		boolean encontreHoja = false;

		while (!cola.esVacia()) {

			ArbolGeneral<T> nodo = cola.desencolar();

			if (encontreHoja && nodo.tieneHijos()) {
				return false;
			}

			if (nodo.esHoja()) {
				encontreHoja = true;
			} else {
				var hijos = nodo.getHijos();

				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}	
			}
		}

		return true;
	}
}