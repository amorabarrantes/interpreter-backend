package contextAnalysis;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

public class nodoVariable extends nodo{
    public String type;

    public nodoVariable(Token tok, int nivel, ParserRuleContext declCtx, String type) {
        super(tok, nivel, declCtx);
        this.type = type;
    }
}
