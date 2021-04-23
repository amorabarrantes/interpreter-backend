package contextAnalysis;

import org.antlr.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class nodo {
    Token tok;
    String type;
    int nivel;
    String Atr;
    ParserRuleContext declCtx;

    public nodo(Token tok, String type, int nivel, String atr, ParserRuleContext declCtx) {
        this.tok = tok;
        this.type = type;
        this.nivel = nivel;
        Atr = atr;
        this.declCtx = declCtx;
    }
}