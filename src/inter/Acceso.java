/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

import analizadorLexico.*;
import simbolos.*;

public class Acceso extends Op{

    public Id arreglo;
    public Expr indice;

    public Acceso(Id a, Expr i, Tipo p) { // p es el tipo de elemento despues de
        super(new Palabra("[]", Etiqueta.INDEX), p);// aplanar el arreglo
        arreglo = a;
        indice = i;
    }

    public Expr gen() {
        return new Acceso(arreglo, indice.reducir(), tipo);
    }

    public void salto(int t, int f) {
        emitirsaltos(reducir().toString(), t, f);
    }

    public String toString() {
        return arreglo.toString() + " [ " + indice.toString() + " ]";
    }
}
