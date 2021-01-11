/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

import simbolos.*;

public class Do extends Instr {

    Expr expr;
    Instr instr;

    public Do() {
        expr = null;
        instr = null;
    }

    public void inic(Instr s, Expr x) {
        expr = x;
        instr = s;
        if (expr.tipo != Tipo.Bool) {
            expr.error("se requiere booleano en do");
        }
    }

    public void gen(int b, int a) {
        despues = a;
        int etiqueta = nuevaEtiqueta(); // etiqueta para expr
        instr.gen(b, etiqueta);
        emitirEtiqueta(etiqueta);
        expr.salto(b, 0);
    }
}
