# JAVA 

Lenguaje de programación. Características:
- Paradigmas: Una forma de usar el "lenguaje" para expresar ciertos conceptos o ideas
  - Programación imperativa: if, else, for, while, switch
  - Programación procedural: Habilidad de un lenguaje para crear/definir y ejecutar/invocar 
                             procedimientos/functiones/métodos
  - Programación funcional:  Desde la versión 1.8
                             Capacidad de que una variable referencie a una función:
                             - Que una función acepte como argumentos otras funciones
                             - Que una función devuelva otra función
  - Orientación a objetos:   Hoy en día en Java puedo montar un programa sin una sola clase / sin una sola función!
                             SACRILEGIO !!!!!
- Lenguaje compilados vs Interpretados:
  - Compilados: C, C++, C#, Fortran, ADA
  - Interpretados: JS, php, python
  Java es las 2 cosas: Compilado + interpretado

    Ficheros.java --- javac ---> Ficheros .class  ----> Interpretado por una JVM
                                Lenguaje byte-code

  Cuales son mejores? 
  - Beneficios de los lenguajes Compilados / del proceso de compilación?
    Detectar cierto tipo de errores antes de la ejecución del programa
  - Cosas negativas/Dificultades de los lenguajes Compilados / del proceso de compilación?
    Compilamos contra un SO / Arquitectura de microprocesador -> Acabe con muchos binarios compilados -> Dificulta la gestión
    Es un paso más a la hora de ejecutar un software... más tedioso el proceso.

  - Beneficios de los lenguajes interpretados?
    No dependo de el SO / arquitectura de destino. Lo que mando es el fuente...
    Más vale que en la máquina de destino haya un intérprete adecuado.
    No requieren de compilación. Más cómodo a la hora de trabajar
  - Cosas negativas/Dificultades de los lenguajes interpretados
    Al no haber compilación, pierdo la oportunidad de detectar un montón de errores que sola van a dar la cara al ejecutar

- Lenguajes de tipado estático / dinámico
  - Lenguajes de tipado estático: JAVA, C
  - Lenguajes de tipado dinámico: JS, python
  
  Beneficios del tipado estático: En proyectos grandes tan solo al ver la definición de funciones, variables,
    tengo claro lo que debo suministrar(tipo). En los lenguajes de tipado dinámico no... 
    Y eso los convierte en lenguajes INUTILIZABLES EN PROYECTOS GRANDES
    
    De hecho, los lenguajes tradicionales de tipado dinmámico han tenido que "inventarse" mecanismos para dar información de tipos
    y poder usarse en proyectos grandes:
    ```py
        numero = 7
        numero:int = 7  # Aunque esto en python vale para poco. Tan solo a nivel informativo para el desarrollador
        numero = "hola" # Esto traga... pero bien !
    ```
    En Javascript de hecho ha sido más sangrante... se han inventado un lenguaje nuevo por encima de JS para dar información de tipos:
    Typescript (.ts) ---> transpilación Javascript(.js)
    
    Durante la transpilación, aprovechamos a validar los tipos

  Beneficios del tipado dinámico: Sencillez
  
    ```java
    String texto = "hola";   // Statement                                       HORRIBLE
    Cuadrado c1 = new Cuadrado(5);                                              MAS QUE HORRIBLE
    
    Map<String,List<String>> miLista = new HashMap<String,List<String>>();      MIERDA GIGANTESCA
    Map<String,List<String>> miLista = new HashMap<>();                         SUPER MIERDA GIGANTESCA
                                                                                donde defino el tipo del dato? en la variable?
                                                                                
    var miLista = new HashMap<String,List<String>>();                           LEGIBLE!               J10                                                            
    ```

Todas son expresiones válidas en Java !

```js
var numero = 17 ;                                                               TIPADO DINAMICO
numero = "hola" ;   // PERFECTO
```
```java
var numero = 17; Desde Java 10 perfectamente válida                             TIPADO ESTATICO + INFERENCIA DE TIPOS
// numero es una variable de tipo: int
numero = "texto" ;  // OSTION EN TODOS LOS MORROS... Me da un error en tiempo de COMPILACION !
```

Son iguales esas 2 lineas de código? A la vista si... Pero se comportan muy diferente

# Inferencia de tipos

