Libreria que permite trabajar con diccionarios en multiples idiomas

Quiero una implementación de esa libreria de forma que los diccionarios
se carguen desde ficheros de texto:

TERMINO=Definicion1 | Definicion2 | Definicion3

Posiblemente el dia de mañana (no va a ser verdad) montemos otras implementaciones
de esta libreria, por ejemplo, sacando los términos de los diccionarios de una BBDD

Por otro lado queremos una aplciacion de consola, que permita a un usuario 
introducir una palabra, y un idioma al llamar a la aplicacion
Y ésta muestre Si la palabra existe en el diccionario del idioma suministrado
Y en caso de existir, sus definiciones.
Pero en caso de no existir, porisbles correccciones ortográficas.

El diccionario debe comportase IGNORE CASE

Manzana
Existe: Es la fruta del manzano

Manana
No existe: quizas quisiste decir: manzana o mañana

--- 
Para que podría ser útil nuestra libreria,
- aparte de para montar nuestra app de consola
- En una app web, en cualquier caja de búsqueda, mostrar posibles correciones
- En una app desktop, subrayar palabras no reconocidas y con un menu flotante sugerir correcciones
- No le vamos a meter texto predictivo


Cuantos proyectos JAVA diferentes QUIERO/VOY A montar: 3 proyectos 
Que van a ir a 3 repositorios de contro de versión GIT
Compilables de forma "independiente"

Libreria: diccionario = MODULO
    paquete: com.curso.diccionario
                Interfaz Diccionario                                            Inversion de dependencias
                    boolean existe(String palabra)
                    Optional<List<String>> getSignificados(String palabra)
                    List<String> getSugerencias(String palabra)
                Interfaz SuministradorDeDiccionarios
                    boolean existeDiccionario(String idioma)
                    Optional<Diccionario> getDiccionario(String idioma)
        modulo: 
            exporta? com.curso.diccionario
            requiere? NADA
            provee?   NINGUNO
    NADA MAS !

    ----> compilar y meter en un JAR : diccionario-1.0.0.jar
        Que tengo en ese JAR? PURAS INTERFACES 
              Algo de código? NO, que alegría !!!!!!!
                              Tengo un API limpio y bien definido

Implementación 1 de la libreria: Que cargue los diccionarios desde ficheros = MODULO
    paquete: com.curso.diccionario.ficheros
                Clase DiccionarioDesdeFichero implementa Diccionario
                Clase SuministradorDeDiccionariosDesdeFichero implementa SumisnitradorDeDiccionarios
        modulo:
            exporta? NADA
            requiere? del modulo diccionario
            provee?  Un SuministradorDeDiccionario, 
                            a través de la clase SuministradorDeDiccionariosDesdeFichero

    NADA MAS !

    ---> Compilar y meter en un jar: diccionario-ficheros-1.0.0.jar
        Que tengo en ese JAR: PURAS IMPLEMENTACIONES

App consola
    paquete: com.curso.app
            Clase App
                main
        modulo:
            exporta? NADA
            requiere? del modulo diccionario
            provee? NADA
            que consume? Un SuministradorDeDiccionarios
    NADA MAS !

    ---> Compilar y meter en un jar: diccionario-app-consola-1.0.0.jar
        Que tengo en ese JAR: Una app

Donde digo en la app de consola que el Suministrador de diccionarios que voy a usar es el de ficheros?

    EN NINGUN LAO !

Y cual se tomará? 
    El del .jar que haya en el classpath EN AUTOMATICO 
    Y si el dia de mañana quiero usar otra implementacion de la libreria de diccionarios que tendré que hacer?
        Sustituir un jar por otro.... Y tengo que cambiar codigo? NO.... BRUTAL !
        
    Decide la App de Consola qué impleemntación de la libreria va a usar? NO... se la INYECTAN
                                                                          Inyección de dependencias

ESO ES UNA APP MODULAR Y MANTENIBLE !


## Estructura de carpetas y Archivos:
src
├── app
│   ├── com
│   │   └── curso
│   │       └── app
│   │           └── App.java
│   └── module-info.java
├── diccionario
│   ├── com
│   │   └── curso
│   │       └── diccionario
│   │           ├── Diccionario.java
│   │           └── SuministradorDeDiccionarios.java
│   └── module-info.java
└── diccionarioFicheros
    ├── com
    │   └── curso
    │       └── diccionario
    │           └── ficheros
    │               ├── Diccionario.java
    │               └── SuministradorDeDiccionarios.java
    └── module-info.java
