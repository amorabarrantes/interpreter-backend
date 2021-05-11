package com.example.interpreterbackend;

import contextAnalysis.AnalisisContextual;
import contextAnalysis.claseTablas;
import contextAnalysis.identificationTable;
import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

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

            if(errores.equals("")){
                return ("Compilado correctamente");
            }else{
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

            if(errores.equals("")){
                return ("Compilado correctamente");
            }else{
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

        AnalisisContextual ac = new AnalisisContextual();
        ac.visit(tree);


        if (ErrorCatcher.INSTANCE.stringErrores.equals("")) {
            System.out.println("Compilación Exitosa sin errores");
        } else {
            String mensaje = ErrorCatcher.INSTANCE.stringErrores;
            ErrorCatcher.INSTANCE.stringErrores = "";
            System.out.println(mensaje);
        }

        claseTablas ct = claseTablas.getIsntance();

        ct.tablaFunciones.imprimirNodoFuncion();
    }
}