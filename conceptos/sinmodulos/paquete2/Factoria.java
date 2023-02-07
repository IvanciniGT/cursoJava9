package paquete2;

import paquete2.impl.ClaseQueImplementaInterfaz1;
import paquete2.impl.ClaseQueImplementaInterfaz2;

public interface Factoria {
    
    public static Interfaz dameImplementacion1(){
        return new ClaseQueImplementaInterfaz1();
    }
    
    public static Interfaz dameImplementacion2(){
        return new ClaseQueImplementaInterfaz2();
    }
    

}

