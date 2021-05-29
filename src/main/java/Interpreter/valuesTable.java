package Interpreter;

import java.util.Arrays;
import java.util.LinkedList;

public class valuesTable<generico extends nodoValor> {

    public LinkedList<generico> ll;
    public int nivel;

    public valuesTable(LinkedList<generico> ll, int nivel) {
        this.ll = ll;
        this.nivel = nivel;
    }

    /**
     * Agrega un identificador a la Tabla
     */
    public void enter(generico nodoValor) {
        ll.addLast(nodoValor);
    }

    /**
     * Devuelve un identificador de la tabla. Retorna null
     * cuando el identificador no se encuentra en la tabla
     */
    public String retrieve(String nombre) {
        generico nodoBuscado = buscarNodo(nombre);
        if (nodoBuscado != null) {
            return (nodoBuscado.identifier);
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
        for (int x = ll.size() - 1; x >= 0; x--) {
            generico obj = ll.get(x);
            if (obj.identifier.equals(nombre) && obj.nivel <= nivel) {
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
            nodoValor Nodo = ll.get(i);
            if (Nodo.nivel == nivel)
                ll.remove(i);
        }
        nivel--;
    }


    public void imprimirNodoValorVariables() {
        System.out.println("----- INICIO TABLA VALORES ------");
        for (generico obj : ll) {
            if (((nodoValorVariable) obj).type.equals("int[]")) {
                System.out.println("Nombre: " + obj.identifier + " - " + obj.nivel + " - " + ((nodoValorVariable) obj).type + " - " + Arrays.toString((int[]) ((nodoValorVariable) obj).valor));
            } else if (((nodoValorVariable) obj).type.equals("char[]")) {
                System.out.println("Nombre: " + obj.identifier + " - " + obj.nivel + " - " + ((nodoValorVariable) obj).type + " - " + Arrays.toString((char[]) ((nodoValorVariable) obj).valor));
            } else if (((nodoValorVariable) obj).type.equals("string[]")) {
                System.out.println("Nombre: " + obj.identifier + " - " + obj.nivel + " - " + ((nodoValorVariable) obj).type + " - " + Arrays.toString((String[]) ((nodoValorVariable) obj).valor));
            } else if (((nodoValorVariable) obj).type.equals("boolean[]")) {
                System.out.println("Nombre: " + obj.identifier + " - " + obj.nivel + " - " + ((nodoValorVariable) obj).type + " - " + Arrays.toString((boolean[]) ((nodoValorVariable) obj).valor));
            } else {
                System.out.println("Nombre: " + obj.identifier + " - Nivel: " + obj.nivel + " - Tipo: " + ((nodoValorVariable) obj).type + " - Valor: " + ((nodoValorVariable) obj).valor);
            }
        }
        System.out.println("----- FIN TABLA VALORES------");
    }

    public void imprimirNodoValorClase() {
        System.out.println("----- INICIO TABLA CLASES------");
        for (generico obj : ll) {
            System.out.println("Nombre: " + obj.identifier + " - Nivel: " + obj.nivel);
            System.out.println("Atributos:");


            for (var obj2 : ((nodoValorClase)obj).atributos) {
                System.out.println("\tNombre: " + obj2.identifier + " - Nivel: " + obj2.nivel + " - Tipo: " + obj2.type + " - Valor: " + obj2.valor);
            }
        }
        System.out.println("\n----- FIN TABLA CLASES------");
    }

    /*
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
    */



    public String retornarStringTablaVariable() {
        StringBuilder tabla = new StringBuilder();
        tabla.append("----- INICIO TABLA VARIABLES ------");
        for (generico obj : ll) {
            tabla.append("\nNombre: ").append(obj.identifier).append(" - ").append(obj.nivel).append(" - ").append(((nodoValorVariable) obj).type);
        }
        tabla.append("\n----- FIN TABLA VARIABLES------");

        return tabla.toString();
    }

    /*
    public String retornarStringTablaClase() {
        StringBuilder tabla = new StringBuilder();
        tabla.append("----- INICIO TABLA CLASES------");
        for (generico obj : ll) {
            tabla.append("\nNombre: ").append(obj.identifier).append(" - Nivel: ").append(obj.nivel);
            tabla.append("\n  Atributos:");
            for (nodoVariable obj2 : ((nodoClase) obj).atributos) {
                tabla.append("\n\tNombre: ").append(obj2.tok.getText()).append(" - Nivel: ").append(obj2.nivel).append(" - ").append(obj2.type);
            }
        }
        tabla.append("\n----- FIN TABLA CLASES------");

        return tabla.toString();
    }

    public String retornarStringTablaFuncion() {
        StringBuilder tabla = new StringBuilder();
        tabla.append("----- INICIO TABLA FUNCIONES------");
        for (generico obj : ll) {
            tabla.append("\nNombre: ").append(obj.identifier).append(" - Nivel: ").append(obj.nivel).append(" - Tipo: ").append(((nodoFuncion) obj).type);
            tabla.append("\n  Parametros:");
            for (nodoVariable obj2 : ((nodoFuncion) obj).parametros) {
                tabla.append("\n\tNombre: ").append(obj2.tok.getText()).append(" - Nivel: ").append(obj2.nivel).append(" - Tipo: ").append(obj2.type);
            }
        }
        tabla.append("\n----- FIN TABLA FUNCIONES------");
        return tabla.toString();
    }
    */
}
