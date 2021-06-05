package Interpreter;

import generated.myParser;
import org.antlr.v4.runtime.ParserRuleContext;

public class nodoValorFuncion extends nodoValor {
    public String type;
    public ParserRuleContext declCtx;

    public nodoValorFuncion(String identifier, int nivel, String type, ParserRuleContext declCtx) {
        super(identifier, nivel);
        this.type = type;
        this.declCtx = declCtx;
    }
}


