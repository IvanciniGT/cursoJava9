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
    Era el antiguo proyecto joda-time de JAVA
    - LocalDate
    - LocalDateTime
    - ZonedDateTime
    - Instant : Date -> LocalDate, ZonedDateTime

- Capacidad de escribir funciones estáticas publicas en interfaces.
  Para qué sirve esto? Es útil?
- Capacidad de crear funciones de instancia con código por defecto en interfaces
- Optional
- La capacidad de definir anotaciones en los argumentos de una función LOMBOK (@NonNull)

## JAVA 9

- Las funciones estáticas .of de todas la interfaces de Collections: Set, Map, List...
    Las colecciones creadas por erstas funciones son INMUTABLES !
- Capacidad de escribir funciones estáticas privadas en interfaces.
- Modulos
  - Uso del ServiceLoader
  - Inyeccion de dependencias
- Jshell

## JAVA 10

- Uso de la palabra var en algunos escenarios, para evitarnos escribir el tipo...
  AUNQUE SE INFIERE


    var numero = 17;
    var text = "Hola";
    var cache = new HashMap<String,List<String>>();

    var dato = prepararInforme();     // MUY MALA PRACTICA ! 
      // A priori no se que dato tiene... Me toca investigar

- Las funciones estáticas .copyOf de todas la interfaces de Collections: Set, Map, List...
    Las colecciones creadas por erstas funciones son INMUTABLES !
- Optional
          miOptional.orElseThrow().llamoAUnaFuncionDelDAto()

## JAVA 11

- Posibilidad de ejecutar directamente ficheros JAVA sin compilarlos.
    Notas: Para qué se ha metido esto? Para atraer a JAVA a los PYTHONEROS y JS
- La posibilidad de usar la palabra var en las expresiones lambda


    (dato) -> dato.toUpperCase()
    (@NonNull var dato) -> dato.toUpperCase()       //COmodo
    (@NonNull String dato) -> dato.toUpperCase()


- Lectura y escritura directa de archivos con Files.writeString Files.readString
- String : Función lines() -> Stream con las lineas
- String : Función isBlank() 
- API cliente HTTP basado en patrones builder y programación funcional !


    HttpRequest miRequest = HttpRequest.newBuilder()
                                        .POST()
                                        .uri("http://miempresa.com/api/v1/endpoint")
                                        .header("clave","valor")
                                        .header("clave","valor")
                                        .header("clave","valor")
                                        .build();
