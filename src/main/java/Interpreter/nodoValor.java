package Interpreter;

import contextAnalysis.nodo;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class nodoValor <T> extends nodo {
    public String type;
    public T valor;

    public nodoValor(Token tok, int nivel, ParserRuleContext declCtx, String type, T valor) {
        super(tok, nivel, declCtx);
        this.type = type;
        this.valor = valor;
    }
}

