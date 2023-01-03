package ED;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Jemima
 */
public class Arbol {

    // atributos
    Nodo root;
    int peso;

    public Arbol() {
        this.root = null;
        this.peso = 0;
    }

    // métodos
    public void insertar(int dato, Nodo apnodo) {
        if (apnodo != null) {
            if (dato < apnodo.clave) {
                if (apnodo.HI == null) {
                    Nodo nuevo = new Nodo(dato);
                    apnodo.HI = nuevo;
                    this.peso++;

                } else {
                    System.out.println("Llamada recursiva 1");
                    insertar(dato, apnodo.HI);
                }

            } else {
                if (dato > apnodo.clave) {
                    if (apnodo.HD == null) {
                        Nodo nuevo = new Nodo(dato);
                        apnodo.HD = nuevo;
                        this.peso++;
                    } else {
                        System.out.println("Llamada recursiva 2");
                        insertar(dato, apnodo.HD);
                    }
                } else {
                    System.out.println("La información ya está en el árbol");
                }

            }
        } else {
            if (this.peso == 0) {
                Nodo nuevo = new Nodo(dato);
                this.root = nuevo;
                this.peso++;

            }
        }

    }

    public void recorridoInverso(Nodo raiz, int space, int height) {
        //primero el derecho, luego la raiz y por último el izquierdo
        String cadena = "";
        String cadena2 = "";
        // Caso base
        if (raiz == null) {
            return;
        }
        // aumentar la distancia entre niveles
        space += height;

        // imprime el hijo derecho primero
        recorridoInverso(raiz.HD, space, height);
        if (raiz.HD != null) {
            for (int i = height; i < (space + 5); i++) {
                cadena = cadena + " ";
            }
            cadena = cadena + "/";
            System.out.println(cadena);
        } else {

            System.out.println();
        }
        // imprime el nodo actual después de rellenar con espacios
        for (int i = height; i < space; i++) {
            System.out.print(' ');
        }

        System.out.println(raiz.clave);
        // imprime el hijo izquierdo
        if (raiz.HI != null) {
            for (int i = height; i < (space + 5); i++) {
                cadena2 = cadena2 + " ";
            }
            cadena2 = cadena2 + "\\";
            System.out.println(cadena2);
        } else {
            System.out.println();
        }
        recorridoInverso(raiz.HI, space, height);
    }

    //Jemima
    public void inorden(Nodo apnodo) {
        if (apnodo != null) {
            //Primero el izquierdo
            inorden(apnodo.HI);

            //Luego la raíz
            System.out.print(apnodo.clave + ", ");

            // Después el derecho
            inorden(apnodo.HD);

        }

    }

    //Dulce
    public void preorden(Nodo apnodo) {
        if (apnodo != null) {
            //Primero la raíz
            System.out.print(apnodo.clave + ", ");
            //Luego la izquierda
            preorden(apnodo.HI);
            // después la derecha
            preorden(apnodo.HD);

        }

    }

    //Lourdes
    public void posorden(Nodo apnodo) {
        if (apnodo != null) {
            //Primero el izquierdo
            posorden(apnodo.HI);

            //Luego el derecho
            posorden(apnodo.HD);

            // Después la raíz
            System.out.print(apnodo.clave + ", ");
        }

    }

    public boolean buscar(Nodo apnodo, int info) {
        boolean encontrado = false;
        if (apnodo != null) {
            if (info < apnodo.clave) {
                encontrado = buscar(apnodo.HI, info);

            } else {
                if (info > apnodo.clave) {
                    encontrado = buscar(apnodo.HD, info);
                } else {
                    System.out.println("La información se encuentra en el árbol");
                    encontrado = true;
                    return encontrado;
                }

            }

        } else {
            System.out.println("La información no se encuentra en el árbol");
        }
        return encontrado;
    }

    public void recorridoInverso(Nodo raiz, int space, int height, int buscado) {
        //primero el derecho, luego la raiz y por último el izquierdo
        String cadena = "";
        String cadena2 = "";
        // Caso base
        if (raiz == null) {
            return;
        }
        // aumentar la distancia entre niveles
        space += height;

        // imprime el hijo derecho primero
        recorridoInverso(raiz.HD, space, height, buscado);
        if (raiz.HD != null) {
            for (int i = height; i < (space + 5); i++) {
                cadena = cadena + " ";
            }
            cadena = cadena + "/";
            System.out.println(cadena);
        } else {

            System.out.println();
        }
        // imprime el nodo actual después de rellenar con espacios
        for (int i = height; i < space; i++) {
            System.out.print(' ');
        }
        if (raiz.clave == buscado) {
            System.out.println("> " + raiz.clave);
        } else {
            System.out.println(raiz.clave);
        }

        // imprime el hijo izquierdo
        if (raiz.HI != null) {
            for (int i = height; i < (space + 5); i++) {
                cadena2 = cadena2 + " ";
            }
            cadena2 = cadena2 + "\\";
            System.out.println(cadena2);
        } else {
            System.out.println();
        }
        recorridoInverso(raiz.HI, space, height, buscado);
    }
}
