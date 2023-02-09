package com.curso.diccionario.ficheros;

import com.curso.diccionario.SuministradorDeDiccionarios;
import com.curso.diccionario.Diccionario;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.List;
import java.util.WeakHashMap;

public class SuministradorDeDiccionariosImpl implements SuministradorDeDiccionarios {
    
    // Cual es el concepto de este MAPA?   CACHE ! 
    // La persistencia está en un fichero
    private final Map<String, Diccionario> diccionariosDisponibles = new WeakHashMap<>();
    
    public SuministradorDeDiccionariosImpl(){
        // OPCION 1: Cargar los diccionarios en constructor.NO LA QUEREMOS
        // Problemas: Más consumo de memoria quizás innecesario. 
        // Y mayor tiempo de arranque que no se si será necesario tampoco
        // cargarDiccionarios();
    }
    
    private boolean cargarDiccionario(String idioma){
        boolean cargado = diccionariosDisponibles.containsKey(idioma);
        if (! cargado){
            Optional<Map<String, List<String>>> diccionarioLeido = Utilidades.cargarDiccionario(idioma);
            if(diccionarioLeido.isPresent()){
                diccionariosDisponibles.put(idioma, new DiccionarioImpl(diccionarioLeido.get()));
                cargado = true;
            }
        }
        return cargado;
    }
    
    public boolean existeDiccionario(String idioma){
        // OPCION 2: Cargar los diccionarios la primera vez que se solicitan. LAZY
        return cargarDiccionario(idioma);
    }
    
    public Optional<Diccionario> getDiccionario(String idioma){
        if(existeDiccionario(idioma))
            return Optional.of(diccionariosDisponibles.get(idioma));
        else
            return Optional.empty();
    }
    
}