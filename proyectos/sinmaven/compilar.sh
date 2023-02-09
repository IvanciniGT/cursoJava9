javac -d compilado \
      --module-source-path src \
      src/diccionario/module-info.java \
      src/diccionario/com/curso/diccionario/*.java \
      src/diccionarioFicheros/module-info.java \
      src/diccionarioFicheros/com/curso/diccionario/ficheros/*.java \
      src/app/module-info.java \
      src/app/com/curso/app/*.java 
      
java  \
      --module-path compilado \
      -m app/com.curso.app.App \
      ES manzana
      
      