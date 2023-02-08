package com.curso.diccionario.ficheros;

import com.curso.diccionario.Diccionario;

import java.util.Optional;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Map;

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
        
        palabra = Utilidades.normalizarPalabra(palabra);
        
        return this.terminos.keySet()                                                                                                    // Me quedo con los términos
                              .parallelStream()                                                                                          // Preparo las CPUs para freir huevos
                              .map(     termino     ->  new Sugerencia(termino, Utilidades.diferenciaEntrePalabras(termino, palabra))  ) // Calculo las distancias con la palabra preguntada
                              .filter(  sugerencia  ->  sugerencia.puntuacion <= Utilidades.DISTANCIA_MAXIMA                           ) // Filtro aquellas que tengan una distancia razonable
                              .sorted(  Comparator.comparing(  sugerencia  ->  sugerencia.puntuacion )                                 ) // Las ordeno por las más cercanas
                              .limit(   Utilidades.SUGERENCIAS_MAXIMAS                                                                 ) // Me quedo con unas pocas
                              .map(     sugerencia  ->  sugerencia.termino                                                             ) // Elimino información de puntuación/distancia
                              .collect( Collectors.toList()                                                                            ); // Convierto en una lista
    }
    
    private static class Sugerencia {
        String termino;
        int puntuacion;
        
        public Sugerencia(String termino,int puntuacion){
            this.termino=termino;
            this.puntuacion=puntuacion;
        }
        
    }
    
}