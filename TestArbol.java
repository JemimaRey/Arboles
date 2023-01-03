/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ED;

import java.util.Scanner;

/**
 *
 * @author Jemima
 */
public class TestArbol {

    public static int pedirEntero() {
        int entero = 0;
        boolean salir;
        do { //Usamos un ciclo while para seguir pidiendo el dato en caso de que se encuentre
            //la excepción
            salir = true;
            try {
                Scanner leer = new Scanner(System.in);
                entero = leer.nextInt();
            } catch (java.util.InputMismatchException e) {

                System.out.println("UPS, el dato no es válido");
                salir = false;
            }
        } while (!salir);
        return entero;
    }

    public static void main(String args[]) {
        boolean salir;
        int op;
        int dato;
        Arbol arbolito = new Arbol();
        salir = false;
        do {
            System.out.println("Árbol binario de búsqueda 1.- Insertar valor, 2.- Imprimir árbol 3.- Inorden, preorden, posorden 4.- Buscar 5.- Salir");
            op = pedirEntero();
            switch (op) {
                case 1:
                    System.out.println("Escribe un dato: ");
                    dato = pedirEntero();
                    arbolito.insertar(dato, arbolito.root);
                    break;
                case 2:
                    System.out.println("IMPRIMIENDO ÁRBOL");
                    mostrarArbol(arbolito);
                    break;
                case 3:
                    System.out.println("ORDENES DEL ÁRBOL");
                    mostrarOrdenes(arbolito);
                    break;
                case 4:
                    System.out.println("BUSCAR UN NODO");
                    buscarNodo(arbolito);
                    break;
                case 5:
                    System.out.println("Cerrando sesión");
                    salir = true;
                    break;
                default:
                    System.out.println("Elige un dato válido: ");

            }

        } while (!salir);

    }

    public static void mostrarArbol(Arbol arbolito) {
        int space = 0;
        int height = 10;
        Nodo raiz = arbolito.root;
        arbolito.recorridoInverso(raiz, space, height);

    }

    public static void mostrarOrdenes(Arbol arbolito) {
        System.out.println("Inorden: ");
        Nodo raiz = arbolito.root;
        arbolito.inorden(raiz);
        System.out.println("\n");
        System.out.println("Preorden: ");
        arbolito.preorden(raiz);
        System.out.println("\n");
        System.out.println("Posorden: ");
        arbolito.posorden(raiz);
        System.out.println("\n");
    }

    public static void buscarNodo(Arbol arbolito) {
        Nodo raiz = arbolito.root;
        int space = 0;
        int height = 10;
        System.out.println("¿Cuál dato deseas buscar?");
        int buscado = pedirEntero();
        boolean encontrado;
        encontrado = arbolito.buscar(raiz, buscado);
        System.out.println(encontrado);
        if (encontrado) {
            arbolito.recorridoInverso(raiz, space, height, buscado);

        }

    }
}