Capacidad del lenguaje para identificar en base a la sintaxis un tipo de datos. 

# Variable?

√ Una referencia a un objeto que tengo almacenado en memoria.
x Un almacen de datos que puede tomar distintos valores. Es cierto en algunos lenguajes de programación: C
 
```java
String texto = "hola";   // Statement
texto = "adios";

Cuadrado c1 = new Cuadrado(5);
```
Cuantas partes tiene ese statement? 3

- "hola"          -> Colocar un objeto de tipo String con contenido "hola" en una ubicación de la memoria RAM
                    En JAVA, algo que va entre comillas, es de tipo String. El dato es de tipo String ***
  new Cuadrado(5) -> Colocar en memoria un objeto de tipo Cuadrado en algún sitio

- String texto    -> Define una variable que podrá apuntar a objetivos de tipo String ***

- =               -> Asignar la variable al objeto
                     Referenciar al objeto desde la variable

Cuantas partes tiene ese statement? 2

- "adios"         -> Colocar un objeto de tipo String con contenido "adios" en una ubicación de la memoria RAM
                     En el mismo sitio donde estaba "hola"? NOOOOOOO. En otro sitio distinto. Totalmente distinto.
                     
                     Cuantas cosas tengo en este momento en la memoria RAM? "hola" y "adios"
                     Y "hola" ha dejado de estar apuntado por ninguna variable -> BASURA
- texto =         -> HAce que la variable texto ahora apunte a ese otro sitio de la memoria


`texto` es una variable por qué? Porque puede dejar de apuntar a un dato (objeto) y apuntar a otro.

*** Los datos tiene su tipo
*** En java (y en los lenguajes de tipado estático) las variables tienen asociado un tipo.

# Tipado estático:

Las variables llevan asociado un tipo inmutable. Una vez definida una variable, la variable solo podrá r...


    
    
    
    
    
    

    

# Lenguajes más usados en el mundo:

- Javascript: ECMASCRIPT
- Python
....
- Java ha quedado para un nicho de mercado muy concreto....

# Cuantas JVM existen?

Me temo que montonones de montonones en cada sistema operativo.
- OracleJDK
- OpenJDK
- Eclipse Temurin
- Amazon correto

# Hace JAVA un buen uso de la memoria RAM? 

NO. JAVA hace una mierda de uso de la memoria RAM... Le hace un destrozo que te cagas.

Una app desarrollada en JAVA usa mucha más memoria RAM que si la misma app la monto en otro lenguaje: C++.

Esto está mal? Es un problema? NO... es una característica (feature)

Es algo que se decidió como criterio de diseño de JAVA.

Y entonces? por qué se hizo así?

La cuenta la vieja:

Qué me sale más barato:
1. Programadores con conceptos profundos de programación, pasando horas reservando memoria, trabajando con punteros, liberando memoria
    50 horas x 50€/hora = 2500€
2. Compar una pastilla de RAM a la máquina
    300€ 
Está claro !


# Sintaxis de JAVA

Resumiendo: LA PENSARON CON EL CULO !

Los ti@s que lo hicieron sabrían mucho de programación, no me cabe duda, pero no tuvieron el día!

Tiene tantas cagadas JAVA en su sintaxis, que de hecho han surgido NUEVAS sintaxis alternativas a JAVA, para generar byte-code.

SCALA?  Otra sintaxis alternativa a JAVA, que se usa principalmente en el mungo BIGDATA!

KOTLIN? En una alternativa a la sintaxis de JAVA. Donde expreso las cosas en lugar de usando la sintaxis de JAVA, 
usando otra sintaxis MEJOR PLANTEADA. -> Desarrollo sobre ANDROID (JAVA -> KOTLIN)
En medio del código KOTLIN puedo meter código JAVA.

ficheros kotlin -> compilar .class -> Interpretados por la JVM


# Editores/Entornos de desarrollo JAVA

- Eclipse
- IntelliJ (de JetBrains) *** No lo digo yo (que también). Lo dice alguien más respetable que yo: GOOGLE
- Rational 
- Netbeans

Antiguamente el entorno de desarrollo para apps Android era: Eclipse con las librerias de Android y un simulador de Android
Hoy en día ese entornos se llama: Android Studio = Una versión capada de IntelliJ

# Jetbrains

