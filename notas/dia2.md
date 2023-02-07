Los Streams en JAVA permiten programación MAP-REDUCE
Funciones tipo MAP:
- map
- flatMap
- filter
- sort
- ...

Funciones reduce:
- reduce
- foreah
- collect
- ...

Un stream es una secuencia de valores (datos)
a los que les puedo aplicar funciones map y reduce

Funciones map: me devuelven otro STREAM
Funciones reduce: ya no me devuelve un STREAM

Una forma común de operar es sobre un STREAM =
secuencia de datos, aplicarle un monton de funciones MAP
Y acabar con una función de tipo REDUCE

FUNCION MAP:

doblar

Conjunto original   ---> funcion mapeo ----> Conjunto destino
1                                               doblar(1) --> 2
2                                               doblar(2) --> 4
3                                               doblar(3) --> 6

----
Cambio de arquitectura que hemos planteado en las aplicaciones

Antaño montábamos aplicaciones MONOLITICAS

Servidores de apps gordos: WEBLOGIC , WEBSPHERE, JBOSS

Con el tiempo nos dimos cuenta de que NO ES UNA BUENA FORMA DE TRABAJAR

Problemas tienen las apps monolíticas:
- Muy dificiles de mantener. Cualquier cambio puede afectar a TODA LA APP
                             Cualquier cambio implica distribuir TODA LA APP
- Escalabilidad. No puedo escalar una parte concreta de mi app. 
                 Tengo que escalarla en su conjunto
- Dificiles de evolucionar.  No puedo evolucionar un componente de forma aislada.

Hoy en día planteamos otros MODOS (arquitecturas) a la hora de crear apps.

Montamos aplicaciones   con COMPONENTES DEBILMENTE ACOPLADOS.
                        con una INTERFAZ DE COMUNICACION MUY CLARA Y DEFINIDA (API).

Dentro de las arquitecturas de desarrollo de apps que usamos hoy en día, la de 
MICROSERVICIOS se ha impuesto. Pero esa es solo una más que tiene en consideración los 
puntos anteriores.

En JAVA surje el concepto de MODULO


---
Manifiesto agil:

> El software funcionando es la medida principal de progreso.

Cómo se media antes el grado de progreso de un proyecto? Cómo va el proyecto?   JEFE DE PROYECTO
- Clasicos: Preguntabam al equipo de desarrollo. Martuki, como vas con los 3 requisitos que tenias que implementar.
  Y martuki, al gual que TODOS los desarrolladores del mundo, miente más que habla !!
  Cuidao, que es buena gente... y muchas veces se miente la primera a si misma... No es consciente ni de estar mintiendo
  Lo hace si acritud !
- Flipaos!
  - Cuantas lineas de código se han escrito una semana!
  
Hoy en día EL SOFTWARE FUNCIONANDO es la MEDIDA DE PROGRESO
                            vvv
                        que no falla y hace lo que tiene que hacer

Y eso quien lo dice? los desarolladores? NO 
Las PRUEBAS , los TEST

Cuantas pruebas había definidas: 300
Cuantas se han superado: +150
---
Sonarqube calcula un parámetro llamado:
- Complejidad ciclomática: Número de caminos que puede tomar un trozo de código
- Complejidad cognitiva: Cómo de dificil es para un ser humano entender ese código

tarea1
if condicion1
    tarea2
    if condicion2 
        tarea3
    else if condicion3
        tarea4
else 
    if condicion4
        tarea5
    else if condicion5
        tarea6

Complejidad ciclomática: 6 = NUMERO MINIMO DE PRUEBAS QUE TENGO QUE HACER 
    tarea1? 
    tarea1 tarea2
    tarea1 tarea2 tarea3
    tarea1 tarea2 tarea4
    tarea1 tarea5
    tarea1 tarea6

Complejidad cognitiva: NO ES NADA FACIL

switch(variable1)
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case default:
    
Ciclomática: 7
Complejidad cognitiva: CHUPAO !
