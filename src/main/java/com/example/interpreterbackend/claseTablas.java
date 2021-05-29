package com.example.interpreterbackend;

import Interpreter.nodoValorClase;
import Interpreter.nodoValorVariable;
import Interpreter.valuesTable;
import contextAnalysis.identificationTable;
import contextAnalysis.nodoClase;
import contextAnalysis.nodoFuncion;
import contextAnalysis.nodoVariable;

import java.util.LinkedList;

public class claseTablas {
    public static claseTablas instance = null;
    public static claseTablas getIsntance() {
        if (instance == null) {
            instance = new claseTablas();
        }
        return instance;
    }

    public identificationTable<nodoVariable> tablaVarDeclaration;
    public identificationTable<nodoClase> tablaClassDeclaration;
    public identificationTable<nodoFuncion> tablaFunciones;

    //De aqui en adelante es para asignaciones.
    public valuesTable<nodoValorVariable> tablaNodoValorVariable;
    public valuesTable<nodoValorClase> tablaNodoValorClase;


    public claseTablas() {
        this.tablaVarDeclaration = new identificationTable<>(new LinkedList<>(), 0);
        this.tablaClassDeclaration = new identificationTable<>(new LinkedList<>(), 0);
        this.tablaFunciones = new identificationTable<>(new LinkedList<>(), 0);

        //De aqui en adelante es para asignaciones.
        this.tablaNodoValorVariable = new valuesTable<>(new LinkedList<>(),0);
        this.tablaNodoValorClase = new valuesTable<>(new LinkedList<>(),0);
    }
}
