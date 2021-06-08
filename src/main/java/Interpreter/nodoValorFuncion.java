package Interpreter;

import generated.myParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public class nodoValorFuncion extends nodoValor {
    public String type;
    public ArrayList<nodoValorVariable> listaParametros;
    public myParser.FunctionDecASTContext declCtx;

    public nodoValorFuncion(String identifier, int nivel, String type, myParser.FunctionDecASTContext declCtx) {
        super(identifier, nivel);
        this.type = type;
        this.listaParametros = new ArrayList<>();
        this.declCtx = declCtx;
    }
}


