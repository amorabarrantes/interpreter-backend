package contextAnalysis;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

public class nodoClase extends nodo{
    ArrayList<nodoVariable> atributos;

    public nodoClase(Token tok, int nivel, ParserRuleContext declCtx, ArrayList<nodoVariable> atributos) {
        super(tok, nivel, declCtx);
        this.atributos = atributos;
    }
}
