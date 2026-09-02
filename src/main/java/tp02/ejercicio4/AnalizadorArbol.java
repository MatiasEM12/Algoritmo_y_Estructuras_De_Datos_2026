package tp02.ejercicio4;
import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp01.ejercicio3.ColaGenerica;
import tp01.ejercicio3.PilaGenerica;
import tp02.ArbolGeneral;

public class AnalizadorArbol {

    public int devolverMaximoPromedio (ArbolGeneral<AreaEmpresa> arbol){


        if(arbol.esVacio()){
            return 0;
        }

        var maximoPromedio = 0;
        var sumaTardanza = 0;

        var cola = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();

        cola.agregarFinal(arbol);
        while (!cola.esVacia()){

            Integer cantidadNivel = cola.tamanio();



            for (int i = 0; i < cantidadNivel; i++) {

                ArbolGeneral<AreaEmpresa> nodo = cola.elemento(0);

               sumaTardanza += nodo.getDato().getTardanza();
                cola.eliminar(nodo);



                ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos = nodo.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                    cola.agregarFinal(hijos.proximo());
                }
            }

            int promedio = Math.round((float) sumaTardanza / cantidadNivel);

            sumaTardanza = 0;

            if(promedio > maximoPromedio){
                maximoPromedio = promedio;
            }
        }
        return maximoPromedio;
    }

}
