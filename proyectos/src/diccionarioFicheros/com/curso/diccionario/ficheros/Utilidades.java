package com.curso.diccionario.ficheros;

import com.curso.diccionario.Diccionario;
import java.util.Optional;
import java.util.Objects;

public interface Utilidades {
 
    public static Optional<Diccionario> cargarDiccionario(String idioma){
        
    }
    
    public static String normalizarPalabra(String palabra){
        return Objects.requiredNonNull(palabra.toLowerCase());
    }
    
    public static int diferenciaEntrePalabras(String palabra1, String palabra2){
        
    }
}