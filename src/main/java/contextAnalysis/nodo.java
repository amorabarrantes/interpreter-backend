package contextAnalysis;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class nodo {
    public Token tok;
    public int nivel;
    public ParserRuleContext declCtx;

    public nodo(Token tok, int nivel, ParserRuleContext declCtx) {
        this.tok = tok;
        this.nivel = nivel;
        this.declCtx = declCtx;
    }
}