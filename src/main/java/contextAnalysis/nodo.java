package contextAnalysis;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class nodo {
    Token tok;
    String type;
    int nivel;
    ParserRuleContext declCtx;

    public nodo(Token tok, String type, int nivel, ParserRuleContext declCtx) {
        this.tok = tok;
        this.type = type;
        this.nivel = nivel;
        this.declCtx = declCtx;
    }
}