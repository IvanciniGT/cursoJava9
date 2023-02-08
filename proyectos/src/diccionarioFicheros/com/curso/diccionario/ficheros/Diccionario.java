package com.curso.diccionario.ficheros;

import com.curso.diccionario.Diccionario;

import java.util.Optional;
import java.util.List;

public class Diccionario implements com.curso.diccionario.Diccionario {
    
    private final Map<String,List<String>> terminos;
    
    public Diccionario (Map<String,List<String>> terminos){
        this.terminos = terminos;
    }
    
    public boolean existe(String palabra){ 
        return terminos.containsKey(Utilidades.normalizarPalabra(palabra));
    }
    
    public Optional<List<String>> getSignificados(String palabra){
        return Optional.ofNullable(terminos.get(Utilidades.normalizarPalabra(palabra)));
    }
    
    public List<String> getSugerencias(String palabra){
        //Utilidades.diferenciaEntrePalabras(String palabra1, String palabra2)
    }
    
}