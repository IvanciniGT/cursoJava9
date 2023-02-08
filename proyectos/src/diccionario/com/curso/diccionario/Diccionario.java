package com.curso.diccionario;

import java.util.List;
import java.util.Optional;

public interface Diccionario {
    
    boolean existe(String palabra);
    
    Optional<List<String>> getSignificados(String palabra);
    
    List<String> getSugerencias(String palabra);
    
}