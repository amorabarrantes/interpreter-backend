package Interpreter;

import generated.myParser;

public class nodoValorFuncion extends nodoValor {
    public String type;
    public myParser.BlockContext valor;

    public nodoValorFuncion(String identifier, int nivel, String type, myParser.BlockContext valor) {
        super(identifier, nivel);
        this.type = type;
        this.valor = valor;
    }
}


