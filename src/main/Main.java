/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.*; //todas las operaciones que se pueden hacer con java
import analizadorLexico.*;
import analizador.*;

public class Main {

    public static void main(String[] args) throws IOException {
        AnalizadorLexico lex = new AnalizadorLexico();  //creando un objeto analisador lexico
        Analizador analizar = new Analizador(lex);  //creando un objeto analisador sintactico mandando un parametro que es el analisador lexico
        analizar.programa(); //metodo del analisador sintactico
        System.out.write('\n');
    }
    
}

