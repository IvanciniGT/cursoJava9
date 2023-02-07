javac -d compilado \
    --module-source-path . \
        moduloa/module-info.java \
        moduloa/paquete1/*.java  \
        modulob/module-info.java \
        modulob/paquete2/*.java  \
        modulob/paquete2/impl/*.java
        
java --module-path compilado \
     -m moduloa/paquete1.App