package com.curso.diccionario.ficheros;

import java.util.Optional;
import java.util.Objects;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Streams;

public interface Utilidades {
 
    public static int DISTANCIA_MAXIMA    = 2 ;
    public static int SUGERENCIAS_MAXIMAS = 8 ;
 
    public static Optional<Map<String, List<String>>> cargarDiccionario(String idioma){
        String nombreDelFichero="diccionario."+idioma+".txt";
        URL urlFichero = Utilidades.class.getClassLoader().getResource( nombreDelFichero );
        if ( urlFichero != null )
            try{
                // Si no os funciona getFile()     toURI()
                String contenidoDelFichero = Files.readString(Path.of(urlFichero.getFile()));   // Java 11
                                                //melón=Fruto del melonero|Persona poco espabilada
                Map<String, List<String>> terminosCargados=
                                    contenidoDelFichero.lines()                                              // Java 11
                                   .filter(      linea -> !linea.isBlank()                   )  // Java 11 // Quitamos lineas vacias
                                   .map(         linea -> linea.split("=")                   )  // Separamos termino de definicion
                                   .collect(     Collectors.toMap(                              // Convertir en un MapEntry      
                                                                        partes -> normalizarPalabra(partes[0]),    // Clave es el termino
                                                                        partes -> Arrays.asList(partes[1].split("\\|")) // La definicion es el resto, que separamos por |
                                                                        (definicion1, definicion2) -> Stream.of(definicion1,definicion2)
                                                                                                            .flatMap(Collections::stream)
                                                                                                            .collect(Collectors.toList())
                                                                 )
                                   );
                return Optional.of(terminosCargados);
            } catch(Exception e){
                System.out.println("Error");
                e.printStackTrace();
                // Interesaría mirar si la excepcion es por que el diccionario no tenga un buen formato
            }
        return Optional.empty();
        
    }
    
    public static String normalizarPalabra(String palabra){
        return Objects.requireNonNull(palabra.toLowerCase());
    }
    
    public static int diferenciaEntrePalabras(String palabra1, String palabra2){
        if ( Math.abs(palabra1.length() - palabra2.length()) > DISTANCIA_MAXIMA ) return DISTANCIA_MAXIMA+1;
        return computeLevenshteinDistance( palabra1,  palabra2);
    }
    
    private static int computeLevenshteinDistance(String str1, String str2) {   // JAVA 9
        return computeLevenshteinDistance(str1.toCharArray(),
                                          str2.toCharArray());
    }
    
    private static int minimum(int a, int b, int c) {                           // JAVA 9
         return Math.min(a, Math.min(b, c));
    }

    private static int computeLevenshteinDistance(char [] str1, char [] str2) { // JAVA 9
        int [][]distance = new int[str1.length+1][str2.length+1];

        for(int i=0;i<=str1.length;i++){
                distance[i][0]=i;
        }
        for(int j=0;j<=str2.length;j++){
                distance[0][j]=j;
        }
        for(int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){ 
                  distance[i][j]= minimum(distance[i-1][j]+1,
                                        distance[i][j-1]+1,
                                        distance[i-1][j-1]+
                                        ((str1[i-1]==str2[j-1])?0:1));
            }
        }
        return distance[str1.length][str2.length];
        
    }
    
    
}