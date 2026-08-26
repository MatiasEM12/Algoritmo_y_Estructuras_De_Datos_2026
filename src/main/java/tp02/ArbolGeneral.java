package tp02;


import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;

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
			return null;
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

	public ListaEnlazadaGenerica<T> InOrden() {
		Procedimiento Inorden(nodo)
				Si nodo no es NULO entonces
		Si nodo tiene hijos entonces
		// Recorrer el primer hijo (el más izquierdo)
		Inorden(primerHijo(nodo))

		// Visitar la raíz del nodo actual
		Visitar(nodo.valor)

		// Recorrer los hijos restantes de izquierda a derecha
		Para cada hijo en losHijosRestantes(nodo) hacer
		Inorden(hijo)
		Fin Para
		Sino
		// Si es un nodo hoja (sin hijos)
		Visitar(nodo.valor)
		Fin Si
		Fin Si
		Fin Procedimiento
		return null;
	}
	public Integer altura() {
		// Falta implementar..
		return 0;
	}

	public Integer nivel(T dato) {
		// falta implementar
		return -1;
	}

	public Integer ancho() {
		// Falta implementar..
		return 0;
	}

}