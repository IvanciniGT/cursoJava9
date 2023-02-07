package paquete1;

import paquete2.Clase;
import paquete2.Interfaz;
import paquete2.Factoria;
import paquete2.impl.ClaseQueImplementaInterfaz1;

public class App {
    
    public static void main(String[] args) {
        
        Clase cl1=new Clase();
        
        System.out.println( cl1.dameTexto() );
        System.out.println( cl1.dameNumero() );

        Interfaz int1 = Factoria.dameImplementacion1();
        Interfaz int2 = Factoria.dameImplementacion2();
        new ClaseQueImplementaInterfaz1();  // PROBLEMON
                                            // Nadie tiene porque poder instanciar esas clases.
                                            // El impacto de esto podría ser gigante
    
        System.out.println( Interfaz.dameOtroTexto() );

        System.out.println( int1.dameTexto() );
        System.out.println( int1.dameNumero() );

        System.out.println( int2.dameTexto() );
        System.out.println( int2.dameNumero() );

    }
    
}

// ESTE CODIGO ES UNA MIERDA GIGANTESCA !!!!!!!!
// FUERTEMENTE ACOPLADO !
// Cuantas cosas estoy importando yo aqui del otro paquete? 4
// Para qué me han creado una Interfaz? Para aislarme y darme una forma de comunicación con el otro paquete
// Pero acabo importando las clases. En serio ? RUINA GRANDE

// Y si los tios que están montando el otro paquete deciden que ya no quieren tener
// ClaseQueImplementaInterfaz1
// ClaseQueImplementaInterfaz2

// sino:
// ClaseQueImplementaInterfaz1V2
// ClaseQueImplementaInterfaz2V2

// Que pasa con mi código? Explota! Eso está bien planteado? Eso estñá debilmente acoplado? NO
// MUY MALA PRACTICA. HORRIBLE... ESTO ES LO QUE NOS HA VUELTO LOCOS AÑOS Y AÑOS
// Creando sistemas inmanejable, inmantenibles

// PROHIBIDO HACERLO MAS !


