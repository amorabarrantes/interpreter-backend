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
                interpreterVisit iv = new interpreterVisit();
                iv.varErroresInterprete = "";
                iv.visit(tree);
                String erroresInterpreter = iv.varErroresInterprete;
                if(erroresInterpreter.equals("")){
                    String mensajeImpresion = "";

                    for (String subMensaje: iv.listaImpresion) {
                        mensajeImpresion += subMensaje + "\n";
                    }

                    mensajeImpresion += " Ⓖ Ejecución finalizada.\n";

                    return mensajeImpresion;
                }else{
                    iv.varErroresInterprete = "";
                    iv.listaImpresion.clear();
                    return erroresInterpreter;
                }

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

        if (ErrorCatcher.INSTANCE.stringErrores.equals("")) {
            AnalisisContextual ac = new AnalisisContextual();
            ac.varErrores = "";
            ac.visit(tree);
            String errores = ac.varErrores;

            if (errores.equals("")) {
                interpreterVisit iv = new interpreterVisit();
                iv.varErroresInterprete = "";
                iv.visit(tree);
                String erroresInterpreter = iv.varErroresInterprete;
                if(erroresInterpreter.equals("")){

                    String mensajeImpresion = "";

                    for (String subMensaje: iv.listaImpresion) {
                        mensajeImpresion += subMensaje + "\n";
                    }

                    mensajeImpresion += " Ⓖ Ejecución finalizada.\n";

                    return mensajeImpresion;
                }else{
                    iv.varErroresInterprete = "";
                    iv.listaImpresion.clear();
                    return erroresInterpreter;
                }
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


                ct.tablaNodoValorVariable.imprimirNodoValorVariables();

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