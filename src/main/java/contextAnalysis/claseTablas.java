package contextAnalysis;

import Interpreter.nodoValor;
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
    public identificationTable<nodoValor> tablaValores;

    public claseTablas() {
        this.tablaVarDeclaration = new identificationTable<>(new LinkedList<>(), 0);
        this.tablaClassDeclaration = new identificationTable<>(new LinkedList<>(), 0);
        this.tablaFunciones = new identificationTable<>(new LinkedList<>(), 0);
        this.tablaValores = new identificationTable<>(new LinkedList<>(),0);
    }
}
