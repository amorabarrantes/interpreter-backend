package com.example.interpreterbackend;

import Interpreter.interpreterVisit;
import Interpreter.nodoValorClase;
import Interpreter.nodoValorVariable;
import contextAnalysis.AnalisisContextual;
import contextAnalysis.identificationTable;
import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;
import java.util.LinkedList;




public class metodos {

    public static final metodos INSTANCE = new metodos();

    public static String compilarCodigoCompleto(String codigo) {
        claseTablas ct = claseTablas.getIsntance();

        ct.tablaFunciones = new identificationTable<>(new LinkedList<>(), 0);
        ct.tablaClassDeclaration = new identificationTable<>(new LinkedList<>(), 0);
        ct.tablaVarDeclaration = new identificationTable<>(new LinkedList<>(), 0);


        myScanner inst = null;
        myParser parser = null;
        ParseTree tree = null;
        CharStream input = null;
        CommonTokenStream tokens = null;

        input = CharStreams.fromString(codigo);
        inst = new myScanner(input);
        inst.addErrorListener(ErrorCatcher.INSTANCE);
        tokens = new CommonTokenStream(inst);
        parser = new myParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorCatcher.INSTANCE);
        tree = parser.program();

        if (ErrorCatcher.INSTANCE.stringErrores == "") {
            AnalisisContextual ac = new AnalisisContextual();
            ac.varErrores = "";
            ac.visit(tree);
            String errores = ac.varErrores;

            if (errores.equals("")) {
                return ("Compilado correctamente");
            } else {
                ac.varErrores = "";
                return errores;
            }
        } else {
            String mensaje = ErrorCatcher.INSTANCE.stringErrores;
            ErrorCatcher.INSTANCE.stringErrores = "";
            return (mensaje);
        }
    }


    public static String compilarCodigoConsola(String codigo) {
        myScanner inst = null;
        myParser parser = null;
        ParseTree tree = null;
        CharStream input = null;
        CommonTokenStream tokens = null;

        input = CharStreams.fromString(codigo);
        inst = new myScanner(input);
        inst.addErrorListener(ErrorCatcher.INSTANCE);
        tokens = new CommonTokenStream(inst);
        parser = new myParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorCatcher.INSTANCE);
        tree = parser.program();

        if (ErrorCatcher.INSTANCE.stringErrores == "") {
            AnalisisContextual ac = new AnalisisContextual();
            ac.varErrores = "";
            ac.visit(tree);
            String errores = ac.varErrores;

            if (errores.equals("")) {
                return ("Compilado correctamente");
            } else {
                ac.varErrores = "";
                return errores;
            }
        } else {
            String mensaje = ErrorCatcher.INSTANCE.stringErrores;
            ErrorCatcher.INSTANCE.stringErrores = "";
            return (mensaje);
        }
    }

    public static void main(String[] args) throws IOException {
        claseTablas ct = claseTablas.getIsntance();

        myScanner inst = null;
        myParser parser = null;
        ParseTree tree = null;
        CharStream input = null;
        CommonTokenStream tokens = null;

        //Este codigo es para probar las vardeclarations: int x = 5; int q = hola; int q = 3;
        //Este codigo es para probar las classDeclarations: class peruano {int x;};
        //Este codigo es para probar las funcionDeclarations: int funcioncita () {} || funcionxd funcioncita () {}
        //Este codigo es para probar las asignaciones de String: "int x = " + '"'+ "cadena" + '"' + ";"

        input = CharStreams.fromFileName("code.txt");
        inst = new myScanner(input);
        inst.addErrorListener(ErrorCatcher.INSTANCE);
        tokens = new CommonTokenStream(inst);
        parser = new myParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorCatcher.INSTANCE);
        tree = parser.program();


        /*
        HashMap<String, java.io.Serializable> hash_map = new HashMap<String, java.io.Serializable>();
        // Mapping string values to int keys
        hash_map.put("x", true);
        hash_map.put("hola",1);
        hash_map.put("hola2","hola");

        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hash_map);
        */

        if (ErrorCatcher.INSTANCE.stringErrores.equals("")) {
            System.out.println("CODIGO SIN ERRORES SINTAXIS");

            AnalisisContextual ac = new AnalisisContextual();
            ac.visit(tree);

            if (ac.varErrores.equals("")) {
                interpreterVisit iv = new interpreterVisit();
                iv.visit(tree);

                for (Object obj: iv.listaImpresion) {
                    System.out.print(obj.toString() + '\n');
                }
/*
                nodoValorClase hola = (nodoValorClase) ct.tablaNodoValorVariable.retrieveNode("hola").valor;
                System.out.println(hola.atributos.get(0).valor);

                nodoValorClase adios = (nodoValorClase) ct.tablaNodoValorVariable.retrieveNode("adios").valor;
                System.out.println(adios.atributos.get(0).valor);

                nodoValorClase adios2 = (nodoValorClase) ct.tablaNodoValorVariable.retrieveNode("adios2").valor;
                System.out.println(adios2.atributos.get(0).valor);
*/



            } else {
                System.out.println(ac.varErrores + "     *** AC");
            }


        } else {
            String mensaje = ErrorCatcher.INSTANCE.stringErrores;
            ErrorCatcher.INSTANCE.stringErrores = "";
            System.out.println(mensaje);
        }
    }
}