Compañía de desarrollo de software famosa por sus editores/entornos de desarrollo


## Cagadas de la sintaxis de JAVA

- Muy verboso.... pero muy verboso.... Y es verdad

### setter y getter

Es una mierda. Y los de JAVA me lo venden como: ENCAPSULACION DEL CODIGO

Es verdad? que la encapsulación es tan importante? No es tan importante, ES MAS IMPORTANTE ! ULTRAIMPORTANTE

Es buena la forma en la que en JAVA se consigue la encapsulación: NO, ES UNA MIERDA DEL 15


```java

// Dia 1
public class Rectangulo {
    
    public int base;
    public int altura;
    
    public Rectangulo(int base, int altura){
        this.base = base;
        this.altura = altura;
    }
    // Dia 101 a mi se me ocurre la brillante idea de quererme asegurar de que el valor de base sea > 0
    // Qué tengo que hacer? Poner la variable como privada y montarle un getter y su SETTER donde pondría la validación
    // Pero si hago eso, que va a pasar? Que los Millones de programadores WorldWide que han usami mi clase ME CRUCIFICAN !!!!
    // Dejo a todo el mundo si que su código compile. INACEPTABLE !
    // Solución en el mundo JAVA: Desde el día 1 monta getter y setter aunque no los vayas a utilizar... por si acaso... mañana...

}

....

//Dia 2-100 ... Millones de programadores WorldWide usando mi clase... y escribiendo código como este: 

Rectangulo r1 = new Rectangulo(4,5);

System.out.println(r1.base);
r1.base = 7;
System.out.println(r1.base);

```


```java
// Dia 1
public class Rectangulo {
    
    private int base;
    private int altura;
    
    public Rectangulo(int base, int altura){
        this.setBase(base);
        this.setAltura(altura);
    }
    
    public int getBase(){
        return this.base;
    }
    
    public void setBase(int base){
        // Dia 101 a mi se me ocurre la brillante idea de quererme asegurar de que el valor de base sea > 0
        // Sin que nadie te cruja!
        return this.base=base;
    }
    
    public int getAltura(){
        return this.altura;
    }
    
    public void setAltura(int altura){
        return this.altura=altura;
    }

}
// Buenas prácticas. MANTENIBILIDAD DEL CODIGO !

....
// Dia 2-100 ... Millones de programadores WorldWide usando mi clase... y escribiendo código como este: 

Rectangulo r1 = new Rectangulo(4,5);

System.out.println(r1.getBase());
r1.setBase(7);
System.out.println(r1.getBase());

```

Por ejemplo, en C# (no obstante lo llaman el JAva bien hecho) o en python tenemos el concepto de properties.

### Admite JAVA valores por defecto en los argumentos de una función.

```java
public void informe(String titulo, Object datos, boolean imprimir){
    ...
}
public void informe(Object datos, boolean imprimir){
    informe("Informe del año", datos, imprimir);
}
public void informe(String titulo, Object datos){
    informe(titulo,  datos, true);
}
public void informe(Object datos){
    informe(datos, true);                                   POLIMORFISMO DE JAVA !!!!
}
```

El problema es que estamos tan acostumbrados a esto.... que ni nos planteamos que son CHAPUZAS GIGANTESCAS !

Mucha gente si que se lo ha planteado... y se han pirado de JAVA a otros lenguajes, con una sintaxis más pensada!

### El uso de null (no es exclusivo de JAVA... muchos lenguajes tienen problemas con esto)

- Libreria: Diccionario (el nuestro de español tiene: 650k)

public interface Diccionario {
    
    boolean existe(String palabra);
    
    Optional<List<String>> getSignificados(String palabra);
    
        Esta función devolverá una lista con los significados del término... si el término existe....
        de lo contrario devolverá? 
        - Lista vacia
        - null
        - Lanzará una Excepcion
    
        Y cualquier de esas opciones es un comportamiento "mágico"... qué quiero decir con "mágico":
        Que de ningún sitio de esa linea puedo deducir el comportamiento de la función.
        Solo me queda una cosa por hacer? IR A LA DOCUMENTACION / IMPLEMENTACION
        
        Tendré acceso a la implementación? Quizás si... quizás no 
        Tendré que ir a la Documentación.. si es que se han dignado!
            Es más... quién se lee una docu en 2023? en serio? 
            
