package com.example.interpreterbackend;

import contextAnalysis.AnalisisContextual;
import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class metodos {

    public static final metodos INSTANCE = new metodos();

    public static String compilarCodigo(String codigo) {
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
            return ("Compilación Exitosa sin errores");
        } else {
            String mensaje = ErrorCatcher.INSTANCE.stringErrores;
            ErrorCatcher.INSTANCE.stringErrores = "";
            return (mensaje);
        }
    }



    public static void main(String[] args) {
        myScanner inst = null;
        myParser parser = null;
        ParseTree tree = null;
        CharStream input = null;
        CommonTokenStream tokens = null;

        input = CharStreams.fromString("int x = 5; int q = hola; int q = 3;");
        inst = new myScanner(input);
        inst.addErrorListener(ErrorCatcher.INSTANCE);
        tokens = new CommonTokenStream(inst);
        parser = new myParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorCatcher.INSTANCE);
        tree = parser.program();

        AnalisisContextual ac = new AnalisisContextual();

        ac.visit(tree);
        if (ErrorCatcher.INSTANCE.stringErrores == "") {
            System.out.println("Compilación Exitosa sin errores");
        } else {
            String mensaje = ErrorCatcher.INSTANCE.stringErrores;
            ErrorCatcher.INSTANCE.stringErrores = "";
            System.out.println(mensaje);
        }
    }

















    /*
    public static void main(String[] args) {

        myScanner inst = null;
        myParser parser = null;
        ParseTree tree = null;
        CharStream input = null;
        CommonTokenStream tokens = null;
        try {
            input = CharStreams.fromFileName("code.txt");
            inst = new myScanner(input);
            tokens = new CommonTokenStream(inst);
            parser = new myParser(tokens);
            tree = parser.program();
            System.out.println("Compilación Terminada!!\n");

           System.out.println(printSyntaxTree(parser, tree));

            java.util.concurrent.Future<JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree, parser);
            treeGUI.get().setVisible(true);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


     */
/*
        DE TREE A STRING

    public static String printSyntaxTree(Parser parser, ParseTree root) {
        StringBuilder buf = new StringBuilder();
        recursive(root, buf, 0, Arrays.asList(parser.getRuleNames()));
        return buf.toString();
    }

    private static void recursive(ParseTree aRoot, StringBuilder buf, int offset, List<String> ruleNames) {
        for (int i = 0; i < offset; i++) {
            buf.append("  ");
        }
        buf.append(Trees.getNodeText(aRoot, ruleNames)).append("\n");
        if (aRoot instanceof ParserRuleContext) {
            ParserRuleContext prc = (ParserRuleContext) aRoot;
            if (prc.children != null) {
                for (ParseTree child : prc.children) {
                    recursive(child, buf, offset + 1, ruleNames);
                }
            }
        }
    }

 */

}