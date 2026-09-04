package tp02.ejercicio4;

import tp02.ArbolGeneral;

public class TestAnalizadorArbol {

    public static void main() {


        AreaEmpresa a = new AreaEmpresa("A", 14);
        AreaEmpresa b = new AreaEmpresa("B", 16);
        AreaEmpresa c = new AreaEmpresa("C", 18);
        AreaEmpresa d = new AreaEmpresa("D", 14);
        AreaEmpresa e = new AreaEmpresa("E", 10);
        AreaEmpresa f = new AreaEmpresa("F", 10);
        AreaEmpresa g = new AreaEmpresa("G", 10);

        // Crear los nodos
        ArbolGeneral<AreaEmpresa> nodoA = new ArbolGeneral<>(a);
        ArbolGeneral<AreaEmpresa> nodoB = new ArbolGeneral<>(b);
        ArbolGeneral<AreaEmpresa> nodoC = new ArbolGeneral<>(c);
        ArbolGeneral<AreaEmpresa> nodoD = new ArbolGeneral<>(d);
        ArbolGeneral<AreaEmpresa> nodoE = new ArbolGeneral<>(e);
        ArbolGeneral<AreaEmpresa> nodoF = new ArbolGeneral<>(f);
        ArbolGeneral<AreaEmpresa> nodoG = new ArbolGeneral<>(g);


        nodoA.agregarHijo(nodoB);
        nodoA.agregarHijo(nodoC);
        nodoA.agregarHijo(nodoD);

        nodoB.agregarHijo(nodoE);
        nodoB.agregarHijo(nodoF);

        nodoD.agregarHijo(nodoG);

        /*
        *      A(14)           /1= 14
           /    |    \
       B(16)  C(18)  D(14)    /3 =16
        / \            |
     E(10) F(10)     G(10)    /3 = 10
        *
        * */
        AnalizadorArbol analizador = new AnalizadorArbol();

        int resultado = analizador.devolverMaximoPromedio(nodoA);

        System.out.println("Máximo promedio: " + resultado);
    }

}