        CAGADA DEL LENGUAJE !
        
        Serían buenas decisiones:
        
        - Devolver una lista vacia? NO, ya que pareciera que esa palabra es como cualquier otra palabra
            con sus definiciones... pero no es así. Deberñia tener un comportamiento diferente al de una
            palabra que si exista.
        
        - Devolver null?            NO, y donde me explican que eso puede devolver null? Lo adivino???
        
        - Lanzar una exception?     NO, ya que la excepciones son para controlar problemas que no puedo evitar
                                    Fuera de mi control.
                                    Lanzar una exception en JAVA es barato (coste computacional) NOOOOOO
                                    Regla de oro: NUNCA DEBO implementar lógica mediante excepciones!
        
        Y por ello, las hemos encontrado y usado todas, a lo largo de los años.
        
    List<String> getSugerencias(String pseudopalabra);  // zanahorio     // manana. // akjrekdiu
    
        Esta función devolverá una lista con las sugerencias de la "palabra"... Y si no encuentro sugerencias:
        devolveré una lista vacia.  Da igual que haya 5, que 1' que 15 que ninguna sugerencia.
        El programa será el mismo

    
}

Hay un programita que hoy en dia usan TODAS LAS EMPRESAS DEL MUNDO que hace una revisión del código: SONARQUBE
Y si ve ese código, me lo escupe a la cara, me dice que es una mierda (literalmente)
y ese código no pasa a producción. Ni de coña! 
Y puedo llorarle a San Pedro... que ese codigo no pasa !

### Modificadores de privacidad
                            
public                      Lo que se es accesible para todo el mundo
private                     Lo que sea es accesible dentro de la clase
no poner nada (default)     Lo que sea es accesible dentro del paquete
protected                   Lo que sea es accesible dentro del paquete y en clases que hereden

Son suficientes? o son demasiados? 
Los debemos usar todos.... y no solo eso.. ME FALTAN !!!!

Imaginad un programa: Libreria que ofrezca diccionarios de términos en multiples idiomas:

- Interfaz que se llame: Diccionario
- Clases que implementen Diccionario: 
    - DiccionarioCargadoDeBBDD
    - DiccionarioCargadoDeFichero
    - DiccionarioATravesDeServicioWeb
- Necesitaré un método llamado:          
        static Optional<Diccionario> getDiccionario(String idioma)
    que tipo de función...?

    SuministradorDeDiccionarios.getDiccionario("ES");


src/
    com/
        diccionario/
                    Diccionario.java        INTERFAZ
                    Suministrador.java      CLASE
                        new AlgunaImplentacionDeDiccionario();
                    impl/
                        public DiccionarioCargadoDeBBDD.java
                        public DiccionarioCargadoDeFichero.java
                        public DiccionarioATravesDeServicioWeb.java
----> diccionario-libreria-guay-v1.jar

Puede ese alguien crear una instancia de DiccionarioCargadoDeBBDD?
                                    o de DiccionarioCargadoDeFichero?
Pues claro que puede,por qué? Pues porque esas clases sono PUBLICAS !
    Esto tiene sentido? 
    Tienen si quiera otros programas externos a mi libreria tener conciencia 
    y constancia de que esas clases EXISTEN? NO, ni de coña! Y esto era irresoluble hasta Java 9

Donde no se ha metido un nuevo modificador de privacidad... MUCHO MAS GORDO

    modulo    >    paquetes      >      clases o interfaces
    module-info.java

    module{
        requires
        uses
        provides
        exports
    }


---

# Versiones de JAVA

JAVA lo monta/crea ?    Sun Microsystems (empresa ampliamente querida en el mundo de la informática)
                        Famosa por sus computadoras empresariales(servidores) BRUTALES
                        Con su propia arquitectura de microprocesaro: Sparc 
                        Con su propio sistema operativo: Solaris (UNIX®)

version 1.0         1996        
version 1.1         1997 
version 1.2         1998
versión 1.3         2000
versión 1.4         2002
versión 1.5         2004
versión 1.6         2006
<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< compra de Sun microsystems por parte de ORACLE (empresa muy poco querida en el mundo de la informática)
                                por qué lo compra? Le importaba JAVA? Ni un poquito.
                                Solo le importaba Los ordenadores + SO (Solaris) > exadata 
                                
                                HP  = software + hardware
                                IBM = software + hardware
                                
                                qué paso con JAVA?
