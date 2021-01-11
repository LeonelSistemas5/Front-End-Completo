/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico;

public class Palabra extends Token { //heredando metodos y atributos de Token

    public String lexema = ""; //declarando variable string publica vacia

    public Palabra(String s, int etiqueta) { //constructor Palabra recibe dos parametros un string y un entero
        super(etiqueta);
        lexema = s; //lexema sera igual a 
    }

    public String toString() {
        return lexema;
    }

    public static final Palabra and = new Palabra("&&", Etiqueta.AND), or = new Palabra("||", Etiqueta.OR),
            eq = new Palabra("==", Etiqueta.EQ), ne = new Palabra("!=", Etiqueta.NE),
            le = new Palabra("<=", Etiqueta.LE), ge = new Palabra(">=", Etiqueta.GE),
            minus = new Palabra("minus", Etiqueta.MINUS),
            True = new Palabra("true", Etiqueta.TRUE),
            False = new Palabra("false", Etiqueta.FALSE),
            temp = new Palabra("t", Etiqueta.TEMP);

}
