package contextAnalysis;

import java.util.LinkedList;

public class identificationTable<generico extends nodo> {

    public LinkedList<generico> ll;
    public int nivel;

    public identificationTable(LinkedList<generico> ll, int nivel) {
        this.ll = ll;
        this.nivel = nivel;
    }

    /**
     * Agrega un identificador a la Tabla
     */
    public void enter(generico nodo) {
        ll.addLast(nodo);
    }

    /**
     * Devuelve un identificador de la tabla. Retorna null
     * cuando el identificador no se encuentra en la tabla
     */
    public String retrieve(String nombre) {
        generico nodoBuscado = buscarNodo(nombre);
        if (nodoBuscado != null) {
            return (nodoBuscado.tok.getText());
        }
        return null;
    }

    public generico retrieveNode(String nombre) {
        generico nodoBuscado = buscarNodo(nombre);
        if (nodoBuscado != null) {
            return (nodoBuscado);
        }
        return null;
    }

    public generico buscarNodo(String nombre) {
        for (generico obj : ll) {
            if (obj.tok.getText().equals(nombre) && obj.nivel == nivel) {
                return (obj);
            }
        }
        return null;
    }


    /**
     * Agrega un nuevo nivel de identificadores a la tabla
     * El más “profundo”
     */
    public void openScope() {
        nivel++;
    }

    /**
     * Elimina el más profundo nivel de identificadores de la tabla.
     * Se borran todos los campos de la tabla asociados con el nivel
     */
    public void closeScope() {
        int x = ll.size() - 1;
        for (int i = x; i >= 0; i--) {
            nodo Nodo = ll.get(i);
            if (Nodo.nivel == nivel)
                ll.remove(i);
        }
        nivel--;
    }


    public void imprimirNodoVariable() {
        System.out.println("----- INICIO TABLA VARIABLES ------");
        for (generico obj : ll) {
            System.out.println("Nombre: " + obj.tok.getText() + " - " + obj.nivel + " - " + ((nodoVariable) obj).type);
        }
        System.out.println("----- FIN TABLA VARIABLES------");
    }

    public void imprimirNodoClase() {
        System.out.println("----- INICIO TABLA CLASES------");
        for (generico obj : ll) {
            System.out.println("\nNombre: " + obj.tok.getText() + " - Nivel: " + obj.nivel);
            System.out.println("Atributos:");
            for (nodoVariable obj2 : ((nodoClase) obj).atributos) {
                System.out.println("\tNombre: " + obj2.tok.getText() + " - Nivel: " + obj2.nivel + " - " + obj2.type);
            }
        }
        System.out.println("\n----- FIN TABLA CLASES------");
    }

    public void imprimirNodoFuncion() {
        System.out.println("----- INICIO TABLA FUNCIONES------");
        for (generico obj : ll) {
            System.out.println("\nNombre: " + obj.tok.getText() + " - Nivel: " + obj.nivel + " - Tipo: " + ((nodoFuncion) obj).type);
            System.out.println("Parametros:");
            for (nodoVariable obj2 : ((nodoFuncion) obj).parametros) {
                System.out.println("\tNombre: " + obj2.tok.getText() + " - Nivel: " + obj2.nivel + " - Tipo: " + obj2.type);
            }
        }
        System.out.println("\n----- FIN TABLA FUNCIONES------");
    }
}
