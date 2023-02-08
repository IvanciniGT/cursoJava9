package com.curso.app;

import java.util.ServiceLoader;
import java.util.Iterator;

import com.curso.diccionario.SuministradorDeDiccionarios;       // Inversión de dependencias
import com.curso.diccionario.Diccionario;                       // Inversión de dependencias

public class App {
    
    public static void main(String[] args){
        
        // Comprobación y carga de argumentos
        
        if (args.length != 2){
            System.out.println("No me has dado idioma y palabra");
            System.exit(1);
        }
        String idioma  = args[0];
        String palabra = args[1];
        
        // Carga del suministrador de diccionarios
        // Inyección de dependencias
        Iterator<SuministradorDeDiccionarios> suministradores = ServiceLoader.load( SuministradorDeDiccionarios.class ).iterator(); // J9. ServiceLoader + Modulos
        
        if (!suministradores.hasNext()){
            System.out.println("No se ha encontrado un suministrador de diccionarios válido en el classpath");
            System.exit(2);
        }
            
        SuministradorDeDiccionarios miSuministrador = suministradores.next();
        
        // Saco un diccionario del idioma solicitado
        
        if(! miSuministrador.existeDiccionario(idioma) ){
            System.out.println("No se ha encontrado un diccionario válido para ese idioma");
            System.exit(3);
        }
        Diccionario miDiccionario = miSuministrador.getDiccionario(idioma).get(); // J1.8 OPTIONAL
        
        /*
        Optional<Diccionario> miDiccionario = miSuministrador.getDiccionario(idioma); // J1.8 OPTIONAL
        if (miDiccionario.isEmpty()){
            System.out.println("No se ha encontrado un diccionario válido para ese idioma");
            System.exit(3);
        }else{
            miDiccionario.get();
        }
        */
        
        // Buscar la palabra y mostrar la información relevante
        
        if( miDiccionario.existe(palabra) ){
            System.out.println("La palabra "+palabra+" existe.");
            System.out.println("Significados:");
            miDiccionario.getSignificados(palabra).get().stream().forEach(System.out::println); // J1.8 OPTIONAL + STREAM + Program funcional
        }else{
            System.out.println("La palabra "+palabra+" no existe.");
            System.out.println("Quizás quisiste decir:");
            miDiccionario.getSugerencias(palabra).stream().forEach(System.out::println); // J1.8 STREAM + Program funcional
        }
        
    }
    
}