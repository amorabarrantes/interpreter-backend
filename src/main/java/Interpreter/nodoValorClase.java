package Interpreter;

import java.util.ArrayList;

public class nodoValorClase extends nodoValor{
    public ArrayList<nodoValorVariable> atributos;

    public nodoValorClase(String identifier, int nivel, ArrayList<nodoValorVariable> atributos) {
        super(identifier, nivel);
        this.atributos = atributos;
    }

    public nodoValorVariable buscarVariableClase (String nombre){
        for (nodoValorVariable obj : atributos) {
            if (obj.identifier.equals(nombre)) {
                return obj;
            }
        }
        return null;
    }
}

