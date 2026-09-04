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

			var hijos = this.getHijos();

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

			var hijos = this.getHijos();
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

			var hijos = this.getHijos();

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
				var hijos = this.getHijos();
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
		var hijos = this.getHijos();
		hijos.comenzar();

		while (!hijos.fin()) {

			ArbolGeneral<T> hijo = hijos.proximo();

			Integer alturaHijo = hijo.altura(); //la altura de cada hijo

			//actualiza con quien tenga la mayor altura
			if (alturaHijo > mayor) {
				mayor = alturaHijo;
			}
		}
		//se suma 1 por cada nivel nuevo
		return mayor + 1;
	}

	public Integer nivel(T dato) {

		if (this.esVacio()) {
			return -1;
		}

		// Si encontramos el dato en este nodo, su nivel es 0
		// respecto del subarbol que estamos analizando.
		if (this.getDato().equals(dato)) {
			return 0;
		}

		var hijos = this.getHijos();

		hijos.comenzar();

		while (!hijos.fin()) {

			ArbolGeneral<T> hijo = hijos.proximo();

			// se busca recursivamente el dato en cada hijo.
			Integer nivelHijo = hijo.nivel(dato);


			// Si se encontró, se suma 1 porque se esta
			// un nivel por encima del hijo.
			if (nivelHijo != -1) {
				return nivelHijo + 1;
			}
		}
		// El dato no está en el subárbol.
		return -1;
	}
	public Integer ancho() {

		if (this.esVacio()) {
			return 0;
		}

		ListaEnlazadaGenerica<ArbolGeneral<T>> cola = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

		// la raíz en la cola.
		cola.agregarFinal(this);

		Integer mayor = 0;

		while (!cola.esVacia()) {
            //la cola contiene la cantidad de nodos que hay en el nivel actual
			Integer cantidadNivel = cola.tamanio();

			if (cantidadNivel > mayor) {
				mayor = cantidadNivel;
			}
            //se procesan todos los nodos del nivel actual
			for (int i = 0; i < cantidadNivel; i++) {

				ArbolGeneral<T> nodo = cola.elemento(1);
				cola.eliminar(nodo);

				ListaGenerica<ArbolGeneral<T>> hijos = nodo.getHijos();


				hijos.comenzar();
				// Agregamos los hijos a la cola para procesarlos en el siguiente nivel.
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

		// Si el nodo actual es "a", buscamos "b" dentro de todos sus descendientes.
		if (this.getDato().equals(a)) {
			return buscarDescendiente(this, b);
		}

		var hijos = this.getHijos();
		hijos.comenzar();
		while (!hijos.fin()) {
			var hijo = hijos.proximo();
			// Seguimos buscando "a" recursivamente.
			if (hijo.esAncestro(a, b)) {
				return true;
			}

		}

		return false;
	}


	private Boolean buscarDescendiente(ArbolGeneral<T> padre, T b){
		var hijos = padre.getHijos();

		hijos.comenzar();
		while (!hijos.fin()) {

			var hijo = hijos.proximo();


			// Si encontramos "b", significa que es descendiente.
			if (hijo.getDato().equals(b)) {
				return true;
			}

			// Si no seguimos buscando más abajo en el árbol.
			if (hijo.buscarDescendiente(hijo, b)) {
				return true;
			}
		}
		return false;
	}

	public Boolean esArbolLleno(){

		// Una hoja no tiene hijos, por lo que cumple la condición.
		if(!this.esHoja()){

			var hijos = this.getHijos();
			// Cantidad de hijos que tiene el nodo actual.
			var tamanio = hijos.tamanio();

			hijos.comenzar();
			while (!hijos.fin()){
				var hijo = hijos.proximo();

				// Si el hijo también tiene hijos, verificamos que tenga la misma cantidad que el nodo actual
				if(hijo.tieneHijos() && hijo.getHijos().tamanio() != tamanio){
					return false;
				}

				//se verifica el subArbol
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

			// Si ya encontramos una hoja anteriormente y ahora encontramos un nodo con hijos, el árbol no es completo.
			if (encontreHoja && nodo.tieneHijos()) {
				return false;
			}

			// Cuando encontramos la primera hoja
			if (nodo.esHoja()) {
				encontreHoja = true;
			} else {
				var hijos = nodo.getHijos();

				hijos.comenzar();

				// Los hijos se agregan a la cola para continuar el recorrido por niveles.
				while (!hijos.fin()) {
					cola.encolar(hijos.proximo());
				}
			}
		}

		return true;
	}
}