versión 1.7         2011    + 5 años
                                        LA gente se empieza a pirar de JAVA y a encabronar con Oracle
versión 1.8         2014    + 3 años
                <<<< La segunda muerte de JAVA: Oracle se le ocurre la brillante idea de anunciar:
                                                    JVM se hace de pago:
                                                    - Para un usuario 25$/año
                                                    - Para un servidor: 50$/core/año
                                                Esto es peor que meter un lobo en un gallinero!
                                        Hubo una empresa que plantó cara a Oracle: GOOGLE
version 9           2017    + 3 años
                                Se llegaron a muchos acuerdos.
                                1º Convertir JVM en un estandar, de libre implentación  > OpenJDK
                                Se acuerda una nueva forma de versionar JAVA: Cada 6 meses tiene que salir una versión de JAVA
version 10          2018    + 6 meses
version 11          2018    + 6 meses
--------------------------------------------------------
version 12          2019    + 6 meses
version 13          2019    + 6 meses
version 14          2020    + 6 meses
version 15          2020    + 6 meses
version 16          2021    + 6 meses
version 17          2021    + 6 meses
version 18          2022    + 6 meses
version 19          2022    + 6 meses
version 20          2023    + 6 meses


                                

# Para qué se usaba JAVA en lo albores de los 2000 ?

En esa época todo el mundo hablaba de JAVA y quería usar JAVA... y se usaba java para todo?
x Aplicaciones de escritorio... hoy en día nop
- Apps web:
  - Applets -> Ruina chascazo !
  - J2EE -> JEE 
  Hoy en día hay una separación muy clara entre:
  - Backend: JAVA <~ Nicho que le queda a Java... su último bastión
        Microservicios 
  x FrontEnd:  JS
x Desarrollo Android ~> Kotlin -> JVM
x Sistemas embebidos

Mucha gente que estaba en JAVA se ha ido a otros lenguajes:
- Microsoft: .net C# (para MI: a día de hoy es el lenguaje de programación con la gramatica más completa que existe)
    Cerrada totalmente > abrirse al mundo: 
    .net Framework ~> .net core OPENSOURCE APACHE ~> compiladores a Windows, MacOS, Linux
    La apuesta de microsft por linux es gigante. De hecho hoy en día puedo corre un kernel linux dentro de windows wls2
        + Se cargó su sistema de control de versiones TFS ~> git (github que hoy en día es propiedad de Ms)
                Stackoverflow:
                    95% de los desarrolladores usan git
                     4% nada
                     1% subversion
- JS > Sufre una revolución al aparecer NodeJS + ECMAScript:
        El antiguo interpreta de JS que existía en el navegador Chromium (OS de Chrome) <<< GOOGLE !
                                                                  ||
                                                                Opera
                                                                Safari
                                                                Edge
                                                                                Firefox !!!!
        Es posible montar cualquier tipo de App con JS
        NodeJS es el equivalente a la JVM 

# JEE

~~Java Enterprise Edition~~ --- YA NO

Jakarta Enterprise Edition: 

Es una colección de ESTANDARES acerca de cómo hemos de montar apps java para su uso empresarial:
- Concepto de Servidor de aplicaciones JAVA: 
  - Servidores de apps java de clase web: TOMCAT
  - Servidores de apps java de clase empresarial: 
    - Weblogic (Oracle)
    - Websphere (IBM)
    - JBoss (Redhat) >>>> Wildfly
- Como montar programas que sean invocados desde un serv de apps: servlet, JSP, ...
- JMS
- JDBC
- JPA

# Oracle = Los "TO LO QUE TOCO LO JODO" !!!!!!

A Oracle solo le interesa una cosa: Su BBDD (que no hay mejor BBDD Relaccional que Oracle Database)

MySQL   >  Oracle.... dejarla morir... no le mete pasta... ni desarrollo... ni na'
  ~> MariaDB

OpenOffice (sun, opensource... versión de pago StarOffice) > Oracle ... lo deja morir.      ~> Librera el proyecto
  ~> LibreOffice
 
Hudson  > Oracle.... y ya podeis imaginar el resultado
  ~> Jenkins