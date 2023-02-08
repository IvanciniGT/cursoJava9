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
        
        // Esa funcion la quiero aplicar sobre: todos los terminos del diccionario
        // Esa función me da numeritos
        
        // Quedarme con las que no sean mayores de una cantidad > 2
        manano
        manzano 1

        manzana 2
        mañana  2
        // Ordenar los terminos por su puntuación
        // Limitar la lista: 10 mejores
        
    }
    
}