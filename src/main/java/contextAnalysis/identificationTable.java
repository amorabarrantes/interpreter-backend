package contextAnalysis;

import org.antlr.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.LinkedList;

public class identificationTable {

    public LinkedList<nodo> ll;
    public int nivel;

    public identificationTable(LinkedList<nodo> ll, int nivel) {
        this.ll = ll;
        this.nivel = nivel;
    }
    /**
     * Agrega un identificador a la Tabla
     */
    public void enter(Token tok, String type, int nivel, String atr, ParserRuleContext declCtx) {
        nodo NuevoNodo = new nodo(tok,type,nivel,atr,declCtx);
        ll.addLast(NuevoNodo);
    }

    /**
     * Devuelve un identificador de la tabla. Retorna null
     * cuando el identificador no se encuentra en la tabla
     */
    public String retrieve(String nombre) {
        int x = ll.size()-1;
        for (int i=x;i>=0;i--){
            nodo Nodo = ll.get(i);
            if(Nodo.tok.getText().equals(nombre))
                return Nodo.Atr;
        }
        return null;
    }

    /**
     * Agrega un nuevo nivel de identificadores a la tabla
     * El más “profundo”
     */
    public void openScope() {
        nivel++;
    }

    /**
     * Elimina el más profundo nivel de identificadores de la tabla.
     * Se borran todos los campos de la tabla asociados con el nivel
     */
    public void closeScope() {
        int x = ll.size()-1;
        for (int i=x;i>=0;i--){
            nodo Nodo = ll.get(i);
            if(Nodo.nivel == nivel)
                ll.remove(i);
        }
        nivel --;
    }


    public void imprimir() {
        System.out.println("----- INICIO TABLA ------");
        for (int i = 0; i < ll.size(); i++) {
            Token s = ll.get(i).tok;
            System.out.println("Nombre: " + s.getText() + " - " + ll.get(i).nivel + " - " + ll.get(i).type);
        }
        System.out.println("----- FIN TABLA ------");
    }
}
