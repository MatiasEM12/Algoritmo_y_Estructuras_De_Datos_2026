package tp02.ejercicio5;


import tp02.ArbolGeneral;

public class RedDeAguaPotable {

    private ArbolGeneral<Integer> red;

    public RedDeAguaPotable(ArbolGeneral<Integer> red) {
        this.red = red;
    }


    public double minimoCaudal(double caudal) {

        if (red.esVacio()) {
            return 0;
        }

        return minimoCaudal(red, caudal);
    }

    private double minimoCaudal(ArbolGeneral<Integer> nodo, double caudal){

        if(nodo.esHoja()){
            return caudal;
        }

        var hijos = nodo.getHijos();

        double caudalHijo = caudal / hijos.tamanio();

        double caudalMinimo = Double.MAX_VALUE;

        hijos.comenzar();

        while(!hijos.fin()){

            var hijo = hijos.proximo();
            double minimoHijo = minimoCaudal(hijo, caudalHijo);

            if (minimoHijo < caudalMinimo) {
                caudalMinimo = minimoHijo;
            }
        }
        return caudalMinimo;
    }
}
