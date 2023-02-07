package paquete1;

import paquete2.Clase;
import paquete2.Interfaz;
import java.util.ServiceLoader; //JAVA 9
public class App {
    
    public static void main(String[] args) {
        
        Clase cl1=new Clase();
        
        System.out.println( cl1.dameTexto() );
        System.out.println( cl1.dameNumero() );

        System.out.println( Interfaz.dameOtroTexto() );

        Iterable<Interfaz> interfaces = ServiceLoader.load(Interfaz.class);
        // Cuando pido un load al Service Loader:
        // Si no se ha generado ya iuna instancia, se devuelve una nueva
        // Caso que se haya generado una instancia, se me devuelve la existente
        // Es decir, Las implementaciones de la interfaz se comportan como un Singleton

        for (Interfaz interfaz : interfaces){
            System.out.println( interfaz.dameTexto() );
            System.out.println( interfaz.dameNumero() );
        }
    }
    
}

// ESTE CODIGO ESTA GUAY  !!!!!!!!
// NO ESTA FUERTEMENTE ACOPLADO !
// NI TIENE PROBLEMAS DE SEGURIDAD

// Aunque?
// Tengo YO libertad de elegir las implementaciones 
// que quiero utilizar?


