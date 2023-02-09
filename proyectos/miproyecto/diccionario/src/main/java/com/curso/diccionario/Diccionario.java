package com.curso.diccionario;

import java.util.List;
import java.util.Optional;
import lombok.NonNull;

public interface Diccionario {
    
    boolean existe(String palabra);
    
    Optional<List<String>> getSignificados(@NonNull String palabra);
    
    List<String> getSugerencias(@NonNull String palabra);
    
}