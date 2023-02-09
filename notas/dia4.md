# MAVEN

Gestor de proyecto. Nos ayuda:
- Con las dependencias
- Arquetipos de maven (plantillas de proyecto)
- Compilar y empaquetar el proyecto
    - jar   Librerias o Aplicaciones ejecutables desde SO
    - war   Aplicacion web JEE -> Servidor de aplicaciones JAVA
    - ear   Aplicaciones web de clase Empresarial (JEB + wars) -> Servidor de aplicaciones JAVA
    - pom   Empaquetar un proyecto java organizado en modulos, como el nuestro
- Y otras !

El archivo donde configuramos todas las cosas que hemos enumerado ahi arriba es el archivo pom.xml

La funcionalidad de MAVEN se consigue a través de plugins.
- Compilación es un plugin
- El que ejecuta las pruebas unitarias: plugin
- El que genera un informe de pruebas: otro plugin (surefire)
- Mandar mi proyecto a sonarqube: otro plugin 

Cuando quiero que maven haga alguna tarea, esas tareas se las pido por linea de comando: GOALS
- clean
- resources
- compile
- test-compile
- test
- package
- install

Maven exige una determinada estrcutura de carpetas en el proyecto. 
Es configurable... pero TODO EL MUNDO USA LA MISMA
pa que liarme reinventando la rueda. ES UN ESTANDAR DE FACTO.

proyecto
 |
 |---src                    # Codigo de la app
 |    |-main
 |    |   |-java            # Codigo JAVA de la app
 |    |   |-resources       # Ficheros de configuración, y otros recursos usados por nuestra app (diccionario ES)
 |    |   |-webapp          # Codigo JEE de una app (JSPs, WEB-INF...)
 |    | 
 |    |-test
 |        |-java            # Codigo JAVA de las pruebas de la aplicación
 |        |-resources       # Ficheros de configuración, y otros recursos usados por las pruebas de nuestra app
 |
 |---target
 |    |----classes
 |    |----test-classes
 |    |----surefire-reports
 |    |----ARCHIVO.jar
 |
 |-- pom.xml                # Contiene la configuración MAVEN de nuestro proyecto

mvn clean               Eliminar la carpeta target/
mvn resources           Copia todo los que hay dentro de src/main/resources a target/classes
mvn compile             Compilar todo lo que hay dentro de src/main/java a target/classes
mvn test-resources      Copia todo los que hay dentro de src/test/resources a target/test-classes
mvn test-compile        Compila todo los que ha dentro de src/test/java a target/test-classes
mvn test                Ejecuta lo que hay dentro de target/test-classes
                        Genera un informe de pruebas 
mvn package             Empaqueta lo que hay dentro de target/classes en un jar que deja en target/
mvn install             Copia el archivo .jar o .war o .ear en el directorio ~/.m2

Directorio ~/.m2        Directorio donde maven guarda los proyectos / Artefactos que ha descargado y 
                        pueden usados en otros proyectos

Coordenadas de un proyecto en maven: Cómo se identifica un proyecto en maven:
- grupo         Agrupación logica de proyectos
- artefacto     Un proyecto concreto de ese grupo
- version       Version del proyecto

version: 3.4.5
                Cuando se incrementa?
3 => Mayor      Rediseño del sistema que puede implicar NO RETROCOMPATIBILIDAD
4 => Minor      Incremento de funcionalidad
5 => Micro      Al arreglar un bug

# GIT 

nuestro proyecto ahora tiene:

PROYECTO PRINCIPAL                  >                       REPO git 
    Agrupacion de modulos java
    MODULO app                      > REPO git              submodules git
    MODULO diccionario              > REPO git              submodules git
    MODULO diccionarioFicheros      > REPO git              submodules git
    
    
# Metodologías ágiles

Entrega del producto de forma incremental
- Dia 15 del proyecto voy a hacer la 1ª entrega en producción. Quiero una entrega 100% funcional
    Ojo, quizás solo con un 5% de la funcionalidad          Pruebo el 5%
- Dia 30 del proyecto voy a hacer la 2ª entrega en producción. Quiero una entrega 100% funcional
    Ojo, quizás solo con un +5% de la funcionalidad         Pruebo el 5% + lo de antes
.....

30 instalaciones depués llegaré al 100% o no!

¿Cuántas instalaciones en producción hacia con las metodologias en cascada? 1
¿Y ahora? Cada 15 dias
Y de donde saco la pasta ????????
¿Cuántas veces hacia las pruebas con las metodologias en cascada? 1
¿Y ahora? Cada 15 dias
Y de donde saco la pasta ????????

NO HAY PASTA PARA ESTO. NO LA HAY !!!!!!!

Solo hay una alternativa: AUTOMATIZAR !
Automatizar quñe: TODO: test, instalaciones, TODO !

DEV ---> OPS? Cultura de la automatización 

# JSHELL

Consola interactiva para JAVA:
- Para hacer pruebas                        x
- Para hacer codigo exploratorio            x
- Para montar scripts


Testers
    Lanzar un test con Selenium > SCRIPT
Sysadmin
    Crear uans carpetas y unas cosas > SCRIPT
Analisis de datos 
    Algoritmo de Machine Learning > SCRIPT
    
.bat
.sh
.py
