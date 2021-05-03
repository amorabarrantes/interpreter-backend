package contextAnalysis;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

public class nodoFuncion extends nodo{
    ArrayList<nodoVariable> parametros;
    String type;

    public nodoFuncion(Token tok, int nivel, ParserRuleContext declCtx, ArrayList<nodoVariable> parametros, String type) {
        super(tok, nivel, declCtx);
        this.parametros = parametros;
        this.type = type;
    }
}
