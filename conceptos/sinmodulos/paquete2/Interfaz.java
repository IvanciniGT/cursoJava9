package paquete2;

public interface Interfaz {
    
    String dameTexto(); // En los interfaces public es el valor por defecto. NO SE PONE

    // Esto tiene sentido? 
    // Hasta Java 1.8, donde poníamos las funciones estáticas? En una clase.
    // Pero, las clases no sirven para definir TIPOS PROPIOS, que poder instanciar? SI
    // Y si las funciones estáticas no van asociadas a una instancia... deberían ir en una clase? No parece tener mucho sentido
    //    Pero no había otro sitio donde meterlas. AJO Y AGUA !
    // En la mayor parte de los escenarios, estas funciones tendrán más sentido en interfaces.
    
    public static String dameOtroTexto(){   // Desde Java 1.8
        return elTexto();
        // 100 lineas       Cuando partiré este código? REFACTORIZACION DE UN CODIGO 
    }

    // Esto tiene sentido? 
    // Y si tengo una función estática publica que tiene 500 lineas de código... 
    // Eso sería una buena práctica? NO
    // Y el primero que se va a quejar? SONARQUBE... que me la tira a la cara.
    // Y me dice, ya estás partiendo ese código.
    // Ya tengo una forma de partirlo.
    
    // Además puede ser que haya código que necesiten usar 2 funciones publicas static... 
    // Lo dplico? Nooo, lo meto en una función privada, reutilizable
    private static String elTexto(){        // Desde Java 1.9
        return "Soy el texto de la CLASE";
    }
    
    // Qué es esto? DE JAVA 1.8
    // Una función de instancia definida en un interfaz, con un código por defecto
    // Para que sirve? 
    // Cuando monto una interfaz, quiero meterle código? A priori NO.... 
    // Estoy definiendo un API de comunicación con mi software
    // Donde quiero la implementación? En una clase
    // Y si hay código común entre varias clases que puedan reutilizar? 
    // Pues que hereden unas de otras: extends, definir clases abstractas....
    
    // Entonces... para qué vale esto? MANTENIBILIDAD / EVOLUTIVOS
    default int dameNumero(){
        return 7;
    }
}

/*
Dia 1 defino una interfaz

public interface CUADRADO {
    
    double area();
    
}

Dia 2 -100... Millones de personas usando mi interfaz para crear su código

Dia 101... se me ocurre la brillante idea de añadir otra función a mi interfaz:

    double perimetro();
    
Dia 102: ME HAN CORTADO EL CUELLO !

// SOLUCION:

Le meto un valor por defecto a esa función. 

Aunque no haga nada

La gente si no estaba extendiendo esta función, es que no les valia para nada.. y les da igual la función y el dódigo que ponga dentro

Pero al menos su codigo sigue compilado.

Ya cuando quieran usar esta nueva característica, que le metan valor propio, que sobreescriban la función

PERO NO LES JODO ! FEO !!!!





*/