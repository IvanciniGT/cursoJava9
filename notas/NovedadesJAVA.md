# Novedades importantes JAVA / HITOS

## Java 1.5

- Anotaciones: Código con instrucciones que damos al COMPILADOR de JAVA
- Iterable

## Java 1.8

- Soporte a la programación funcional: 
    - Un nuevo paquete en el api: java.util.function
    - Expresiones lambda
    - Un nuevo operador ::                          Referenciar una función
    - Un cambio gigante en las Coleciones: List, Map, Sets
        - java.util.stream
                            Stream
                                    Da soporta a la programación MapReduce
- Un nuevo api para gestión de fechas y horas
    Hasta entonces: 
        - java.util.Date : Millis
        - Calendar
        - GregorianCalendar
        - java.sql.Date

- Capacidad de escribir funciones estáticas publicas en interfaces.
  Para qué sirve esto? Es útil?
- Capacidad de crear funciones de instancia con código por defecto
- Optional
- La capacidad de definir anotaciones en los argumentos de una función LOMBOK (@NonNull)

## JAVA 9

- Las funciones estáticas .of de todas la interfaces de Collections: Set, Map, List...
- Capacidad de escribir funciones estáticas privadas en interfaces.
  Para qué sirve esto? Es útil?
- Modulos
  - Uso del ServiceLoader
  - Inyeccion de dependencias

## JAVA 10

- Uso de la palabra var en algunos escenarios, para evitarnos escribir el tipo...
  AUNQUE SE INFIERE

## JAVA 11

- Posibilidad de ejecutar directamente ficheros JAVA sin compilarlos.
    Notas: Para qué se ha metido esto? Para atraer a JAVA a los PYTHONEROS y JS
- Un tio / tia que desarrolle un proyecto en JAVA, compila con JAVAC? 
    En que año estamos? 
    Qué tipo de proyecto estamos montando? 
    Con que compilo?    mvn , gradle, sbt
    Gestores de proyecto.
    NO SE TRATA SOLO DECOMPILAR CODIGO:
    - Gestionar dependencias
    - Copiar recursos de unas carpetas a otras
    - Empaquetar
    - y más...
- String : Función lines() -> Stream con las lineas