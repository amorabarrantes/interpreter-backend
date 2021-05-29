package Interpreter;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class nodoValorVariable extends nodoValor {
    public String type;
    public Object valor;

    public nodoValorVariable(String identifier, int nivel, String type, Object valor) {
        super(identifier, nivel);
        this.type = type;
        this.valor = valor;
    }
}

