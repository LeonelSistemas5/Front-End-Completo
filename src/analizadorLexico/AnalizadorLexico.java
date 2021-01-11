/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico;

import java.io.*; //libreria java
import java.util.*; //libreria java

import simbolos.*; // paquete simbolos

public class AnalizadorLexico { //clase principal

    public static int linea = 1;  //declarando variable simple estatica entera
    char preanalisis = ' ';   //declarando variable simple char vacia
    Hashtable palabras = new Hashtable();  //declarando objeto tipo Hashtable

    void reservar(Palabra w) { //metodo reservar recibiendo parametro tipo objeto Palabra w
        palabras.put(w.lexema, w); //
    }

    public AnalizadorLexico() {
        reservar(new Palabra("if", Etiqueta.IF));
        reservar(new Palabra("else", Etiqueta.ELSE));
        reservar(new Palabra("while", Etiqueta.WHILE));
        reservar(new Palabra("do", Etiqueta.DO));
        reservar(new Palabra("break", Etiqueta.BREAK));
        reservar(Palabra.True);
        reservar(Palabra.False);
        reservar(Tipo.Int);
        reservar(Tipo.Char);
        reservar(Tipo.Bool);
        reservar(Tipo.Float);
    }

    void readch() throws IOException {
        preanalisis = (char) System.in.read();
    }

    boolean readch(char c) throws IOException {
        readch();
        if (preanalisis != c) {
            return false;
        }
        preanalisis = ' ';
        return true;
    }

    public Token explorar() throws IOException {
        for (;; readch()) {
            if (preanalisis == ' ' || preanalisis == '\t') {
                continue;
            } else if (preanalisis == '\n') {
                linea = linea + 1;
            } else {
                break;
            }
        }
        switch (preanalisis) {
            case '&':
                if (readch('&')) {
                    return Palabra.and;
                } else {
                    return new Token('&');
                }
            case '|':
                if (readch('|')) {
                    return Palabra.or;
                } else {
                    return new Token('|');
                }
            case '=':

                if (readch('=')) {
                    return Palabra.eq;
                } else {
                    return new Token('=');
                }

            case '!':

                if (readch('=')) {
                    return Palabra.ne;
                } else {
                    return new Token('!');
                }

            case '<':

                if (readch('=')) {
                    return Palabra.le;
                } else {
                    return new Token('<');
                }

            case '>':

                if (readch('=')) {
                    return Palabra.ge;
                } else {
                    return new Token('>');
                }

        }

        if (Character.isDigit(preanalisis)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(preanalisis, 10);
                readch();
            } while (Character.isDigit(preanalisis));
            if (preanalisis != '.') {
                return new Num(v);
            }
            float x = v;
            float d = 10;
            for (;;readch()) {
                if (!Character.isDigit(preanalisis)) {
                    break;
                }
                x = x + Character.digit(preanalisis, 10) / d;
                d = d * 10;
            }
            return new Real(x);
        }

        if (Character.isLetter(preanalisis)) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(preanalisis);
                readch();
            } while (Character.isLetterOrDigit(preanalisis));
            String s = b.toString();
            Palabra w = (Palabra) palabras.get(s);
            if (w != null) {
                return w;
            }else{  //cambio
                w = new Palabra(s, Etiqueta.ID);
                palabras.put(s, w);
                return w;
            }
        }

        Token tok = new Token(preanalisis);
        preanalisis = ' ';
        return tok;
    }

}
