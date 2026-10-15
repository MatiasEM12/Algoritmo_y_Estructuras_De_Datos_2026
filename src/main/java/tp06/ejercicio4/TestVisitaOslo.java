package tp06.ejercicio4;

import tp01.ejercicio2.ListaEnlazadaGenerica;
import tp01.ejercicio2.ListaGenerica;
import tp06.ListaDeAdyaciencia.GrafoImplListAdy;
import tp06.ListaDeAdyaciencia.VerticeImplListAdy;
import tp06.Vertice;

public class TestVisitaOslo {

    public static  void main() {


        String origen = "Ayuntamiento";
        String destino ="Museo Vikingo";
        int tiempoMaximo=120;
        ListaGenerica<String> camino = new ListaEnlazadaGenerica<>();

        GrafoImplListAdy<String> grafo = new GrafoImplListAdy<>();
        Vertice<String> v1 = new VerticeImplListAdy("Ayuntamiento");
        Vertice<String> v2 = new VerticeImplListAdy("Museo Fram");
        Vertice<String> v3 = new VerticeImplListAdy("FolkMuseum");
        Vertice<String> v4 = new VerticeImplListAdy("Ayuntamiento");
        Vertice<String> v5 = new VerticeImplListAdy("Akker Brigge");
        Vertice<String> v6 = new VerticeImplListAdy("Palacio Real");
        Vertice<String> v7 = new VerticeImplListAdy("Parque Vigeland");
        Vertice<String> v8 = new VerticeImplListAdy("Museo Vikingo");
        Vertice<String> v9 = new VerticeImplListAdy("Holmenkollen");
        Vertice<String> v10 = new VerticeImplListAdy("Galeria Nacional");
        Vertice<String> v11 = new VerticeImplListAdy("Parque Botánico");
        Vertice<String> v12 = new VerticeImplListAdy("Museo Munch");
        Vertice<String> v13 = new VerticeImplListAdy("El Tigre");
        Vertice<String> v14 = new VerticeImplListAdy("La Opera");
        Vertice<String> v15 = new VerticeImplListAdy("Fortaleza Akershus");
        Vertice<String> v16 = new VerticeImplListAdy("Museo del Barco Polar");

        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.agregarVertice(v6);
        grafo.agregarVertice(v7);
        grafo.agregarVertice(v8);
        grafo.agregarVertice(v9);
        grafo.agregarVertice(v10);
        grafo.agregarVertice(v11);
        grafo.agregarVertice(v12);
        grafo.agregarVertice(v13);
        grafo.agregarVertice(v14);
        grafo.agregarVertice(v15);
        grafo.agregarVertice(v16);

        grafo.conectar(v16,v2,5); //Museo del Barco Polar -Museo Fram
        grafo.conectar(v2,v16,5);

        grafo.conectar(v16,v8,5); //Museo del Barco Polar - Museo Vikingo
        grafo.conectar(v8,v16,5);

        grafo.conectar(v2,v3,5); //Museo Fram -FolkMuseum
        grafo.conectar(v3,v2,5);


        grafo.conectar(v3,v7,20);// FolkMuseum - Parque Vigeland
        grafo.conectar(v7,v3,20);


        grafo.conectar(v3,v6,5);//FolkMuseum - Palacio Real
        grafo.conectar(v6,v3,5);

        grafo.conectar(v3,v5,30);//FolkMuseum - Akker Brigge
        grafo.conectar(v5,v3,30);

        grafo.conectar(v8,v5,30);// Museo Vikingo - Akker Brigge
        grafo.conectar(v5,v8,30);

        grafo.conectar(v7,v9,30);//Parque Vigenland - Holmenkollen
        grafo.conectar(v9,v7,30);

        grafo.conectar(v7,v10,30);//Parque Vigenland - Galeria Naciona
        grafo.conectar(v10,v7,30);

        grafo.conectar(v6,v1,5);//Palacio Real - Ayuntamiento
        grafo.conectar(v1,v6,5);

        grafo.conectar(v5,v1,5);//Akker Brigger - Ayuntmiento
        grafo.conectar(v1,v5,5);

        grafo.conectar(v10,v11,15);// Galeria Nacional - Parque Botanico
        grafo.conectar(v11,v10,15);

        grafo.conectar(v11,v1,10);// Parque Botanico - Ayuntamiento
        grafo.conectar(v1,v11,10);

        grafo.conectar(v1,v13,15);// Ayuntamiento - El Tigre
        grafo.conectar(v13,v1,15);

        grafo.conectar(v11,v12,1);// Parque Botanico - Museo Munch
        grafo.conectar(v13,v12,1);

        grafo.conectar(v12,v13,15);// Museo Munch - El Tigre
        grafo.conectar(v13,v12,15);

        grafo.conectar(v13,v14,5);// El Tigre - La Opera
        grafo.conectar(v14,v13,5);

        grafo.conectar(v14,v15,10);// La Opera - Fortaleza Akershus
        grafo.conectar(v15,v14,10);

        ListaGenerica<String> resultado;
        ListaGenerica<String> lugaresRestringidos = new ListaEnlazadaGenerica<>();
        lugaresRestringidos.agregarFinal("Akker Brigge");
        lugaresRestringidos.agregarFinal("Palacio Real");

        VisitaOslo visitaOslo = new VisitaOslo(origen);
        resultado = visitaOslo.paseoEnBici(grafo, destino, tiempoMaximo, lugaresRestringidos);

        System.out.println("Camino encontrado: ");

        resultado.comenzar();
        while(!resultado.fin()) {
            System.out.println(resultado.proximo());

        }

        /*
        * Resultado Posible 1 : Ayuntamiento, El Tigre, Museo Munch, Parque Botánico, Galería
                                Nacional, Parque Vigeland, FolkMuseum, Museo Fram, Museo del
                                Barco Polar, Museo Vikingo. El recorrido se hace en 91 minutos.

        *Resultado Posible 2: Ayuntamiento, Parque Botánico, Galería Nacional, Parque
                                Vigeland, FolkMuseum, Museo Fram, Museo del Barco Polar,
                                Museo Vikingo. El recorrido se hace en 70 minutos.

        * */
    }
}
