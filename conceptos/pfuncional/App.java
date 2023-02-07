/* 
 ** TODO ESTO SI NO ESTUVIERA TRABAJANDO CON UN JAVA 11
    Para compilar:
        $ javac App.java
    Para ejecutar:
        $ java App
 ** DESDE JAVA 11, puedo ejecutar directamente archivos JAVA
        $ java App.java
    Cómo veis este cambio? ANECDOTICO 
 */

import java.util.function.* ;  // J1.8
import java.util.* ;  

public class App {
    
    public static void main(String[] args){
        
        System.out.println( doblar(6) );
        System.out.println( mitad(6)  );
        
        // J1.8 ... Programación funcional
                                                     // 3+7
                                                      /*EXPRESION*/
        Function<Double, Double> operacionAEjecutar = App::doblar; // Statement J1.8
        imprimirResultadoDeOperacion( operacionAEjecutar , 6);
        
        imprimirResultadoDeOperacion( App::doblar , 6);
        
        // Expresiones lambda: J 1.8
        // Un trozo de código que devuelve una funcíon anónima, creada en ese trozo de código
        imprimirResultadoDeOperacion(    (Double numero) -> {   
                                                                return numero * 2; 
                                                            }           , 6);
                                                            
        imprimirResultadoDeOperacion(    numero -> numero * 2           , 6);
        
        
        
        //List<String> miLista = new ArrayList<String>();
        //List<String> miLista = new ArrayList<>();
        /*
        var miLista = new ArrayList<String>();      // JAVA 10

        miLista.add("Texto1");
        miLista.add("TExto2");
        miLista.add("TEXTO3");
        */
        // JAVA 9, Metodo .of  en List
        //List<String> miLista = List.of("Texto1", "TEXTo2", "TEXTO3");
        var miLista = List.of("Texto1", "TEXTo3", "TEXTO2"); // VAR J10
        
        // Formas de iterar esta lista. 
        // Pre JAVA 1.5
        for (int indice = 0; indice < miLista.size(); indice++ )
            System.out.println( miLista.get(indice));
            
        // pre-JAVA 1.8 : FOREACH
        for (String item : miLista)
            System.out.println( item );
        
        // post J1.8 : STREAMS      MUCHO MAS EFICIENTE
        miLista.stream().forEach( System.out::println );
        
        miLista.stream().map( texto -> texto.toLowerCase() )
                       .sorted()
                       .filter( texto -> texto.endsWith("2") )
                       .forEach( System.out::println );
        // Vería 1 core al 100%... Y si tengo 8 cores en mi máquina:
        // Pues 7 los tienes de baretas! TAS HACIENDO EL PRINGAO !
        // Si quisiera usar los 8 cores, que necesitaría: Threads
        miLista.parallelStream().map( texto -> texto.toLowerCase() )
                       .sorted()
                       .filter( texto -> texto.endsWith("2") )
                       .forEach( System.out::println );
    }
    
    public static void imprimirResultadoDeOperacion( 
            Function<Double, Double> operacion, double numero ){// Statement
        System.out.println( operacion.apply(numero) );
    }
    
    public static double doblar(double numero)  {
        return numero * 2; 
    }
    
    public static double mitad(double numero) {
        return numero / 2; 
    }
    
}