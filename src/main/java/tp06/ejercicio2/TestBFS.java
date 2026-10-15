package tp06.ejercicio2;

import tp01.ejercicio2.ListaGenerica;
import tp06.Grafo;
import tp06.ListaDeAdyaciencia.GrafoImplListAdy;
import tp06.ListaDeAdyaciencia.VerticeImplListAdy;
import tp06.MatrizDeAdyacencia.GrafoImplMatrizAdy;
import tp06.MatrizDeAdyacencia.VerticeImplMatrizAdy;
import tp06.Vertice;

public class TestBFS {

    public static void main() {

        Recorridos recorridos = new Recorridos();
        //con GrafoImplListAdy

        Grafo<String> grafoList = new GrafoImplListAdy<String>();
        Vertice<String> vlA = new VerticeImplListAdy<String>("A");
        Vertice<String> vlB = new VerticeImplListAdy<String>("B");
        Vertice<String> vlC = new VerticeImplListAdy<String>("C");
        Vertice<String> vlD = new VerticeImplListAdy<String>("D");
        Vertice<String> vlH = new VerticeImplListAdy<String>("H");
        Vertice<String> vlT = new VerticeImplListAdy<String>("T");
        Vertice<String> vlR = new VerticeImplListAdy<String>("R");

        grafoList.agregarVertice(vlD);
        grafoList.agregarVertice(vlC);
        grafoList.agregarVertice(vlH);
        grafoList.agregarVertice(vlB);
        grafoList.agregarVertice(vlH);
        grafoList.agregarVertice(vlR);
        grafoList.agregarVertice(vlT);
        grafoList.agregarVertice(vlA);

        grafoList.conectar(vlD, vlC);
        grafoList.conectar(vlD, vlH);
        grafoList.conectar(vlD, vlB);

        grafoList.conectar(vlH, vlT);
        grafoList.conectar(vlH, vlA);

        grafoList.conectar(vlC, vlR);
        grafoList.conectar(vlR, vlH);
        grafoList.conectar(vlB, vlH);

        ListaGenerica<String> dfsList = recorridos.bfs(grafoList);
        System.out.println("BFS con GrafoImplListAdy: ");
        dfsList.comenzar();
        while (!dfsList.fin()) {
            System.out.print(dfsList.proximo() + " ");
        }
        System.out.println();

        //con GrafoImplMatrizAdy

        Grafo<String> grafoMatriz = new GrafoImplMatrizAdy<String>(7);

        Vertice<String> vmA = new VerticeImplMatrizAdy<String>("A");
        Vertice<String> vmB = new VerticeImplMatrizAdy<String>("B");
        Vertice<String> vmC = new VerticeImplMatrizAdy<String>("C");
        Vertice<String> vmD = new VerticeImplMatrizAdy<String>("D");
        Vertice<String> vmH = new VerticeImplMatrizAdy<String>("H");
        Vertice<String> vmT = new VerticeImplMatrizAdy<String>("T");
        Vertice<String> vmR = new VerticeImplMatrizAdy<String>("R");

        grafoMatriz.agregarVertice(vmD);
        grafoMatriz.agregarVertice(vmC);
        grafoMatriz.agregarVertice(vmH);
        grafoMatriz.agregarVertice(vmB);
        grafoMatriz.agregarVertice(vmR);
        grafoMatriz.agregarVertice(vmT);
        grafoMatriz.agregarVertice(vmA);

        grafoMatriz.conectar(vmH, vmT);
        grafoMatriz.conectar(vmH, vmA);

        grafoMatriz.conectar(vmD, vmH);

        grafoMatriz.conectar(vmD, vmC);
        grafoMatriz.conectar(vmC, vmR);
        grafoMatriz.conectar(vmR, vmH);

        grafoMatriz.conectar(vmD, vmB);
        grafoMatriz.conectar(vmB, vmH);

        ListaGenerica<String> dfsMatriz = recorridos.bfs(grafoMatriz);
        System.out.println("DBS con GrafoImplMatrizAdy: ");
        dfsMatriz.comenzar();
        while (!dfsMatriz.fin()) {
            System.out.print(dfsMatriz.proximo() + " ");
        }
        System.out.println();

    }
}
