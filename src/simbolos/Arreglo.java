/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simbolos;

import analizadorLexico.*;

public class Arreglo extends Tipo {

    public Tipo de; // arreglo *de* tipo
    public int tamanio = 1; // numero de elementos

    public Arreglo(int tm, Tipo p) {
        super("[]", Etiqueta.INDEX, tm * p.anchura);
        tamanio = tm;
        de = p;
    }

    public String toString() {
        return "[" + tamanio + "] " + de.toString();
    }

}
